package com.nus.invms.service;

import java.util.ArrayList;
import java.util.List;

import com.nus.invms.domain.PartUsage;


public interface PartUsageService {

	public boolean addPartUsage(PartUsage usage); //C
	public void deletePartUsage(PartUsage usage); //D
	public PartUsage editPartUsage(PartUsage usage); //U
	public ArrayList<PartUsage> listPartUsage();
	public ArrayList<PartUsage> viewPartUsage(String partnumber);
	public ArrayList<PartUsage> findPartUsageByCarplate(String carplate);
	public ArrayList<PartUsage> findByUsagedateBetween(String d1, String d2);
	public PartUsage findByTransactionId(Integer tid);


}
