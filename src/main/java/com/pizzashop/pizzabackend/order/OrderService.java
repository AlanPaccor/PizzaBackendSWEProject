
package com.pizzashop.pizzabackend.order;

import com.pizzashop.pizzabackend.customer.Customer;
import com.pizzashop.pizzabackend.customer.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderService(
            OrderRepository orderRepository,
            CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Order createOrder(CreateOrderRequest request) {

        Customer customer = customerRepository
                .findById(request.customerId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Customer not found"));

        if (request.items() == null || request.items().isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Order must contain items");
        }

        if (!List.of("CASH", "CHECK", "CREDIT")
                .contains(request.paymentMethod())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid payment method");
        }

        Order order = new Order();
        order.setCustomer(customer);
        order.setPaymentMethod(request.paymentMethod());

        BigDecimal total = BigDecimal.ZERO;

        for (CreateOrderRequest.ItemRequest requestedItem : request.items()) {

            if (requestedItem.quantity() <= 0
                    || requestedItem.quantity() > 100
                    || requestedItem.unitPrice() == null
                    || requestedItem.unitPrice().signum() < 0) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Invalid order item");
            }


            OrderItem item = new OrderItem();

            item.setItemName(requestedItem.itemName());
            item.setQuantity(requestedItem.quantity());
            item.setUnitPrice(requestedItem.unitPrice());

            item.setSize(requestedItem.size());
            item.setCrust(requestedItem.crust());
            item.setSauce(requestedItem.sauce());
            item.setPrice(requestedItem.unitPrice());

            order.addItem(item);


            total = total.add(
                    requestedItem.unitPrice().multiply(
                            BigDecimal.valueOf(requestedItem.quantity())));
        }

        order.setTotalPrice(total);
        return orderRepository.save(order);
    }

    public List<Order> getCustomerOrders(Long customerId) {
        return orderRepository
                .findByCustomerIdOrderByCreatedAtDesc(customerId);
    }
}
