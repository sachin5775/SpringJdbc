package com.springjdbc;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springjdbc.dao.StudentDaoImpl;
import com.springjdbc.entities.Student;

public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("conf.xml");
		StudentDaoImpl studentDaoImpl = context.getBean("StudentDao", StudentDaoImpl.class);

		Student student = new Student();
		student.setId(444);
		student.setName("Sachin");
		student.setMarks("98");
		student.setRollNo("54");
		int insert = studentDaoImpl.insert(student);
		System.out.println("Row inserted " + insert);
		System.out.println("=============================================");

		Student student1 = new Student();
		student1.setName("Ram");
		student1.setMarks("89");
		student1.setId(444);
		int update = studentDaoImpl.update(student1);
		System.out.println("Row Updated " + update);
		System.out.println("=============================================");

		Student st2 = new Student();
		st2.setId(444);
		Student student2 = studentDaoImpl.getStudent(st2.getId());
		System.out.println("Student get " + student2);
		System.out.println("=============================================");

		int delete = studentDaoImpl.delete(st2.getId());
		System.out.println("Row deleted " + delete);
		List<Student> students = studentDaoImpl.getAll();
		students.forEach(s -> {
			System.out.println("Student " + s);
		});

		System.out.println("=============================================");

		context.close();
	}
}
