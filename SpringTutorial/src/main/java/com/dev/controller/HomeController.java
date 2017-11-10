package com.dev.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev.domain.CosmosVO;
import com.dev.service.MainService;

@Controller
public class HomeController {
	
	@Inject
	private MainService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model) {
		logger.info("test");
		
		model.addAttribute("value", 2);
		
		List<CosmosVO> list = new ArrayList<CosmosVO>();
		CosmosVO cosmosA = new CosmosVO();
		cosmosA.setName("이영준"); cosmosA.setNo(23);
		
		CosmosVO cosmosB = new CosmosVO();
		cosmosB.setName("박춘소"); cosmosB.setNo(25);
		
		list.add(cosmosA);
		list.add(cosmosB);
		
		model.addAttribute("value2", list);
		
		return "test";
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public void test2(Model model) {
		logger.info("test2");
		
		try {
			model.addAttribute("value3", service.getCosmos(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public ModelAndView test3(Model model) {
		logger.info("test3");
		
		ModelAndView page = new ModelAndView("other");
		
		try {
			//model.addAttribute("value3", service.getCosmos());
			page.addObject("value3", service.getCosmos(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return page;
	}
	
}
