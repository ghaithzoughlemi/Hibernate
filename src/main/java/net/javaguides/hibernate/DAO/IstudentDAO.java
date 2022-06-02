package net.javaguides.hibernate.DAO;

import java.util.List;

import net.javaguides.hibernate.model.Student;

public interface IstudentDAO {

	void saveStudent(Student student);

	List<Student> getAllStudent();

	Student getStudentById(Long id);

	void updateStudent(Student student);

	void deleteStudent(Long id);

}