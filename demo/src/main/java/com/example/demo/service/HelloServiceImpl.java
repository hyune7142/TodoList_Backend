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
			System.out.println(doc.toString());
			
			Elements metaTitle = doc.getElementsByAttributeValue("property", "og:title");	
			String title = metaTitle.attr("content");
				
			Elements metaDescription = doc.getElementsByAttributeValue("property", "og:description");
			String description = metaDescription.attr("content");
			
			Elements metaImage = doc.getElementsByAttributeValue("property", "og:image");
			String image = metaImage.attr("content");
			
			
//			System.out.println(title);
//			System.out.println(description);
//			System.out.println(image);
			
			result.put("title", title);
			result.put("description", description);
			result.put("image", image);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
