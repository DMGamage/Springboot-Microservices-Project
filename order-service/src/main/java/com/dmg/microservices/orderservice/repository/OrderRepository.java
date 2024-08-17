package com.dmg.microservices.orderservice.repository;

import com.dmg.microservices.orderservice.model.order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<order,Long> {
}
