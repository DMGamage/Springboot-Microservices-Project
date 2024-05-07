package com.dmg.microservice.productsevice.service;

import com.dmg.microservice.productsevice.dto.ProductRequest;
import com.dmg.microservice.productsevice.dto.ProductResponse;
import com.dmg.microservice.productsevice.model.Product;
import com.dmg.microservice.productsevice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest){
        Product  product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        productRepository.save(product);
        log.info("product Created successfully");

        return new ProductResponse(product.getId(), product.getName(), product.getDescription(),product.getPrice());
    }

    public List<ProductResponse> getAllProducts(){
        return  productRepository.findAll().stream()
                .map(product ->new ProductResponse(product.getId(), product.getName(), product.getDescription(),product.getPrice()))
                .toList();
    }
}
