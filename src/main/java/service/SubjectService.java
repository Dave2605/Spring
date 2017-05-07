package service;

import dao.SubjectDao;
import entities.Subject;
import exceptions.DataFetchingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    public List<Subject> getAll() throws DataFetchingException {
        return subjectDao.getAll();
    }

    public Subject getSubject(Integer id) throws DataFetchingException {
        return subjectDao.getSubject(id);
    }

    public void createSubject(String name, String subjectGroup, Integer passScore, Integer teacherId)
            throws DataFetchingException {
        subjectDao.createSubject(name, subjectGroup, passScore, teacherId);
    }

    public void updateSubject(Integer id, String name, String subjectGroup, Integer passScore, Integer teacherId)
            throws DataFetchingException {
        subjectDao.updateSubject(id, name, subjectGroup, passScore, teacherId);
    }

    public void deleteSubject(Integer id) throws DataFetchingException {
        subjectDao.deleteSubject(id);
    }
}
