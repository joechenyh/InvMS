package com.nus.invms.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nus.invms.domain.Inventory;

public interface InventoryReportService {

	Page<Inventory> findPaginated(Pageable pageable);

}
