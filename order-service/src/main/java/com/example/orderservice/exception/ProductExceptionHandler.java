package com.example.orderservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.Instant;

@ControllerAdvice
public class ProductExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotInStockException.class)
    ProblemDetail handleProductNotInStockException(ProductNotInStockException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Product not in Stock");
        problemDetail.setType(URI.create("https://api.order.com/errors/not-found"));
        problemDetail.setProperty("errorCategory", "Generic");
        problemDetail.setProperty("timeStamp", Instant.now());
        return problemDetail;
    }

}
