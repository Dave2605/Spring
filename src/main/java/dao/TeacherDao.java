package dao;

import entities.Teacher;
import exceptions.DataFetchingException;

import java.util.List;

public interface TeacherDao {

    List<Teacher> getAll() throws DataFetchingException;

    Teacher getTeacher(Integer id) throws DataFetchingException;

    void createTeacher(String firstName, String secondName, Integer age, String email) throws DataFetchingException;

    void updateTeacher(Integer id, String firstName, String secondName, Integer age, String email) throws DataFetchingException;

    void deleteTeacher(Integer id) throws DataFetchingException;
}
