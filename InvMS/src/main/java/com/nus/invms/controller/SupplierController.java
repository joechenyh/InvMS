package com.nus.invms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nus.invms.domain.Status;
import com.nus.invms.domain.Supplier;
import com.nus.invms.service.SupplierInterface;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
	
	@Autowired
	SupplierInterface supservice;
	
	@RequestMapping(value = "/add")
	public String add(Model model) 
	{
		model.addAttribute("supplier", new Supplier());
		return "supplier-form";
	}
	
	
	
	@RequestMapping(value = "/save")
	public String saveUser(@ModelAttribute("supplier") @Valid Supplier supplier, 
			BindingResult bindingResult,  Model model) {
		
		System.out.println("!!!! save me!!!!" );
		
		if (bindingResult.hasErrors()) {
			return "supplier-form";
		}


		
		supservice.saveSupplier(supplier);
		return "forward:/supplier/list";
	}
	
	@RequestMapping(value="/list")
	public String list(Model model)
	{
		model.addAttribute("supplierList", supservice.listAllSuppliers());
		return "supplier";
	}
	
	@RequestMapping(value = "/edit/{supplierId}")
	public String editForm(@PathVariable("supplierId") int number, Model model) {
		model.addAttribute("supplier", supservice.findById(number));
		return "supplier-form";
	}
	
	@RequestMapping(value = "/delete/{supplierId}")
	public String deleteProduct(@PathVariable("supplierId") int number) {
		Supplier supplier = supservice.findById(number);
		supplier.setStatus(Status.INACTIVE);
		supservice.saveSupplier(supplier);
		return "forward:/supplier/list";
	}

}
