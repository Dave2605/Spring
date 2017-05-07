package rest;

import entities.Teacher;
import exceptions.DataFetchingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import service.TeacherService;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/getAll", method = GET)
    public ModelAndView getAll(String creationFlag) {
        List<Teacher> teachers = null;
        String resultView;
        if (creationFlag != null && creationFlag.equals("create subject")) {
            resultView = "createSubject";
        } else {
            resultView = "showTeachers";
        }
        try {
            teachers = teacherService.getAll();
        } catch (DataFetchingException e) {
            resultView = "error";
        }
        ModelAndView modelAndView = new ModelAndView(resultView);
        modelAndView.addObject("teachers", teachers);

        return modelAndView;
    }

    @RequestMapping(method = GET)
    public ModelAndView getTeacher(String id) {
        Teacher teacher = null;
        String resultView = "editTeacher";
        try {
            teacher = teacherService.getTeacher(Integer.valueOf(id));
        } catch (DataFetchingException e) {
            resultView = "error";
        }
        ModelAndView modelAndView = new ModelAndView(resultView);
        modelAndView.addObject("teacher", teacher);

        return modelAndView;
    }

    @RequestMapping(value = "create", method = POST)
    public ModelAndView createTeacher(String firstName, String secondName, String age, String email) {
        List<Teacher> teachers = null;
       String resultView = "showTeachers";
        try {
            teacherService.createTeacher(firstName, secondName, Integer.valueOf(age), email);
            teachers = teacherService.getAll();
        } catch (DataFetchingException e) {
            resultView = "error";
        }
        ModelAndView modelAndView = new ModelAndView(resultView);
        modelAndView.addObject("teachers", teachers);

        return modelAndView;
    }

    @RequestMapping(value = "update", method = POST)
    public ModelAndView updateTeacher(String id, String firstName, String secondName, String age, String email) {
        List<Teacher> teachers = null;
        String resultView = "showTeachers";
        try {
            teacherService.updateTeacher(Integer.valueOf(id), firstName, secondName, Integer.valueOf(age), email);
            teachers = teacherService.getAll();
        } catch (DataFetchingException e) {
            resultView = "error";
        }
        ModelAndView modelAndView = new ModelAndView(resultView);
        modelAndView.addObject("teachers", teachers);

        return modelAndView;
    }

    @RequestMapping(value = "delete", method = POST)
    public ModelAndView deleteTeacher(String id) {
        List<Teacher> teachers = null;
        String resultView = "showTeachers";
        try {
            teacherService.deleteTeacher(Integer.valueOf(id));
            teachers = teacherService.getAll();
        } catch (DataFetchingException e) {
            resultView = "error";
        }
        ModelAndView modelAndView = new ModelAndView(resultView);
        modelAndView.addObject("teachers", teachers);

        return modelAndView;
    }
}
