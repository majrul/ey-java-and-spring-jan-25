package com.training.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderStatus {

    private boolean status;
    private String messageIfAny;
    private int orderId;

}
