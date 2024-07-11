package com.kiran.order_server.customer;

public record CustomerResponse(
    String id,
    String firstname,
    String lastname,
    String email
) {

}
