package com.example.demo.service;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface HelloService {
	
	public Map<String, String> getMetaData(String url);

}
