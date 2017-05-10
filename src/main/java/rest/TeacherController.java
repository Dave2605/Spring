package rest;

import entities.Teacher;
import exceptions.DataFetchingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import service.TeacherService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "all", method = GET)
    public ModelAndView showTeachers(String creationFlag) {
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

    @RequestMapping(value = "create", method = GET)
    public ModelAndView viewCreate() {
        Teacher teacher = new Teacher();
        ModelAndView modelAndView = new ModelAndView("createTeacher");
        modelAndView.addObject("teacher", teacher);
        return modelAndView;
    }

    @RequestMapping(value = "create", method = POST)
    public ModelAndView doCreate(@Valid @ModelAttribute("teacher") Teacher teacher,
                                 BindingResult result) {
        ModelAndView error = new ModelAndView("createTeacher");
        String url = "redirect:all";
        if (result.hasErrors()) {
            return error;
        }
        try {
            teacherService.createTeacher(teacher);
        } catch (DataFetchingException e) {
            url = "error";
        }
        ModelAndView all = new ModelAndView(url);
        return all;
    }

    @RequestMapping(value = "update", method = GET)
    public ModelAndView viewUpdate(String id) {
        Teacher teacher = null;
        String url = "editTeacher";
        try {
            teacher = teacherService.getTeacher(Integer.valueOf(id));
        } catch (DataFetchingException e) {
            url = "error";
        }
        ModelAndView modelAndView = new ModelAndView(url);
        modelAndView.addObject("teacher", teacher);
        return modelAndView;
    }

    @RequestMapping(value = "update", method = POST)
    public ModelAndView doUpdate(@Valid @ModelAttribute("teacher") Teacher teacher,
                                 BindingResult result) {
        ModelAndView error = new ModelAndView("editTeacher");
        String url = "redirect:/teacher/all";
        if (result.hasErrors()) {
            return error;
        }
        try {
            teacherService.updateTeacher(teacher);
        } catch (DataFetchingException e) {
            url = "error";
        }
        ModelAndView all = new ModelAndView(url);
        return all;
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
