package com.nus.invms.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.nus.invms.domain.Inventory;
import com.nus.invms.repo.InventoryRepository;

@Service
public class InventoryReportServiceImpl implements InventoryReportService{

	
	@Autowired
	InventoryRepository irepo;
    

	
	
	@Override
	@Transactional
    public Page<Inventory> findPaginated(Pageable pageable) {
		List<Inventory> inventories = irepo.findAll();
		
		
		
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Inventory> list;

        if (inventories.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, inventories.size());
            list = inventories.subList(startItem, toIndex);
        }

        Page<Inventory> inventoryPage
          = new PageImpl<Inventory>(list, PageRequest.of(currentPage, pageSize), inventories.size());

        return inventoryPage;
    }
}
