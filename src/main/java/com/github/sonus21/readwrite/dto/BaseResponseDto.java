package com.github.sonus21.readwrite.dto;


import lombok.Data;

@Data
public class BaseResponseDto extends BaseDto {
    private Error error;
}
