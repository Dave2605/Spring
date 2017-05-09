package service;

import dao.TeacherDao;
import entities.Teacher;
import exceptions.DataFetchingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    public List<Teacher> getAll() throws DataFetchingException {
        return teacherDao.getAll();
    }

    public Teacher getTeacher(Integer id) throws DataFetchingException {
        return teacherDao.getTeacher(id);
    }

    public void createTeacher(String firstName, String secondName, Integer age, String email)
            throws DataFetchingException {
        teacherDao.createTeacher(firstName, secondName, age, email);
    }

    @Transactional
    public void updateTeacher(Integer id, String firstName, String secondName, Integer age, String email)
            throws DataFetchingException {
        teacherDao.updateTeacher(id, firstName, secondName, age, email);
    }

    public void deleteTeacher(Integer id) throws DataFetchingException {
        teacherDao.deleteTeacher(id);
    }
}
