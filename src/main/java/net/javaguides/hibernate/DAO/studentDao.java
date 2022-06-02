package net.javaguides.hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.javaguides.hibernate.model.Student;
import net.javaguides.hibernate.util.hibernateUtil;

public class studentDao implements IstudentDAO {
	// saveStudent
	// getAllStudents
	// getStudentById
	// UpdateStudent
	// DeleteStudent

	@Override
	public void saveStudent(Student student) {
		Transaction transaction = null;

		try (Session session = hibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			session.save(student);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	@Override
	public List<Student> getAllStudent() {
		Transaction transaction = null;
		List<Student> students = null;

		try (Session session = hibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			students = session.createQuery("from student").list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return students;

	}

	@Override
	public Student getStudentById(Long id) {
		Transaction transaction = null;
		Student student = null;

		try (Session session = hibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			student = session.get(Student.class, id);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return student;

	}

	@Override
	public void updateStudent(Student student) {
		Transaction transaction = null;

		try (Session session = hibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			session.saveOrUpdate(student);

			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	@Override
	public void deleteStudent(Long id) {
		Transaction transaction = null;
		Student student = null;

		try (Session session = hibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			student = session.get(Student.class, id);

			session.delete(student);

			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

}
