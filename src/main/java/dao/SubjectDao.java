package dao;

import entities.Subject;
import exceptions.DataFetchingException;

import java.util.List;

public interface SubjectDao {

    List<Subject> getAll() throws DataFetchingException;

    Subject getSubject(Integer id) throws DataFetchingException;

    void createSubject(String name, String subjectGroup, Integer passScore, Integer teacherId) throws DataFetchingException;

    void updateSubject(Integer id, String name, String subjectGroup, Integer passScore, Integer teacherId) throws DataFetchingException;

    void deleteSubject(Integer id) throws DataFetchingException;
}

