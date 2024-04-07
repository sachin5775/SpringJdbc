package com.springjdbc.entities;

import lombok.Data;

@Data
public class Student {
	private int id;
	private String name;
	private String rollNo;
	private String marks;

	/**
	 * @param id
	 * @param name
	 * @param rollNo
	 * @param marks
	 */
	public Student(int id, String name, String rollNo, String marks) {
		super();
		this.id = id;
		this.name = name;
		this.rollNo = rollNo;
		this.marks = marks;
	}

	/**
	 * 
	 */
	public Student() {
	}

}
