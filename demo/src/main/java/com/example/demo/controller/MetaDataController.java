package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.MetaData;
import com.example.demo.service.MetaDataService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MetaDataController {
	
	@Autowired MetaDataService metaDataService;
	
	@RequestMapping(value="/metadata", method=RequestMethod.GET)
	public MetaData index(MetaData metaData) throws IOException {
		long start = System.currentTimeMillis();
	    System.out.println("####ehCache is Running...");
		MetaData result = metaDataService.getMetaData(metaData);
		
		// 요청 url 정보가 DB에 없을 경우
		if(result == null) {
			metaDataService.insertMetaData(metaData);
			result =  metaDataService.getMetaData(metaData);
		}
		
	    long end = System.currentTimeMillis();
	    System.out.println("시간측정"+"  :  " +Long.toString(end-start));
		return result;
	}
	
}
