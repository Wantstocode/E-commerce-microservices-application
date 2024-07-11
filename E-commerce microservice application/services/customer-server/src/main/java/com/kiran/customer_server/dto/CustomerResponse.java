package com.kiran.customer_server.dto;

import com.kiran.customer_server.model.Address;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email,
        Address address
) {
}
