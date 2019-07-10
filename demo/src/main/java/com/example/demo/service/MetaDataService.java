package com.example.demo.service;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.MetaData;

@Transactional
public interface MetaDataService {
	
	public MetaData getMetaData(MetaData metaData);
	
	public void insertMetaData(MetaData metaData);
	
}
