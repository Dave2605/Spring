package dao.impl;

import dao.TeacherDao;
import entities.Teacher;
import exceptions.DataFetchingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
            session = sessionFactory.getCurrentSession();
            teacherList = session.createQuery("FROM Teacher ").list();
        } catch (Exception e) {
            throw new DataFetchingException();
        }
        return teacherList;
    }

    @Loggable
    public Teacher getTeacher(Integer id) throws DataFetchingException {
        Teacher teacher;
        try {
            session = sessionFactory.getCurrentSession();
            teacher = (Teacher) session.get(Teacher.class, id);
        } catch (Exception e) {
            throw new DataFetchingException();
        }
        return teacher;
    }

    public void createTeacher(Teacher teacher) throws DataFetchingException {
        try {
            session = sessionFactory.getCurrentSession();
            Teacher tmp = teacher;
            session.save(tmp);
        } catch (Exception e) {
            throw new DataFetchingException();
        }
    }

    public void updateTeacher(Teacher teacher) throws DataFetchingException {
        try {
            session = sessionFactory.getCurrentSession();
            Teacher tmp = session.load(Teacher.class, teacher.getId());

            tmp.setFirstName(teacher.getFirstName());
            tmp.setSecondName(teacher.getSecondName());
            tmp.setAge(teacher.getAge());
            tmp.setEmail(teacher.getEmail());
        } catch (Exception e) {
            throw new DataFetchingException();
        }
    }

    public void deleteTeacher(Integer id) throws DataFetchingException {
        try {
            session = sessionFactory.getCurrentSession();
            Teacher teacher = session.load(Teacher.class, id);

            session.delete(teacher);
        } catch (Exception e) {
            throw new DataFetchingException();
        }
    }
}
