package dao;

import entities.Subject;
import exceptions.DataFetchingException;

import java.util.List;

public interface SubjectDao {

    List<Subject> getAll() throws DataFetchingException;

    Subject getSubject(Integer id) throws DataFetchingException;

    void createSubject(Subject subject) throws DataFetchingException;

    void updateSubject(Subject subject) throws DataFetchingException;

    void deleteSubject(Integer id) throws DataFetchingException;
}

