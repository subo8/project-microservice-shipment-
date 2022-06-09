package com.mini2.springbootmicroservice8shipping.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ShipmentStatus {
    PREPARING("preparing"),
    SHIPPED("shipped"),
    DELIVERED("delivered"),
    RETURNED("returned");

    private final String status;
}
