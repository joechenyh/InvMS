package com.nus.invms.service;

import java.util.List;

import com.nus.invms.domain.PartUsage;


public interface PartUsageService {

	public boolean addPartUsage(PartUsage usage); //C
	public void deletePartUsage(PartUsage usage); //D
	public PartUsage editPartUsage(PartUsage usage); //U
	public List<PartUsage> listPartUsage();
	public List<PartUsage> viewPartUsage(String partnumber);
	public PartUsage findPartUsageById(int id);

}
