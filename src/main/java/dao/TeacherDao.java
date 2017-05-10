package dao;

import entities.Teacher;
import exceptions.DataFetchingException;

import java.util.List;

public interface TeacherDao {

    List<Teacher> getAll() throws DataFetchingException;

    Teacher getTeacher(Integer id) throws DataFetchingException;

    void createTeacher(Teacher teacher) throws DataFetchingException;

    void updateTeacher(Teacher teacher) throws DataFetchingException;

    void deleteTeacher(Integer id) throws DataFetchingException;
}
