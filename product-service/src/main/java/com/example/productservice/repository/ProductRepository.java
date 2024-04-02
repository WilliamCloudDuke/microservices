package com.example.productservice.repository;

import com.example.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDate;

public interface ProductRepository extends MongoRepository<Product, String> {

}
