package com.nus.invms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nus.invms.domain.FixSet;
import com.nus.invms.domain.FixSetUsage;
import com.nus.invms.domain.Product;
import com.nus.invms.domain.Status;
import com.nus.invms.service.FSService;
import com.nus.invms.service.FSServiceImpl;
import com.nus.invms.service.PartUsageService;
import com.nus.invms.service.PartUsageServiceImpl;
import com.nus.invms.service.ProductService;

@Controller
@RequestMapping("/fixset")
public class FixsetController {

	public FixsetController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	FSService fsservice; 
	
	public void SetFSService(FSServiceImpl fsserviceimpl)
	{
		this.fsservice = fsserviceimpl; 
	}	
	
	
	
	@RequestMapping(value = "/add")
	public String addFixSet(Model model) 
	{
		model.addAttribute("fixset", new FixSet());
		return "fixset-form";
	}
	
	
	@RequestMapping(value = "/save")
	public String saveFixSet(@ModelAttribute("fixset") @Valid FixSet fixset, 
			BindingResult bindingResult,  Model model) {
		fsservice.saveFixSet(fixset);
		return "forward:/fixset/list";
	}
	
	@RequestMapping(value="/list")
	public String listFixSet(Model model)
	{
		//model.addAttribute("productList", proservice.listAllProducts());
		model.addAttribute("fixsetList", fsservice.findAllFixSets()); //I used the build in JPA repo
		return "fixsets";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String editFixSet(@PathVariable("id") Integer id, Model model) {
		//model.addAttribute("product", proservice.findById(number).get());
		model.addAttribute("fixset", fsservice.findFixSetById(id));
		return "editfixset";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteFixSet(@PathVariable("id") Integer id) {
	
		FixSet fixset = fsservice.findFixSetById(id);
		fixset.setStatus(Status.INACTIVE);
		fsservice.saveFixSet(fixset);
		return "forward:/fixset/list";
	}

	@RequestMapping(value = "/confirmFixSetEdit")
	public String confirmeditFixSet(@ModelAttribute("fixset") @Valid FixSet fixset, 
			BindingResult bindingResult,  Model model) {
		
		if (bindingResult.hasErrors()) 
		{
			
			return "editfixset";
		}
		
		fsservice.saveFixSet(fixset);
		return "forward:/fixset/list";
	}
	
	
	@RequestMapping(value = "/addusage")
	public String addFixSetUsage(Model model) 
	{
		model.addAttribute("fixsetusage", new FixSetUsage());
		return "fixsetusage-form";
	}
	
	
	@RequestMapping(value = "/saveusage")
	public String saveFixSetUsage(@ModelAttribute("fixsetusage") @Valid FixSetUsage fixsetusage, 
			BindingResult bindingResult,  Model model) {
		fsservice.saveFixSetUsage(fixsetusage);
		return "forward:/fixsetusage/listusage";
	}
	
	@RequestMapping(value="/listusage")
	public String listFixSetUsage(Model model)
	{
		//model.addAttribute("productList", proservice.listAllProducts());
		model.addAttribute("fixsetList", fsservice.listFixSetUsage()); //I used the build in JPA repo
		return "fixsetusages";
	}
	
	@RequestMapping(value = "/editusage/{id}")
	public String editFixSetUsageForm(@PathVariable("id") Integer id, Model model) {
		//model.addAttribute("product", proservice.findById(number).get());
		model.addAttribute("fixsetusage", fsservice.findByTransactionId(id));
		return "editfixsetusage";
	}
	
	@RequestMapping(value = "/deleteusage/{id}")
	public String deleteFixSetUsage(@PathVariable("id") Integer id) {
		//Product product = proservice.findById(number).get();
		FixSetUsage fsusage = fsservice.findByTransactionId(id);
		fsusage.setStatus(Status.INACTIVE);
		fsservice.saveFixSetUsage(fsusage);
		return "forward:/fixsetusage/listusage";
	}

	@RequestMapping(value = "/confirmFSUsageEdit")
	public String saveInventory(@ModelAttribute("fixsetusage") @Valid FixSetUsage fixsetusage, 
			BindingResult bindingResult,  Model model) {
		
		if (bindingResult.hasErrors()) 
		{
			
			return "editfixsetusage";
		}
		
		fsservice.saveFixSetUsage(fixsetusage);
		return "forward:/fixsetusage/listusage";
	}
	
	
	
	

}
