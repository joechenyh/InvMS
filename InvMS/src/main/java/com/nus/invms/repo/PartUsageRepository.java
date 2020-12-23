package com.nus.invms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nus.invms.domain.PartUsage;

public interface PartUsageRepository extends JpaRepository<PartUsage, Integer> {

	@Query(value = "SELECT * FROM part_usage pu WHERE pu.product_part_number = :pnumber",
			nativeQuery = true)
	List<PartUsage> findPartUsageByPartNumber(Integer pnumber);

	List<PartUsage> findUsageByCarplate(String carplate);

	@Query(value = "SELECT * FROM part_usage pu WHERE pu.usagedate BETWEEN :d1 AND :d2",
			nativeQuery=true)
	List<PartUsage> findByUsagedateBetween(@Param("d1") String d1, @Param("d2") String d2);

	public PartUsage findByTransactionId(Integer tid);
	
	@Query(value = "SELECT * FROM part_usage pu WHERE pu.product_part_number = :pnum AND pu.usagedate BETWEEN :d1 AND :d2",
			nativeQuery = true)
	List<PartUsage> findByDateAndPartNumber(@Param("d1") String d1, @Param("d2") String d2, @Param("pnum") Integer pnum);
}
