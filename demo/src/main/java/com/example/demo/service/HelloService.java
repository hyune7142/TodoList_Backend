package com.example.demo.service;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.MetaData;

@Transactional
public interface HelloService {
	
	public MetaData getMetaData(MetaData metaData);

}
