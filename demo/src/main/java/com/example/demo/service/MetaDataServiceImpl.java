package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.MetaData;
import com.example.demo.mapper.MetaDataMapper;

@Service
public class MetaDataServiceImpl implements MetaDataService {

	@Autowired MetaDataMapper metaDataMapper;
	
	@Override
	public MetaData getMetaData(MetaData metaData) {
		return metaDataMapper.getMetaData(metaData);
	}
	
	

}
