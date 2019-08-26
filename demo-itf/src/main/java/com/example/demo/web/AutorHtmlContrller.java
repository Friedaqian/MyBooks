package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Reporsitory.AutorReporsitory;

@RequestMapping("/autors")
@Controller
public class AutorHtmlContrller {
	
	@Autowired
	private AutorReporsitory autorrepository;
	
	@GetMapping
	public String index(Model model) {
		
		model.addAttribute("autorList",autorrepository.findAll());
		model.addAttribute("count",autorrepository.count());
		return "autors";
	}

}
