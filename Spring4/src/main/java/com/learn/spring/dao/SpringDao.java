package com.learn.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.learn.spring.dto.EntityData;

@Repository("springDao")
public class SpringDao {
	
	public List<EntityData> getAllData(){
		System.out.println("Inside getAllDao()");
		return Database.entityDataList;
	}
	public boolean addEntity(EntityData e){
		if(Database.entityDataList.contains(e)){
			return false;
		}
		Database.entityDataList.add(e);
		return true;
	}
	public boolean addEntityBatch(List<EntityData> e){
		Database.entityDataList.addAll(e);
		return true;
	}
	public synchronized boolean updateEntity(EntityData e){
		if(Database.entityDataList.contains(e)){
			Database.entityDataList.remove(e);
			Database.entityDataList.add(e);
			return true;
		}
		else{
			Database.entityDataList.add(e);
			return true;
		}
	}
	public void loadData(){
		Database.entityDataList.addAll(Database.backupDataList);
	}
	
	public static class Database{
		
		private static List<EntityData> entityDataList;
		private static List<EntityData> backupDataList;
		
		static{
			EntityData entitydata = new EntityData(1,"Neeraj","Hyderabad",50000);
			EntityData entitydata1 = new EntityData(2,"Subra","Hyderabad",30000);
			EntityData entitydata2 = new EntityData(3,"Debasis","Bangalore",40000);
			EntityData entitydata3 = new EntityData(4,"Mamu","Hyderabad",35000);
			EntityData entitydata4 = new EntityData(5,"Soumya","Hyderabad",20000);
			entityDataList.add(entitydata);
			entityDataList.add(entitydata1);
			entityDataList.add(entitydata2);
			entityDataList.add(entitydata3);
			entityDataList.add(entitydata4);
		}
	}
}
