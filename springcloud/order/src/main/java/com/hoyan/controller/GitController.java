package com.hoyan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/gitevn")
@RefreshScope
public class GitController {
	
	@Value("${env}")
	private String env;
	
	@RequestMapping("/env")
	@ResponseBody
	public String dev(){
		System.out.println("--------------------");
		return env;
	}
	

	

}
