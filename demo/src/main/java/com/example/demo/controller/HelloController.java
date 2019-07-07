package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.HelloService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HelloController {
	
	@Autowired HelloService hservice;
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public Map<String, String> index(HttpServletResponse res, HttpServletRequest req) throws IOException {
	
		String url = req.getParameter("url");
		
		System.out.println("마스터1");
		
		return hservice.getMetaData(url);
	}
	
}
