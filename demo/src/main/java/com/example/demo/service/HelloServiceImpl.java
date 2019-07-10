package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

	@Override
	public Map<String, String> getMetaData(String url) {
		
		Map<String, String> result = new HashMap<String, String>();
		
		try {
			
			String connUrl = "https://"+url;
			Document doc = Jsoup.connect(connUrl).get();
			String title;
			String description;
			String image ;
			
			
			Elements metaTitle = doc.getElementsByAttributeValue("property", "og:title");		
			if(metaTitle.attr("content").equals("")) {
				title=doc.select("title").text();
			}else{
				 title=metaTitle.attr("content");
			};
			
			Elements metaDescription = doc.getElementsByAttributeValue("property", "og:description");
			if(metaDescription.attr("content").equals("")) {
				description =  doc.getElementsByAttributeValue("name", "description").attr("content");
				if(description.equals("")) {
					description = "등록된 설명이 없습니다.";
				}
			}else {
				description	 = metaDescription.attr("content");
			}
			
			Elements metaImage = doc.getElementsByAttributeValue("property", "og:image");			
			if(metaImage.attr("content").equals("")) {
				image="https://user-images.githubusercontent.com/24848110/33519396-7e56363c-d79d-11e7-969b-09782f5ccbab.png";
			}else {
				image= metaImage.attr("content");
			}
			
			result.put("title", title);
			result.put("description", description);
			result.put("image", image);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
