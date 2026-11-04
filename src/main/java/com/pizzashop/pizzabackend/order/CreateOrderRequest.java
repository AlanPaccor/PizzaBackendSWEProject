
package com.pizzashop.pizzabackend.order;

import java.math.BigDecimal;
import java.util.List;

public record CreateOrderRequest(
        Long customerId,
        String paymentMethod,
        List<ItemRequest> items
) {
    public record ItemRequest(
            String itemName,
            int quantity,
            BigDecimal unitPrice,
            String size,
            String crust,
            String sauce
    ) {}
}
