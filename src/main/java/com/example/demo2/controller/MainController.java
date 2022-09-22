package com.example.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j // Simple Logging Facade for Java
public class MainController {
	

	//메뉴 보기
	@RequestMapping("/")
	public ModelAndView main() {
		System.out.println("========================== MainController(/) ==================================");
		ModelAndView mv=new ModelAndView("/main");	
		return mv;
	}

}