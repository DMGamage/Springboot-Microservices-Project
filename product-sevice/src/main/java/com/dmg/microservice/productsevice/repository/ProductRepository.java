package com.dmg.microservice.productsevice.repository;

import com.dmg.microservice.productsevice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
