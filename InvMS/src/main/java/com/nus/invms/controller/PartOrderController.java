package com.nus.invms.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nus.invms.domain.Inventory;
import com.nus.invms.domain.PartOrder;
import com.nus.invms.domain.Product;
import com.nus.invms.service.PartOrderService;
import com.nus.invms.service.PartOrderServiceImpl;
import com.nus.invms.service.ProductService;
import com.nus.invms.service.ProductServiceImpl;

@Controller
@RequestMapping("/partorder")
public class PartOrderController {
	
	@Autowired
	private PartOrderService poservice;
	
	@Autowired
	private ProductService pservice;
	
	@Autowired
	public void setPartOrderService(PartOrderServiceImpl poserviceImpl) {
		this.poservice = poserviceImpl;
	}
	
	@Autowired
	public void setProductService(ProductServiceImpl pserviceImpl) {
		this.pservice = pserviceImpl;
	}
	
    
	@RequestMapping(value = "/list")
	public String list(Model model) {
		model.addAttribute("partorders", poservice.findAllPartOrders());
		return "partorders";
	}
	@RequestMapping(value = "/add")
	public String addForm(Model model) {
		model.addAttribute("partorder", new PartOrder());
		ArrayList<Product> plist = pservice.findAllProducts();
		model.addAttribute("products",plist);
		return "partorder-form";
	}
	@RequestMapping(value = "/edit/{id}")
	public String editForm(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("partorders", poservice.findPartOrderById(id));
		return "partorder-form";
	}
	@RequestMapping(value = "/save")
	public String savePartOrder(@ModelAttribute("partorder") @Valid PartOrder partOrder, 
			BindingResult bindingResult,  Model model) {
		if (bindingResult.hasErrors()) {
			return "inventory-form";
		}
		poservice.savePartOrder(partOrder);
		return "forward:/partorder/list";
	}
	@RequestMapping(value = "/delete/{id}")
	public String deletePartOrder(@PathVariable("id") Integer id) {
		poservice.deletePartOrder(poservice.findPartOrderById(id));
		return "forward:/partorder/list";
	}

}
