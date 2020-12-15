package com.nus.invms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nus.invms.domain.Product;
import com.nus.invms.domain.Status;
import com.nus.invms.service.ProductInterface;

@Controller
@RequestMapping("/product")
public class ProductController {

	public ProductController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	ProductInterface proservice;
	
	@RequestMapping(value = "/add")
	public String add(Model model) 
	{
		model.addAttribute("product", new Product());
		return "product-form";
	}
	
	
	
	@RequestMapping(value = "/save")
	public String saveUser(@ModelAttribute("product") @Valid Product product, 
			BindingResult bindingResult,  Model model) {
		
		if (bindingResult.hasErrors()) {
			return "product-form";
		}

		if (proservice.checkProductNameExist(product)) 
		{
			return "product-form";
		}
		
		proservice.saveProduct(product);
		return "forward:/product/list";
	}
	
	@RequestMapping(value="/list")
	public String list(Model model)
	{
		model.addAttribute("productList", proservice.listAllProducts());
		return "product";
	}
	
	@RequestMapping(value = "/edit/{partNumber}")
	public String editForm(@PathVariable("partNumber") int number, Model model) {
		model.addAttribute("product", proservice.findById(number).get());
		return "editProduct";
	}
	
	@RequestMapping(value = "/delete/{partNumber}")
	public String deleteProduct(@PathVariable("partNumber") int number) {
		Product product = proservice.findById(number).get();
		product.setStatus(Status.INACTIVE);
		proservice.saveProduct(product);
		return "forward:/product/list";
	}

	

}
