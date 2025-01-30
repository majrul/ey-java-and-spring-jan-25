package com.training.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetails {

    private String email;
    private int productId;
    private int quantity;
}
