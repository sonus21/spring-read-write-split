package com.github.sonus21.readwrite.dto;

import com.github.sonus21.readwrite.models.enums.CurrencyCode;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CreateOrderRequest extends BaseDto {
    @NotEmpty
    private String merchantId;
    @NotEmpty
    private String merchantOrderId;
    @NotEmpty
    private String userId;
    @NotNull
    private Double amount;
    @NotNull
    private CurrencyCode currency;
}
