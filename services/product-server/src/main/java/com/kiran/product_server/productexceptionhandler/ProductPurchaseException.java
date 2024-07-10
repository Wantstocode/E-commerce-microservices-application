package com.kiran.product_server.productexceptionhandler;

public class ProductPurchaseException extends RuntimeException {
    public ProductPurchaseException(String s) {
        super(s);
    }
}
