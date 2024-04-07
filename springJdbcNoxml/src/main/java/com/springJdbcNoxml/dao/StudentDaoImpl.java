package com.springJdbcNoxml.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springJdbcNoxml.entities.Student;

import lombok.Data;

@Data
public class StudentDaoImpl implements StudentDao {
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student student) {
		String query = "INSERT INTO STUDENT(id,name,rollNo ,marks) VALUES (?, ?, ?, ?)";
		int execure = jdbcTemplate.update(query, student.getId(), student.getName(), student.getRollNo(),
				student.getMarks());
		return execure;
	}

	@Override
	public int update(Student student) {
		String query = "UPDATE STUDENT SET name = ?, marks = ?, rollNo = ?	WHERE id=?";
		int update = jdbcTemplate.update(query, student.getName(), student.getMarks(), student.getRollNo(),
				student.getId());
		return update;
	}

	@Override
	public int delete(int id) {
		String query = "DELETE FROM STUDENT WHERE ID=?";
		int update = jdbcTemplate.update(query, id);
		return update;
	}

	@Override
	public Student getStudent(int id) {
		String query = "Select * from STUDENT where id=?";
		RowMapperImpl rowMapperImpl = new RowMapperImpl();
		Student queryForObject = jdbcTemplate.queryForObject(query, rowMapperImpl, id);
		return queryForObject;
	}

	@Override
	public List<Student> getAll() {
		String query = "Select * from STUDENT ";
		RowMapperImpl rowMapperImpl = new RowMapperImpl();
		List<Student> students = jdbcTemplate.query(query, rowMapperImpl);
		return students;
	}

}
