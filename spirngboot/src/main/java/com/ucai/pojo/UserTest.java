package com.ucai.pojo;

public class UserTest 
{
	
	private String userName;
	private int age;
	private String sex;
	
	
	
	public UserTest(){}

	
	
	public UserTest(String userName, int age, String sex) {
		this.userName = userName;
		this.age = age;
		this.sex = sex;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	

}
