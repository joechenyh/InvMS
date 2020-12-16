package com.nus.invms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nus.invms.domain.Inventory;
import com.nus.invms.service.InventoryImplementation;
import com.nus.invms.service.InventoryInterface;

@Controller
public class InventoryController {

	@Autowired
	private InventoryInterface iinterface;
	
	@Autowired
	public void setInventoryInterface(InventoryImplementation iimpl) {
		this.iinterface = iimpl;
	}
	@GetMapping("/")
	public String search(Model model, @Param("keyword") Integer keyword) {
		Inventory listInventory = iinterface.findByInventoryId(keyword);
		model.addAttribute("listInventory", listInventory);
		
		return "search";
	}
}
