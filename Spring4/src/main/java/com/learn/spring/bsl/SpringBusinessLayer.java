package com.learn.spring.bsl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.spring.dao.SpringDao;
import com.learn.spring.dto.EntityData;

@Component
public class SpringBusinessLayer {
	@Autowired
	private SpringDao springDao;
	
	public List<EntityData> getAllEntity(){
		return springDao.getAllData();
	}
	public void addEntity(List<EntityData> e){
		if(e.size() == 1){
			springDao.addEntity(e.get(0));
		}
		else{
			springDao.addEntityBatch(e);
		}
	}
	public void addEntity(EntityData e){
		springDao.addEntity(e);
	}
	public void updateEntity(EntityData e){
		springDao.updateEntity(e);
	}
}
