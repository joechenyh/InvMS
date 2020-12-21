package com.nus.invms.service;

import java.time.LocalDate;
import java.util.List;

import com.nus.invms.domain.PartUsage;


public interface PartUsageService {

	public boolean addPartUsage(PartUsage usage); //C
	public void deletePartUsage(PartUsage usage); //D
	public PartUsage editPartUsage(PartUsage usage); //U
	public List<PartUsage> listPartUsage();
	public List<PartUsage> findPartUsageByPartNumber(Integer partnumber);
	public List<PartUsage> findPartUsageByCarplate(String carplate);
//	public List<PartUsage> findByUsagedateBetween(LocalDate d1, LocalDate d2);
	public List<PartUsage> findByUsagedateBetween(String d1, String d2);
	public PartUsage findByTransactionId(Integer tid);


}
