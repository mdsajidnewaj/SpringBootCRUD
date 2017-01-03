package com.Tas.Dao;

import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;  

import com.Tas.Entity.Student;



@Repository("mysql")
public class MySqlStudentDaoImpl implements StudentDao{
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/studentsdevdb";
	
	
	@Autowired
	private JdbcTemplate jbdcTemplate; 

	public static class StudentRowMapper implements RowMapper<Student>{

		@Override
		public Student mapRow(ResultSet resultSet, int i) throws SQLException {
			Student student = new Student();
	    	student.setId(resultSet.getInt("id"));
	    	student.setName(resultSet.getString("Name"));
	    	student.setCourse(resultSet.getString("course"));
	        return student;
		}
		
	}
	
	@Override
	public Collection<Student> GetAllStudents() {
	
		
		final String sql = "SELECT id, name, course FROM students";
		List<Student> students = jbdcTemplate.query(sql, new StudentRowMapper());  
		 return students;
	}

	@Override
	public Student getStudentById(int id) {
		final String sql = "SELECT id, name, course FROM students where id = ?";
		Student student = jbdcTemplate.queryForObject(sql, new StudentRowMapper(), id);
		
		return student;
	}

		
	@Override
	public void removeStudentById(int id) {
	
		final String sql = "DELETE FROM students where id = ?";
		jbdcTemplate.update(sql,id);
		
	}
	
	@Override
	public void updateStudent(Student student) {
		final String sql = "UPDATE students SET name = ?, course = ?  where id = ?";
		int id = student.getId();
		final String name = student.getName();
		final String course = student.getCourse();
		jbdcTemplate.update(sql,new Object[]{name, course,id });
	}

	@Override
	public void insertStudentToDb(Student student) {
		
		final String sql = "INSERT INTO students(name, course) VALUES(? , ?)";
		final String name = student.getName();
		final String course = student.getCourse();
		jbdcTemplate.update(sql,new Object[]{name, course });
	}

}
