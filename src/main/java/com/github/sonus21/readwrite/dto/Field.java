package com.github.sonus21.readwrite.dto;

import lombok.Data;

@Data
public class Field extends BaseDto {
    private String name;
    private String[] messages;
}
