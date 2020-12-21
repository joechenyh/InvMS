package com.nus.invms.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nus.invms.domain.Inventory;
import com.nus.invms.repo.InventoryRepository;
import com.nus.invms.service.InventoryReportService;
import com.nus.invms.service.InventoryReportServiceImpl;
import com.nus.invms.service.InventoryServiceImpl;

@Controller
@RequestMapping("/inventoryreport")
public class InventoryReportController {
	
		
	    
		public InventoryReportController() {
		super();
	}

		@Autowired
		InventoryRepository irepo;
	
	    @Autowired
	    InventoryReportService irservice; 
	    
	    @Autowired
		public void setIRService(InventoryReportServiceImpl irserviceimpl) {
			this.irservice = irserviceimpl;
		}

	    @RequestMapping(value = "/list")
	    public String listInventories(
	      Model model, 
	      @RequestParam("page") Optional<Integer> page, 
	      @RequestParam("size") Optional<Integer> size) {
	        int currentPage = page.orElse(1);
	        int pageSize = size.orElse(5);

	        Page<Inventory> inventoryPage = irservice.findPaginated(PageRequest.of(currentPage - 1, pageSize));

	        model.addAttribute("inventoryPage", inventoryPage);

	        int totalPages = inventoryPage.getTotalPages();
	        if (totalPages > 0) {
	            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
	                .boxed()
	                .collect(Collectors.toList());
	            model.addAttribute("pageNumbers", pageNumbers);
	        }
	        return "inventoriesreport";
	    }
	}


