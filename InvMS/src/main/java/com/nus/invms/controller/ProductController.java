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
import com.nus.invms.service.ProductService;
import com.nus.invms.service.ProductServiceImpl;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService pservice;
	
	@Autowired
	public void setProductService(ProductServiceImpl pserviceImpl) {
		this.pservice = pserviceImpl;
	}
    
	@RequestMapping(value = "/list")
	public String list(Model model) {
		model.addAttribute("products", pservice.findAllProducts());
		return "products";
	}
	@RequestMapping(value = "/add")
	public String addForm(Model model) {
		model.addAttribute("product", new Product());
		return "product-form";
	}
	@RequestMapping(value = "/edit/{id}")
	public String editForm(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("product", pservice.findProductById(id));
		return "product-form";
	}
	@RequestMapping(value = "/save")
	public String saveInventory(@ModelAttribute("product") @Valid Product product, 
			BindingResult bindingResult,  Model model) {
		if (bindingResult.hasErrors()) {
			return "product-form";
		}
		pservice.saveProduct(product);
		return "forward:/product/list";
	}
	@RequestMapping(value = "/delete/{id}")
	public String deleteInventory(@PathVariable("id") Integer id) {
		pservice.deleteProduct(pservice.findProductById(id));
		return "forward:/product/list";
	}

}
