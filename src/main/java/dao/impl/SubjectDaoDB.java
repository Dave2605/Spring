package dao.impl;

import dao.SubjectDao;
import entities.Subject;
import org.hibernate.Session;

import java.util.ArrayList;

public class SubjectDaoDB implements SubjectDao {

    public ArrayList<Subject> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = String.format("from %s",typeParameterClass.getCanonicalName());
        Query SQLQuery = session.createQuery(hql);
        ArrayList<Bean> result = (ArrayList<Bean>) SQLQuery.list();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return result;
    }
}
