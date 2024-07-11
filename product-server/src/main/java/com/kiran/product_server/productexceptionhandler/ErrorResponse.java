package com.kiran.product_server.productexceptionhandler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {

}
