package com.ecommerce.backend.model;

public enum OrderStatus {
    PENDING,
    PROCESSING,
    COMPLETED,
    CANCELLED;

    public static OrderStatus defaultStatus() {
        return PENDING;
    }
}
