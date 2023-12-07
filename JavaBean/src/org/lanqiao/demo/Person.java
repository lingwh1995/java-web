package org.lanqiao.demo;

public class Person {	
	private String name;
	private int age;
	private String gender;
	private boolean bool;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int age, String gender, boolean bool) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.bool = bool;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isBool() {
		return bool;
	}
	public void setBool(boolean bool) {
		this.bool = bool;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", bool=" + bool + "]";
	}
	
	
}
