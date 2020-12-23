package com.nus.invms.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.nus.invms.domain.Inventory;
import com.nus.invms.domain.Product;
import com.nus.invms.domain.Supplier;
import com.nus.invms.repo.InventoryRepository;
import com.nus.invms.repo.OrderRepository;
import com.nus.invms.repo.ProductRepository;
import com.nus.invms.repo.SupplierRepository;

@Service
public interface WeeklyReorderReportService  {

	
	
	public void GenerateDATFile() throws FileNotFoundException;
}