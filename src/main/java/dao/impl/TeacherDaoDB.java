package dao.impl;

import dao.TeacherDao;
import entities.Teacher;
import exceptions.DataFetchingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import util.annotations.Loggable;

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

    @Loggable
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

    @Transactional
    public void createTeacher(String firstName, String secondName, Integer age, String email) throws DataFetchingException {
        try {
            session = sessionFactory.openSession();

            Teacher teacher = new Teacher(firstName, secondName, age, email);

            session.save(teacher);
            session.close();
        } catch (Exception e) {
            session.close();
            throw new DataFetchingException();
        }
    }

    @Transactional
    public void updateTeacher(Integer id, String firstName, String secondName, Integer age, String email) throws DataFetchingException {
        try {
            session = sessionFactory.openSession();
            Teacher teacher = session.load(Teacher.class, id);

            teacher.setFirstName(firstName);
            teacher.setSecondName(secondName);
            teacher.setAge(age);
            teacher.setEmail(email);

            session.close();
        } catch (Exception e) {
            session.close();
            throw new DataFetchingException();
        }
    }

    @Transactional
    public void deleteTeacher(Integer id) throws DataFetchingException {
        try {
            session = sessionFactory.openSession();
            Teacher teacher = session.load(Teacher.class, id);

            session.delete(teacher);
            session.close();
        } catch (Exception e) {
            session.close();
            throw new DataFetchingException();
        }
    }
}
