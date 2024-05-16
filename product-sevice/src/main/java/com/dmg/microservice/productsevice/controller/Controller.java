package com.dmg.microservice.productsevice.controller;

import com.dmg.microservice.productsevice.dto.ProductRequest;
import com.dmg.microservice.productsevice.dto.ProductResponse;
import com.dmg.microservice.productsevice.model.Product;
import com.dmg.microservice.productsevice.repository.ProductRepository;
import com.dmg.microservice.productsevice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class Controller {
    private final ProductService productService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){

        return productService.createProduct(productRequest);

    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProduct(){
        return  productService.getAllProducts();
    }


}
