package net.javaguides.hibernate;

import java.util.List;

import net.javaguides.hibernate.DAO.IstudentDAO;
import net.javaguides.hibernate.DAO.studentDao;
import net.javaguides.hibernate.model.Student;

public class App {

	public static void main(String[] args) {
		Student st = new Student("ghaith", "zoughlemi", "ghaithzoughlemi@gamil.com");
		IstudentDAO stDAO = new studentDao();
		stDAO.saveStudent(st);

		st.setFirstname("gait");
		stDAO.updateStudent(st);

		Student st2 = stDAO.getStudentById(st.getId());

		List<Student> students = stDAO.getAllStudent();
		students.forEach(student1 -> System.out.println(student1.getId()));

	}

}
