package com.learn.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;

public class Main {
	
	@Autowired
	private static SpringDao springDao;

	public static void main(String args[]){
		System.out.println(springDao.getAllData());
	}

}
