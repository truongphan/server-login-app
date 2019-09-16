package com.training.model;

public class UserDto {
	private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int age;
    private int salary;
    
    public UserDto() {}
    
    public UserDto(String firstName, String lastName, String username, String password, int age, int salary) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.username = username;
    	this.password = password;
    	this.age = age;
    	this.salary = salary;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
    
    
}
