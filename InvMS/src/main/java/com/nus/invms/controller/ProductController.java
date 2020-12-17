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
		String msg = checkError(product);
		if (bindingResult.hasErrors()||msg!=null) 
		{
			//String msg = "Error";
			model.addAttribute("message",msg);
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
	
	public String checkError(Product product) {
		String msg = null;
		ArrayList<Product> flist = new ArrayList<Product>();
		flist = (ArrayList<Product>) pservice.findAllProducts();
		//Product lastProduct = flist.get(flist.size()-1);
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
