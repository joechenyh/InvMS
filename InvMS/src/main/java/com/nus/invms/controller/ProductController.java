package com.nus.invms.controller;

import java.util.ArrayList;
import java.util.Iterator;

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
import com.nus.invms.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {


	
	@Autowired
	ProductService proservice;
	
	@RequestMapping(value = "/add")
	public String add(Model model) 
	{
		model.addAttribute("product", new Product());
		return "product-form";
	}
	
	
	
	@RequestMapping(value = "/save")
	public String saveUser(@ModelAttribute("product") @Valid Product product, 
			BindingResult bindingResult,  Model model) {
		String msg = checkError(product);
		if (bindingResult.hasErrors()||msg!=null) {
			model.addAttribute("message",msg);
			return "product-form";
		}


		
		proservice.saveProduct(product);
		return "forward:/product/list";
	}
	
	@RequestMapping(value="/list")
	public String list(Model model)
	{
	
		model.addAttribute("productList", proservice.findAllProducts());
		return "product";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String editForm(@PathVariable("id") Integer id, Model model) {
		
		model.addAttribute("product", proservice.findProductById(id));
		return "editProduct";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteProduct(@PathVariable("id") Integer id) {
		
		Product product = proservice.findProductById(id);
		product.setStatus(Status.INACTIVE);
		proservice.saveProduct(product);
		return "forward:/product/list";
	}

	@RequestMapping(value = "/confirmEdit")
	public String saveInventory(@ModelAttribute("product") @Valid Product product, 
			BindingResult bindingResult,  Model model) {
		
		if (bindingResult.hasErrors()) 
		{
			
			return "editProduct";
		}
		
		proservice.saveProduct(product);
		return "forward:/product/list";
	}
	
	public String checkError(Product product) {
		String msg = null;
		ArrayList<Product> flist = new ArrayList<Product>();
		flist = (ArrayList<Product>) proservice.findAllProducts();
		
		for (Iterator <Product> iterator = flist.iterator(); iterator.hasNext();) {
			Product product2 = iterator.next();
			if(product.getPartNumber() == product2.getPartNumber()) {
				msg="Part Number Exist";
				break;
			}
			else if (product.getPartNumber()<1000) {
				msg="Invalid Part Number and has to be greater than 1000";
				break;
			}
			else if (product.getReorderLevel()<0 || product.getMinReorderQty()<0||product.getUnitPrice()<0) {
				msg="Negative value unacceptable";
				break;
			}	
		}
		return msg;
	}

}
