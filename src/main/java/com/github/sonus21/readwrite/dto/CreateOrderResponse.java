package com.github.sonus21.readwrite.dto;

import com.github.sonus21.readwrite.models.enums.CurrencyCode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateOrderResponse extends BaseResponseDto {
    private Long id;
    private String trackingId;
    private String merchantId;
    private String merchantOrderId;
    private String userId;
    private Double amount;
    private CurrencyCode currency;
}
