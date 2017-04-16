package com.learn.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Produces;
import org.springframework.http.MediaType;
import javax.ws.rs.core.Request;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.spring.Spring4Service;
import com.learn.spring.dto.EntityData;

//@Controller
@RestController
@RequestMapping("/controller")
public class HelloWorldController {
	Logger log = Logger.getLogger(HelloWorldController.class.getName());
	//@Autowired
	//private Spring4Service spring4Service;
	 @RequestMapping("/hello")
	 public void hello() {
	  
		 log.info("Coming into the controller class hello() method");
		 //log.info(spring4Service.operation().toString());
		 String systemProperty = System.getProperty("subra");
		 log.info(systemProperty);
	 
	 }
	 
	 @RequestMapping(value="/getentity", produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	 public ResponseEntity<String> getEntity() {
		 ObjectMapper mapper = new ObjectMapper();
		 log.info("Coming into the controller class getEntity() method");
		 String systemProperty = System.getProperty("subra");
		 log.info(systemProperty);
		List<EntityData> entiytyObjectlist = dataList(); 
		List<String> entiytyStringlist = new ArrayList<String>();
		try {
			for(EntityData e:entiytyObjectlist){
				String json = mapper.writeValueAsString(e);
				entiytyStringlist.add(json);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		 log.info(entiytyStringlist.toString());
		 return new ResponseEntity<String>(entiytyStringlist.toString(),HttpStatus.OK);
		 //return jsonString;
	 
	 }
	 @RequestMapping(value="/getentity/{id}", produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	 public ResponseEntity<String> getEntity(@PathVariable("id") int id) {
		 log.info("Coming into the controller class getEntity()/{id} method");
		 ObjectMapper mapper = new ObjectMapper();
		 String json = null;
		 List<EntityData> entiytyObjectlist = dataList();
		 EntityData e1 = entiytyObjectlist.get(id);
		 try {
				json = mapper.writeValueAsString(e1);	
			}catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		 return new ResponseEntity<String>(json.toString(),HttpStatus.OK);	
	 }
	 
	 private List<EntityData> dataList(){
		 	EntityData entitydata = new EntityData(1, "Neeraj", "Hyderabad", 50000);
			EntityData entitydata1 = new EntityData(2, "Subra", "Hyderabad", 30000);
			EntityData entitydata2 = new EntityData(3, "Debasis", "Bangalore", 40000);
			EntityData entitydata3 = new EntityData(4, "Mamu", "Hyderabad", 35000);
			EntityData entitydata4 = new EntityData(5, "Soumya", "Hyderabad", 20000);
			List<EntityData> entiytyObjectlist = new ArrayList<EntityData>();
			entiytyObjectlist.add(entitydata);
			entiytyObjectlist.add(entitydata1);
			entiytyObjectlist.add(entitydata2);
			entiytyObjectlist.add(entitydata3);
			entiytyObjectlist.add(entitydata4);
			
			return entiytyObjectlist;
	 }
	 
	}