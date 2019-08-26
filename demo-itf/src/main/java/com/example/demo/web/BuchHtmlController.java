package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Reporsitory.BuchReporsitory;

@RequestMapping("/books")
@Controller
public class BuchHtmlController {
	@Autowired
	private BuchReporsitory buchrepository;
	
	@GetMapping
	public String index(Model model) {
		
		model.addAttribute("bookList",buchrepository.findAll());
		model.addAttribute("count",buchrepository.count());
		return "books";
	}

}
