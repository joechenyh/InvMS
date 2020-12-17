//package com.nus.invms.controller;
//
//import java.util.ArrayList;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.nus.invms.domain.Inventory;
//import com.nus.invms.domain.Product;
//import com.nus.invms.service.InventoryService;
//import com.nus.invms.service.InventoryServiceImpl;
//import com.nus.invms.service.ProductService;
//import com.nus.invms.service.ProductServiceImpl;
//
//@Controller
//@RequestMapping("/inventory")
//public class PartOrderController {
//	
//	@Autowired
//	private InventoryService iservice;
//	
//	@Autowired
//	private ProductService pservice;
//	
//	@Autowired
//	public void setInventoryService(InventoryServiceImpl iserviceImpl) {
//		this.iservice = iserviceImpl;
//	}
//	
//	@Autowired
//	public void setProductService(ProductServiceImpl pserviceImpl) {
//		this.pservice = pserviceImpl;
//	}
//	
//    
//	@RequestMapping(value = "/list")
//	public String list(Model model) {
//		model.addAttribute("inventories", iservice.findAllInventories());
//		return "inventories";
//	}
//	@RequestMapping(value = "/add")
//	public String addForm(Model model) {
//		model.addAttribute("inventory", new Inventory());
//		ArrayList<Product> plist = pservice.findAllProducts();
//		model.addAttribute("products",plist);
//		return "inventory-form";
//	}
//	@RequestMapping(value = "/edit/{id}")
//	public String editForm(@PathVariable("id") Integer id, Model model) {
//		model.addAttribute("inventory", iservice.findInventoryById(id));
//		return "inventory-form";
//	}
//	@RequestMapping(value = "/save")
//	public String saveInventory(@ModelAttribute("inventory") @Valid Inventory inventory, 
//			BindingResult bindingResult,  Model model) {
//		if (bindingResult.hasErrors()) {
//			return "inventory-form";
//		}
//		iservice.saveInventory(inventory);
//		return "forward:/inventory/list";
//	}
//	@RequestMapping(value = "/delete/{id}")
//	public String deleteInventory(@PathVariable("id") Integer id) {
//		iservice.deleteInventory(iservice.findInventoryById(id));
//		return "forward:/inventory/list";
//	}
//
//}
