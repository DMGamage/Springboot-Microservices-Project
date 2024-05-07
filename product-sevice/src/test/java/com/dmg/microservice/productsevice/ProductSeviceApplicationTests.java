package com.dmg.microservice.productsevice;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductSeviceApplicationTests {
    @LocalServerPort
    private Integer port;
    @ServiceConnection
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

    @BeforeEach
    void setup(){
        RestAssured.baseURI = "https://localhost";
        RestAssured.port = port;
    }

    static{
        mongoDBContainer.start();
    }
    @Test
    void shouldCreateProduct() {
        String requestBody = """
                {
                    "name":"Iphone 115",
                    "description":"Smart Phone",
                    "price":1000
                                
                }
                """;
        RestAssured.given().
                contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/product")
                .then()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("name",Matchers.equalTo("Iphone 115"))
                .body("description",Matchers.equalTo("Smart Phone"))
                .body("price",Matchers.equalTo(1000));
    }

}
