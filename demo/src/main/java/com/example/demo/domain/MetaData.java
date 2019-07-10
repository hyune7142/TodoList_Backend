package com.example.demo.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("MetaData")
public class MetaData {
	
	private String url;
	private String title;
	private String description;
	private String image;
	private Date saveTime;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getSaveTime() {
		return saveTime;
	}
	public void setSaveTime(Date saveTime) {
		this.saveTime = saveTime;
	}
	
	
	
}
