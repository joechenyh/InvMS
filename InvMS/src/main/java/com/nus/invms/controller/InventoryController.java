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
import org.springframework.web.bind.annotation.ResponseBody;

import com.nus.invms.domain.Inventory;
import com.nus.invms.domain.Product;
import com.nus.invms.service.InventoryService;
import com.nus.invms.service.InventoryServiceImpl;
import com.nus.invms.service.ProductService;
import com.nus.invms.service.ProductServiceImpl;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryService iservice;
	
	@Autowired
	private ProductService pservice;
	
	@Autowired
	public void setInventoryService(InventoryServiceImpl iserviceImpl) {
		this.iservice = iserviceImpl;
	}
	
	@Autowired
	public void setProductService(ProductServiceImpl pserviceImpl) {
		this.pservice = pserviceImpl;
	}
	
    
	@RequestMapping(value = "/list")
	public String list(Model model) {
		model.addAttribute("inventories", iservice.findAllInventories());
		return "inventories";
	}
	@RequestMapping(value = "/add")
	public String addForm(Model model) {
		model.addAttribute("inventory", new Inventory());
		ArrayList<Product> plist = pservice.findAllProducts();
		model.addAttribute("products",plist);
		return "inventory-form";
	}
	
	@RequestMapping(value = "/getProduct/{id}")
	@ResponseBody
	public ArrayList<String> getProductById(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("inventory", new Inventory());
		Product result = pservice.findProductById(id);
		ArrayList<String> productInfo = new ArrayList<String>();
		productInfo.add(result.getUnitPrice().toString());
		//System.out.println(productInfo.get(0));
		productInfo.add(result.getProductName().toString());
		//System.out.println(productInfo.get(1));
		return productInfo;
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String editForm(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("inventory", iservice.findInventoryById(id));
		ArrayList<Product> plist = pservice.findAllProducts();
		model.addAttribute("products",plist);
		return "inventory-edit-form";
	}
	
	@RequestMapping(value = "/save")
	public String saveInventory(@ModelAttribute("inventory") @Valid Inventory inventory, 
			BindingResult bindingResult,  Model model) 
	{
		String msg = checkError(inventory);
		if (bindingResult.hasErrors()||msg!=null) 
		{
			model.addAttribute("message",msg);
			return "inventory-form";
		}
		else 
		{
			int partNum = inventory.getProduct().getPartNumber();
			ArrayList<Product> flist = new ArrayList<Product>();
			flist = (ArrayList<Product>) pservice.findAllProducts();
			for (Iterator <Product> iterator = flist.iterator(); iterator.hasNext();) 
			{
				Product product2 = iterator.next();
				if(product2.getPartNumber()==partNum) 
				{
					inventory.setItemName(product2.getProductName());
					break;
				}
			}
			iservice.saveInventory(inventory);
			return "forward:/inventory/list";	
		}
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteInventory(@PathVariable("id") Integer id) 
	{
		iservice.deleteInventory(iservice.findInventoryById(id));
		return "forward:/inventory/list";
	}
	
	public String checkError(Inventory inventory) {
		String msg = null;
		if(inventory.getBrandId()<0||inventory.getOriginalPrice()<0||inventory.getPartnerPrice()<0||inventory.getRetailPrice()<0||inventory.getWholesalePrice()<0||inventory.getUnits()<0) {
			msg="Negative value unacceptable";
		}
		return msg;
	}
	
	@RequestMapping(value = "/confirm")
	public String outInventory(@ModelAttribute("inventory") @Valid Inventory inventory, 
			BindingResult bindingResult,  Model model) 
	{
		Inventory inventorycore = iservice.findInventoryById(inventory.getInventoryId());
		int newUnit = inventorycore.getUnits() - inventory.getUnits();
		inventorycore.setUnits(newUnit);
		iservice.saveInventory(inventorycore);
		return "forward:/inventory/list";
//		String msg = checkError(inventory);
//		if (bindingResult.hasErrors()||msg!=null) 
//		{
//			model.addAttribute("message",msg);
//			return "inventory-form";
//		}
//		else 
//		{
//			int partNum = inventory.getProduct().getPartNumber();
//			ArrayList<Product> flist = new ArrayList<Product>();
//			flist = (ArrayList<Product>) pservice.findAllProducts();
//			for (Iterator <Product> iterator = flist.iterator(); iterator.hasNext();) 
//			{
//				Product product2 = iterator.next();
//				if(product2.getPartNumber()==partNum) 
//				{
//					inventory.setItemName(product2.getProductName());
//					break;
//				}
//			}
//			iservice.saveInventory(inventory);
//			return "forward:/inventory/list";	
//		}
	}

}
