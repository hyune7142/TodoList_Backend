package com.example.demo.mapper;

import org.springframework.stereotype.Repository;
import com.example.demo.domain.MetaData;

@Repository
public interface MetaDataMapper {
	
	public MetaData getData(MetaData metaData);
	
	// select MetaData
	public MetaData getMetaData(MetaData metaData);
	
	// insert MetaData
	public void insertMetaData(MetaData metaData);
	
	// update MetaData
	public void updateMetaData(MetaData metaData);
	
}
