
package com.pizzashop.pizzabackend.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:5173")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(
            @RequestBody CreateOrderRequest request) {

        Order savedOrder = orderService.createOrder(request);

        return ResponseEntity.ok(
                OrderResponse.from(savedOrder)
        );
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderResponse>> getCustomerOrders(
            @PathVariable Long customerId) {

        List<OrderResponse> orders = orderService
                .getCustomerOrders(customerId)
                .stream()
                .map(OrderResponse::from)
                .toList();

        return ResponseEntity.ok(orders);
    }
}
