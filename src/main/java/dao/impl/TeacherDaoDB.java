package dao.impl;

import dao.TeacherDao;
import entities.Teacher;
import exceptions.DataFetchingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDaoDB implements TeacherDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session;

    public List<Teacher> getAll() throws DataFetchingException {
        List<Teacher> teacherList;
        try {
            session = sessionFactory.openSession();
            teacherList = session.createQuery("FROM Teacher ").list();
            session.close();
        } catch (Exception e) {
            session.close();
            throw new DataFetchingException();
        }
        return teacherList;
    }

    public Teacher getTeacher(Integer id) throws DataFetchingException {
        Teacher teacher;
        try {
            session = sessionFactory.openSession();
            teacher = (Teacher) session.get(Teacher.class, id);
            session.close();
        } catch (Exception e) {
            session.close();
            throw new DataFetchingException();
        }
        return teacher;
    }

    public void createTeacher(String firstName, String secondName, Integer age, String email) throws DataFetchingException {
        try {
            session = sessionFactory.openSession();

            Teacher teacher = new Teacher(firstName, secondName, age, email);

            Transaction transaction = session.beginTransaction();

            session.save(teacher);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            session.close();
            throw new DataFetchingException();
        }
    }

    public void updateTeacher(Integer id, String firstName, String secondName, Integer age, String email) throws DataFetchingException {
        try {
            session = sessionFactory.openSession();
            Teacher teacher = session.load(Teacher.class, id);

            Transaction transaction = session.beginTransaction();

            teacher.setFirstName(firstName);
            teacher.setSecondName(secondName);
            teacher.setAge(age);
            teacher.setEmail(email);

            transaction.commit();
            session.close();
        } catch (Exception e) {
            session.close();
            throw new DataFetchingException();
        }
    }

    public void deleteTeacher(Integer id) throws DataFetchingException {
        try {
            session = sessionFactory.openSession();
            Teacher teacher = session.load(Teacher.class, id);

            Transaction transaction = session.beginTransaction();
            session.delete(teacher);
            transaction.commit();

            session.close();
        } catch (Exception e) {
            session.close();
            throw new DataFetchingException();
        }
    }
}
