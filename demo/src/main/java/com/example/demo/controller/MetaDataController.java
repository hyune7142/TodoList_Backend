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
		return metaDataService.getMetaData(metaData);
	}
	
}
