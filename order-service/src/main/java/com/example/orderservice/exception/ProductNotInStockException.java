package com.example.orderservice.exception;

public class ProductNotInStockException extends RuntimeException {
    public ProductNotInStockException(String message) {
        super(message);
    }
}
