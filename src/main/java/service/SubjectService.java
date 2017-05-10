package service;

import dao.SubjectDao;
import entities.Subject;
import exceptions.DataFetchingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Transactional
    public List<Subject> getAll() throws DataFetchingException {
        return subjectDao.getAll();
    }

    @Transactional
    public Subject getSubject(Integer id) throws DataFetchingException {
        return subjectDao.getSubject(id);
    }

    @Transactional
    public void createSubject(Subject subject)
            throws DataFetchingException {
        subjectDao.createSubject(subject);
    }

    @Transactional
    public void updateSubject(Subject subject)
            throws DataFetchingException {
        subjectDao.updateSubject(subject);
    }

    @Transactional
    public void deleteSubject(Integer id) throws DataFetchingException {
        subjectDao.deleteSubject(id);
    }
}
