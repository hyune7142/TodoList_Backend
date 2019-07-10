package com.example.demo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.MetaData;
import com.example.demo.mapper.MetaDataMapper;
import com.example.demo.service.MetaDataService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MetaDataController {
	
	@Autowired MetaDataService metaDataService;
	@Autowired MetaDataMapper metaDataMapper;
	
	@RequestMapping(value="/metadata", method=RequestMethod.GET)
	public MetaData index(MetaData metaData) throws IOException {
		
		long start = System.currentTimeMillis();
		
		MetaData result = metaDataMapper.getData(metaData);	 // 캐쉬생성 X
		
		// 요청 url 정보가 DB에 없을 경우
		if(result == null) {
			System.out.println("insert 출력");
			metaDataService.IoMetaData(metaData, "insert"); 
			result =  metaDataService.getMetaData(metaData);
		} else {
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			
			String str_toDay = fm.format(new Date()); 						// 현재날짜
			String str_saveDate = fm.format(result.getSaveTime());		// 저장날짜
			
			System.out.println("현재날짜 : "+str_toDay);
			System.out.println("저장날짜"+str_saveDate);
			
			try {
				Date toDay = fm.parse(str_toDay);
				Date saveDate = fm.parse(str_saveDate);
				
				long diff = toDay.getTime() - saveDate.getTime();
				long diffDay = diff / (24 * 60 * 60 * 1000);
				
				
				if(diffDay >  1) {
					System.out.println("update 출력");
					metaDataService.IoMetaData(metaData, "update");
					result =  metaDataService.getMetaData(metaData);
				}else {
					System.out.println("일반 출력");
					result =  metaDataService.getMetaData(metaData);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	    long end = System.currentTimeMillis();
	    System.out.println("시간측정"+"  :  " +Long.toString(end-start));
		return result;
	}
	
}
