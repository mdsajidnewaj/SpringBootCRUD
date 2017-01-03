package com.Tas.Dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.Tas.Entity.Student;

@Repository
@Qualifier("fakedata")
public class FakeStudentDaoImpl implements StudentDao {

	private static Map<Integer, Student> students;
	
	static{
		students = new HashMap<Integer, Student>(){
			{
				put(1, new Student(1, "Sajid", "Computer Science"));
				put(2, new Student(2, "sam", "Computer Science"));
				put(3, new Student(3, "shi", "Computer Science"));
			}
		};
	}
	/* (non-Javadoc)
	 * @see com.Tas.Dao.StudentDao#GetAllStudents()
	 */
	@Override
	public Collection<Student>GetAllStudents(){
		return this.students.values();
	}
	
	/* (non-Javadoc)
	 * @see com.Tas.Dao.StudentDao#getStudentById(int)
	 */
	@Override
	public Student getStudentById(int id){
		return this.students.get(id);
	}

	/* (non-Javadoc)
	 * @see com.Tas.Dao.StudentDao#removeStudentById(int)
	 */
	@Override
	public void removeStudentById(int id) {
		this.students.remove(id);
	}
	
	/* (non-Javadoc)
	 * @see com.Tas.Dao.StudentDao#updateStudent(com.Tas.Entity.Student)
	 */
	@Override
	public void updateStudent(Student student){
		Student s = students.get(student.getId());
		s.setCourse(student.getCourse());
		s.setName(student.getName());
		students.put(student.getId(), student);
	}

	/* (non-Javadoc)
	 * @see com.Tas.Dao.StudentDao#insertStudentToDb(com.Tas.Entity.Student)
	 */
	@Override
	public void insertStudentToDb(Student student) {
		this.students.put(student.getId(), student);
		
	}
	
}
