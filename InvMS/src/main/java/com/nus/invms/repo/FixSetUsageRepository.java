package com.nus.invms.repo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nus.invms.domain.FixSet;
import com.nus.invms.domain.FixSetUsage;
import com.nus.invms.domain.Inventory;


public interface FixSetUsageRepository extends JpaRepository<FixSetUsage, Integer>
{
	
	public ArrayList<FixSetUsage> findByUsagedateBetween(String d1, String d2);
	
}
