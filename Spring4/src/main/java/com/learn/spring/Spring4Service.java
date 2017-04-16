package com.learn.spring;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.spring.bsl.SpringBusinessLayer;
import com.learn.spring.dto.EntityData;

@Service
public class Spring4Service {
	
	private SpringBusinessLayer springBusinessLayer;
	
	public SpringBusinessLayer getSpringBusinessLayer() {
		return springBusinessLayer;
	}
	@Autowired
	public void setSpringBusinessLayer(SpringBusinessLayer springBusinessLayer) {
		this.springBusinessLayer = springBusinessLayer;
	}
	Logger log = Logger.getLogger(Spring4Service.class.getName());
	public List<EntityData> operation(){
		log.info("inside Spring4Service");
		return springBusinessLayer.getAllEntity();
	}
}
