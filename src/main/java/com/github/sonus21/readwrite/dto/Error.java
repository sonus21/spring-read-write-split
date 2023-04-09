package com.github.sonus21.readwrite.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Error extends BaseDto {
    private int code;
    private String message;
    private Field[] Field;
}
