package com.nus.invms.service;

import java.util.List;

import com.nus.invms.domain.Usage;

public interface UsageService {

	public void addUsage(Usage usage); //C
	public boolean viewUsage(Usage usage); //R
	public void deleteUsage(Usage usage); //D
	public void editUsage(Usage usage); //U
	public List<Usage> listUsage();

}
