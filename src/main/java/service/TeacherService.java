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

    @Transactional
    public List<Teacher> getAll() throws DataFetchingException {
        return teacherDao.getAll();
    }

    @Transactional
    public Teacher getTeacher(Integer id) throws DataFetchingException {
        return teacherDao.getTeacher(id);
    }

    @Transactional
    public void createTeacher(Teacher teacher)
            throws DataFetchingException {
        teacherDao.createTeacher(teacher);
    }

    @Transactional
    public void updateTeacher(Teacher teacher)
            throws DataFetchingException {
        teacherDao.updateTeacher(teacher);
    }

    @Transactional
    public void deleteTeacher(Integer id) throws DataFetchingException {
        teacherDao.deleteTeacher(id);
    }
}
