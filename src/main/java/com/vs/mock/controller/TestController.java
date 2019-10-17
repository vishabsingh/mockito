package com.vs.mock.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring-rest")
public class TestController {
	
	@RequestMapping(value = "/getdata",method = RequestMethod.GET)
	public String getData() {
		
		return "Called Method";
	}
	
	@RequestMapping(value = "/getMap",method = RequestMethod.POST)
	public String create(List<Map<Integer,String>> inputList) {
		System.out.println(inputList);
		return "OK";
	}
}
