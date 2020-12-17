package com.nus.invms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nus.invms.domain.PartOrder;

public interface PartOrderRepository extends JpaRepository<PartOrder, Integer> {
	
}
