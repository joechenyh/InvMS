package com.nus.invms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nus.invms.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
