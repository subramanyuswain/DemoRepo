package com.learn.springexception;

public class EntityData{
	private final int employeeId;
	private final String name;
	private final String address;
	private final int salary;
	public EntityData(){
		employeeId = 0;
		name = null;
		address = null;
		salary = 0;
	}
	public EntityData(int employeeId, String name, String address, int salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public int getSalary() {
		return salary;
	}
	public int hashCode(){
		return this.employeeId;
	}
	public String toString(){
		return this.getEmployeeId()+","+
				this.getName()+","+
				this.getAddress()+","+
				this.getSalary();
	}
}
