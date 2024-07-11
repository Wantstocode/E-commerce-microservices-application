package com.kiran.order_server.handler;

import java.util.Map;

public record ErrorResponse(
    Map<String, String> errors
) {

}
