package com.ecommerce.backend.model;

public enum Role {
    CUSTOMER,
    ADMIN,
    EMPLOYEE;

    public static Role defaultRole() {
        return CUSTOMER;
    }
}
