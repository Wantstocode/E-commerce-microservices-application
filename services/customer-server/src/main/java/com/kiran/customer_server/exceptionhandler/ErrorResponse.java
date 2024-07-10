package com.kiran.customer_server.exceptionhandler;

import java.util.Map;
import java.util.Set;

public record ErrorResponse(
        Map<String, String> errors
) {

}

