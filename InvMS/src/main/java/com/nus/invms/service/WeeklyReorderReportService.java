package com.nus.invms.service;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Service;

@Service
public interface WeeklyReorderReportService {

	public void GenerateDATFile() throws FileNotFoundException;
	
}
