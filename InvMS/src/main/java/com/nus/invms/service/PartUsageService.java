package com.nus.invms.service;

import java.util.List;

import com.nus.invms.domain.PartUsage;


public interface PartUsageService {

	public boolean addPartUsage(PartUsage usage); //C
	public void deletePartUsage(PartUsage usage); //D
	public PartUsage editPartUsage(PartUsage usage); //U
	public List<PartUsage> listPartUsage();
	public List<PartUsage> findPartUsageByPartNumber(Integer partnumber);
	public List<PartUsage> findPartUsageByCarplate(String carplate);
	public List<PartUsage> findByUsagedateBetween(String d1, String d2);
	public PartUsage findByTransactionId(Integer tid);
	public List<PartUsage> findByDateAndPartNumber(String d1, String d2, Integer pnum);

}
