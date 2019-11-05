package com.javafpt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RestController
public class IndexController {
	
	@RequestMapping(value = "/index")
	public ModelAndView viewIndex() {
		ModelAndView andView = new ModelAndView("index"); 
		return andView;
	}
}
