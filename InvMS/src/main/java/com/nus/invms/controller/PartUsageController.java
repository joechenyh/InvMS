package com.nus.invms.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nus.invms.domain.PartUsage;
import com.nus.invms.service.InventoryServiceImpl;
import com.nus.invms.service.PartUsageServiceImpl;

import sg.edu.iss.club.domain.Booking;
import sg.edu.iss.club.service.BookingService;
import sg.edu.iss.club.service.BookingServiceImpl;

@Controller
@RequestMapping("/partusage")
public class PartUsageController  {
	
	@Autowired
	private InventoryServiceImpl invservice;
	
	@Autowired
	private PartUsageServiceImpl puservice;
	
	//@Autowired
	//private EmployeeService eservice; 
	
	@Autowired
	public void setPUService(PartUsageServiceImpl puservice) {
		this.puservice = puservice;
	}
	

	//1. Manage Usage
	@RequestMapping(value = "/usagedashboard")
	public String Viewdashboard(){
		return "usagedashboard";
	}
	
	
	//2. Create Usage
	@RequestMapping(value = "/createusage")
	public String addUsage(Model model) {
		model.addAttribute("partusage", new PartUsage());
	//	ArrayList<String> flist = fservice.findAllFacilityNames(); need a service to show all available part numbers 
	//	model.addAttribute("fnames", flist);
		return "usage-form";
	}
	
	//3. Update Usage
	@RequestMapping(value = "/editusage")
	public String editPartUsage(@PathVariable("id") Integer id) {
		puservice.editPartUsage(puservice.findPartUsageById(id));
		return "forward:/partusage/list";
	}
	
	//4. Check Usage
	@RequestMapping(value = "/viewusage")
	public String viewPartUsage(@PathVariable("id") Integer id) {
		puservice.viewPartUsage(puservice.findPartUsageById(id));
		return "forward:/partusage/list";
	}
	
	//5. Deactivate Usage
	@RequestMapping(value = "/deactivateusage")
	public String deletePartUsage(@PathVariable("id") Integer id) {
		puservice.deletePartUsage(puservice.findPartUsageById(id));
		return "forward:/partusage/list";
	}
	
	//6. Search/List Usage 
	@RequestMapping(value = "/searchusage")
	public String searchPartUsage(@PathVariable("id") Integer id) {
		puservice.searchPartUsage(puservice.findPartUsageById(id));
		return "forward:/partusage/list";
	}
	
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		model.addAttribute("usages", puservice.listPartUsage());
		return "usages";
	}
	
	

}
