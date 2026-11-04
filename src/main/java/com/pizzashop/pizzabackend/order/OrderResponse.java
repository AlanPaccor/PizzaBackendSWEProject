
package com.pizzashop.pizzabackend.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderResponse(
        Long id,
        Long customerId,
        BigDecimal totalPrice,
        String paymentMethod,
        String status,
        LocalDateTime createdAt,
        List<OrderItemResponse> items
) {
    public record OrderItemResponse(
            Long id,
            String itemName,
            int quantity,
            BigDecimal unitPrice,
            String size,
            String crust,
            String sauce
    ) {}

    public static OrderResponse from(Order order) {
        List<OrderItemResponse> items = order.getItems()
                .stream()
                .map(item -> new OrderItemResponse(
                        item.getId(),
                        item.getItemName(),
                        item.getQuantity(),
                        item.getUnitPrice(),
                        item.getSize(),
                        item.getCrust(),
                        item.getSauce()
                ))
                .toList();

        return new OrderResponse(
                order.getId(),
                order.getCustomer().getId(),
                order.getTotalPrice(),
                order.getPaymentMethod(),
                order.getStatus(),
                order.getCreatedAt(),
                items
        );
    }
}
