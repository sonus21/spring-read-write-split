package com.github.sonus21.readwrite.service;

import com.github.sonus21.readwrite.dto.CreateOrderRequest;
import com.github.sonus21.readwrite.dto.CreateOrderResponse;
import com.github.sonus21.readwrite.dto.Error;
import com.github.sonus21.readwrite.models.entities.Order;
import com.github.sonus21.readwrite.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    private CreateOrderResponse buildResponse(Order order) {
        return CreateOrderResponse.builder().id(order.getId()).trackingId(order.getTrackingId()).merchantId(order.getMerchantId()).merchantOrderId(order.getMerchantOrderId()).userId(order.getUserId()).amount(order.getAmount()).currency(order.getCurrency()).build();
    }

    public CreateOrderResponse createOrder(CreateOrderRequest request) {
        if (orderRepository.findByMerchantIdAndMerchantOrderId(request.getMerchantId(), request.getMerchantOrderId()).isPresent()) {
            CreateOrderResponse response = CreateOrderResponse.builder().build();
            response.setError(Error.builder().code(400).message("duplicate order").build());
            return response;
        }
        Order order = Order.builder().userId(request.getUserId()).merchantOrderId(request.getMerchantOrderId()).merchantId(request.getMerchantId()).amount(request.getAmount()).currency(request.getCurrency()).trackingId(UUID.randomUUID().toString()).build();
        orderRepository.save(order);
        return buildResponse(order);
    }

    public CreateOrderResponse orderDetail(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty()) {
            CreateOrderResponse response = CreateOrderResponse.builder().build();
            response.setError(Error.builder().code(404).message("order does not exist").build());
            return response;
        }
        return buildResponse(order.get());
    }
}
