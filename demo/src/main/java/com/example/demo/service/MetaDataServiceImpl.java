package com.example.demo.service;

import java.util.Calendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.domain.MetaData;
import com.example.demo.mapper.MetaDataMapper;

@Service
public class MetaDataServiceImpl implements MetaDataService {

	@Autowired MetaDataMapper metaDataMapper;
	
	@Override
	@Cacheable(cacheNames = "openGraphCache", key="#metaData.url")	
	public MetaData getMetaData(MetaData metaData) {
		MetaData test= metaDataMapper.getMetaData(metaData);
		 System.out.println(test);
		 return test;
	}	
	
	
	@Override
	public void IoMetaData(MetaData metaData, String order) {
		
		MetaData result = new MetaData();
		
		try {
			String connUrl = "https://"+metaData.getUrl();
			Document doc = Jsoup.connect(connUrl).get();
			String title;
			String description;
			String image ;
			
			// og:title 
			Elements metaTitle = doc.getElementsByAttributeValue("property", "og:title");		
			if(metaTitle.attr("content").equals("")) {
				title=doc.select("title").text();
			}else{
				 title=metaTitle.attr("content");
			};
			
			// og:description
			Elements metaDescription = doc.getElementsByAttributeValue("property", "og:description");
			if(metaDescription.attr("content").equals("")) {
				description =  doc.getElementsByAttributeValue("name", "description").attr("content");
				if(description.equals("")) {
					description = "등록된 설명이 없습니다.";
				}
			}else {
				description	 = metaDescription.attr("content");
			}
			
			// og:image
			Elements metaImage = doc.getElementsByAttributeValue("property", "og:image");			
			if(metaImage.attr("content").equals("")) {
				image="https://user-images.githubusercontent.com/24848110/33519396-7e56363c-d79d-11e7-969b-09782f5ccbab.png";
			}else {
				image= metaImage.attr("content");
			}
			
			// DB insert data setting
			result.setUrl(metaData.getUrl());
			result.setTitle(title);
			result.setDescription(description);
			result.setImage(image);
			
			System.out.println("----------------------- 크롤링결과");
			System.out.println(result.getUrl()+", "+result.getTitle()+", "+result.getDescription()+", "+result.getImage());
			System.out.println("----------------------- 크롤링결과");
			
			
			switch (order) {
			case "insert":
				System.out.println("INSERT 진입2");
				metaDataMapper.insertMetaData(result);
				break;

			case "update":
				System.out.println("UPDATE 진입2");
				Calendar cal = Calendar.getInstance();
				result.setSaveTime(cal.getTime());
				metaDataMapper.updateMetaData(result);
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
