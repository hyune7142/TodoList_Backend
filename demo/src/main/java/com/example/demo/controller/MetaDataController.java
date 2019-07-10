package com.example.demo.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
		
		MetaData result = metaDataService.getMetaData(metaData);
		
		// 요청 url 정보가 DB에 없을 경우
		if(result == null) {
			metaDataService.IoMetaData(metaData, "insert");
			result =  metaDataService.getMetaData(metaData);
		} else {
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			
			String str_toDay = fm.format(new Date()); 						// 현재날짜
			String str_saveDate = fm.format(result.getSaveTime());		// 저장날짜
			
			try {
				Date toDay = fm.parse(str_toDay);
				Date saveDate = fm.parse(str_saveDate);
				
				long diff = toDay.getTime() - saveDate.getTime();
				long diffDay = diff / (24 * 60 * 60 * 1000);
				
				
				if(diffDay >=  1) {
					System.out.println("update 진입");
					metaDataService.IoMetaData(metaData, "update");
					result =  metaDataService.getMetaData(metaData);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		return result;
	}
	
}
