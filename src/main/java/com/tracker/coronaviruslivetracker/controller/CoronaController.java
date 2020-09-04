package com.tracker.coronaviruslivetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tracker.coronaviruslivetracker.entity.Customer;
import com.tracker.coronaviruslivetracker.services.CoronaVirusDataService;
import com.tracker.coronaviruslivetracker.services.CustomerService;
import com.tracker.coronaviruslivetracker.util.CoronaUtility;

@Controller
public class CoronaController {

	// extra
	@Autowired
	private CustomerService customerService;

	@Autowired
	private CoronaVirusDataService coronaVirusDataService;

	@Autowired
	private CoronaUtility coronaUtility;

	@GetMapping("/home")
	public String Index(Model model) {
		model.addAttribute("stateAllData", coronaVirusDataService.getAllState());
		return "index";
	}

	@GetMapping("/state")
	public String StateWisetracker(Model model) {
		coronaUtility.PieChart(coronaVirusDataService.getAllState());
		model.addAttribute("pass", 50);
		model.addAttribute("fail", 50);
		model.addAttribute("stateAllData", coronaVirusDataService.getAllState());
		return "indiaData";
	}

	@GetMapping("/world")
	public String WorldWiseTracker(Model model) {

		model.addAttribute("stateAllData", coronaVirusDataService.getAllState());
		return "worldData";
	}

	@GetMapping("/map")
	public String MapData(Model model) {

		return "mapData";
	}

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		// get customers from service
		List<Customer> theCustomers = customerService.getCustomers();

		// add customers to the model
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";
	}

}
