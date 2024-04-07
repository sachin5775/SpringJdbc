package com.springjdbc.dao;

import java.util.List;

import com.springjdbc.entities.Student;

public interface StudentDao {
	int insert(Student student);

	int update(Student student);

	int delete(int id);

	Student getStudent(int id);

	List<Student> getAll();
}
