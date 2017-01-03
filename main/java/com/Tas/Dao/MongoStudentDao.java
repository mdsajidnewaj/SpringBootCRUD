package com.Tas.Dao;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.Tas.Entity.Student;

@Repository
@Qualifier("mongoData")
public class MongoStudentDao implements StudentDao{
	
	
	
	@Override
	public Collection<Student> GetAllStudents() {
		return new ArrayList<Student>(){
			
		};
	}

	@Override
	public Student getStudentById(int id){
		return null;
	}

	@Override
	public void removeStudentById(int id){
		
	}

	@Override
	public void updateStudent(Student student){
		
	}

	@Override
	public void insertStudentToDb(Student student){
		
	}

}
