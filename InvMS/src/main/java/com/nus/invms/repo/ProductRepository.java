package com.nus.invms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nus.invms.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {


	

}

