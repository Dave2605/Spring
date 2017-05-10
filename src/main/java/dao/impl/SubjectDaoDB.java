package dao.impl;

import dao.SubjectDao;
import entities.Subject;
import entities.Teacher;
import exceptions.DataFetchingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import util.annotations.Loggable;

import java.util.List;

@Loggable
@Repository
public class SubjectDaoDB implements SubjectDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session;

    public List<Subject> getAll() throws DataFetchingException {
        List<Subject> subjectList;
        try {
            session = sessionFactory.getCurrentSession();
            subjectList = session.createQuery("FROM Subject ").list();
        } catch (Exception e) {
            throw new DataFetchingException();
        }
        return subjectList;
    }

    public Subject getSubject(Integer id) throws DataFetchingException {
        Subject subject;
        try {
            session = sessionFactory.getCurrentSession();
            subject = (Subject) session.get(Subject.class, id);
        } catch (Exception e) {
            throw new DataFetchingException();
        }
        return subject;
    }

    public void createSubject(Subject subject) throws DataFetchingException {
        try {
            session = sessionFactory.getCurrentSession();

            Teacher teacher = session.get(Teacher.class, subject.getTeacherId());
            subject.setTeacher(teacher);

            session.save(subject);
        } catch (Exception e) {
            session.close();
            throw new DataFetchingException();
        }
    }

    public void updateSubject(Subject subject) throws DataFetchingException {
        try {
            session = sessionFactory.getCurrentSession();

            Teacher teacher = session.get(Teacher.class, subject.getTeacherId());
            Subject tmp = session.load(Subject.class, subject.getId());

            tmp.setName(subject.getName());
            tmp.setSubjectGroup(subject.getSubjectGroup());
            tmp.setPassScore(subject.getPassScore());
            tmp.setTeacher(teacher);

        } catch (Exception e) {
            throw new DataFetchingException();
        }
    }

    public void deleteSubject(Integer id) throws DataFetchingException {
        try {
            session = sessionFactory.getCurrentSession();
            Subject subject = session.load(Subject.class, id);
            session.delete(subject);
        } catch (Exception e) {
            throw new DataFetchingException();
        }
    }
}
