package com.bridgelabz.SpringDependency;

public class Employee {
	private int id;
	private String name;
	private Address address;

	public Employee() {
		System.out.println("Default constructor");

	}

	public Employee(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	void show() {
		System.out.println("id:" + id + " " + "Name:" + name);
		System.out.println(address.toString());
	}

}
