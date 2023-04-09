package com.github.sonus21.readwrite.controller;

import com.github.sonus21.readwrite.aop.Database;
import com.github.sonus21.readwrite.database.Constants;
import com.github.sonus21.readwrite.dto.CreateOrderRequest;
import com.github.sonus21.readwrite.dto.CreateOrderResponse;
import com.github.sonus21.readwrite.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/v1/orders")
@RestController
@Database(Constants.SECONDARY)
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("")
    @Database(Constants.PRIMARY)
    public CreateOrderResponse createOrder(@RequestBody @Valid CreateOrderRequest request) {
        return orderService.createOrder(request);
    }

    @GetMapping("/{id}")
    public CreateOrderResponse orderDetail(@PathVariable Long id) {
        return orderService.orderDetail(id);
    }
}
