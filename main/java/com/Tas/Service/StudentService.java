package com.Tas.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Tas.Dao.StudentDao;
import com.Tas.Entity.Student;

@Service
public class StudentService {
	
	@Autowired
	@Qualifier("mysql")
	private StudentDao studentDao;
	
	public Collection<Student> GetAllStudents(){
		return this.studentDao.GetAllStudents();
	}
	
	public Student getStudentById(int id){
		return this.studentDao.getStudentById(id);
	}

	public void removeStudentById(int id) {
		this.studentDao.removeStudentById(id);
		
	}
	public void updateStudent(Student student){
		this.studentDao.updateStudent(student);
	}

	public void insertStudent(Student student) {
		
		studentDao.insertStudentToDb(student);
	}

	
}
