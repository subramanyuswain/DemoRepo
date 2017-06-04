package com.learn.springexception;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@RequestMapping("/controller")
public class RestexceptionApplication {
	Logger log = Logger.getLogger(RestexceptionApplication.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(RestexceptionApplication.class, args);
	}
	
	 @RequestMapping(value="/getentity/{id}", produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	 public ResponseEntity<String> getEntity(@PathVariable("id") int id) throws CustomerNotFoundException {
		 log.info("Coming into the controller class getEntity()/{"+id+"} method");
		 ObjectMapper mapper = new ObjectMapper();
		 String json = null;
		 List<EntityData> entiytyObjectlist = dataList();
		 EntityData e1 = entiytyObjectlist.get(id-1);
		 try {
				json = mapper.writeValueAsString(e1);	
			}catch (JsonProcessingException e) {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);	
				//e.printStackTrace();
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
