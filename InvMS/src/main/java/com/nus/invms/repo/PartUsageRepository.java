package com.nus.invms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nus.invms.domain.PartUsage;


public interface PartUsageRepository extends JpaRepository<PartUsage, Integer>
{
	
	//1. Find Usage by Employee Name
//	@Query("Select u from Usage u where u.employeename LIKE :employeename")
//	List<Usage> findUsageByEmployeeName(@Param("employeename") String employeename);
	
	//2. Find Usage by Employee Name
	@Query("Select u from PartUsage u where u.employeeId LIKE :eid")
	List<PartUsage> findPartUsageByEmployeeId(@Param("eid") int eid);
	
	//3. Find Usage by Part Name
	@Query("Select u from PartUsage u where u.partNumber Like :partNumber")
	List<PartUsage> findPartUsageByPartNumber(@Param("partNumber") String partNumber);
	
	
	//4. Find Usage by CarPlate
	@Query("Select u from PartUsage u where u.carplate Like :carplate")
	List<PartUsage> findUsageByCarPlate(@Param("carplate") String carplate);
	
	
	//5. Find Usage by PartID
//	@Query("Select u from Usage u where u.PartId Like :pid")
//	List<Usage> findUsageByPartId(@Param("pid") int pid);
	
	//6. Find Usage By Date

	
	
	}
