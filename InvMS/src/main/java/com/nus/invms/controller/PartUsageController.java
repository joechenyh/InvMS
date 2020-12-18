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

import com.nus.invms.domain.PartUsage;
import com.nus.invms.service.EmployeeInterface;
import com.nus.invms.service.InventoryService;
import com.nus.invms.service.InventoryServiceImpl;
import com.nus.invms.service.PartUsageService;
import com.nus.invms.service.PartUsageServiceImpl;

@Controller
@RequestMapping("/partusage")
public class PartUsageController {

	@Autowired
	private InventoryService invservice;

	@Autowired
	private PartUsageService puservice;

//	@Autowired
//	private EmployeeInterface empservice;

	// @Autowired
	// private EmployeeService eservice;

	@Autowired
	public void setInvService(InventoryServiceImpl invserviceimpl) {
		this.invservice = invserviceimpl;
	}

	@Autowired
	public void setPUService(PartUsageServiceImpl puserviceimpl) {
		this.puservice = puserviceimpl;
	}

	// 1. Manage Usage
	@RequestMapping(value = "/usagedashboard")
	public String Viewdashboard() {
		return "usagedashboard";
	}

	@RequestMapping(value = "/list")
	public String list(Model model) {
		model.addAttribute("pusages", puservice.listPartUsage());
		return "usages";
	}

	@RequestMapping(value = "/add")
	public String addForm(Model model) {
		model.addAttribute("pusage", new PartUsage());
//		ArrayList<String> emplist = empservice.findAllEmployeeNames();
//		model.addAttribute("enames", emplist);
		return "usage-form";
	}

	@RequestMapping(value = "/edit/{id}")
	public String editForm(@PathVariable("id") String id, Model model) {
		model.addAttribute("pusage", puservice.viewPartUsage(id));
		return "usage-form";
	}

	@RequestMapping(value = "/save")
	public String savePartUsage(@ModelAttribute("pusage") @Valid PartUsage pusage, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "usage-form";
		}
		puservice.addPartUsage(pusage);
		return "forward:/partusage/list";
	}

	@RequestMapping(value = "/delete/{id}")
	public String deletePartUsage(@PathVariable("id") Integer tid) {
		puservice.deletePartUsage(puservice.findByTransactionId(tid));
		return "forward:/partusage/list";
	}

}
