package com.nus.invms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nus.invms.domain.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer>{
	
	public Supplier findSupplierBysupplierName(String name);

}
