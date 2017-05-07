package rest;

import entities.Subject;
import entities.Teacher;
import exceptions.DataFetchingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import service.SubjectService;
import service.TeacherService;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/getAll", method = GET)
    public ModelAndView getAll() {
        List<Subject> subjects = null;
        String resultView = "showSubjects";
        try {
            subjects = subjectService.getAll();
        } catch (DataFetchingException e) {
            resultView = "error";
        }
        ModelAndView modelAndView = new ModelAndView(resultView);
        modelAndView.addObject("subjects", subjects);

        return modelAndView;
    }

    @RequestMapping(method = GET)
    public ModelAndView getSubject(String id) {
        List<Teacher> teachers = null;
        Subject subject = null;
        String resultView = "editSubject";
        try {
            subject = subjectService.getSubject(Integer.valueOf(id));
            teachers = teacherService.getAll();
        } catch (DataFetchingException e) {
            resultView = "error";
        }
        ModelAndView modelAndView = new ModelAndView(resultView);
        modelAndView.addObject("teachers", teachers);
        modelAndView.addObject("subject", subject);

        return modelAndView;
    }

    @RequestMapping(value = "create", method = POST)
    public ModelAndView createSubject(String name, String subjectGroup, String passScore, Integer teacherId) {
       List<Subject> subjects = null;
       String resultView = "showSubjects";
        try {
            subjectService.createSubject(name, subjectGroup, Integer.valueOf(passScore), teacherId);
            subjects = subjectService.getAll();
        } catch (DataFetchingException e) {
            resultView = "error";
        }
        ModelAndView modelAndView = new ModelAndView(resultView);
        modelAndView.addObject("subjects", subjects);

        return modelAndView;
    }

    @RequestMapping(value = "update", method = POST)
    public ModelAndView updateSubject(String id, String name, String subjectGroup, String passScore, String teacherId) {
        List<Subject> subjects = null;
        String resultView = "showSubjects";
        try {
            subjectService.updateSubject(Integer.valueOf(id), name, subjectGroup, Integer.valueOf(passScore),
                    Integer.valueOf(teacherId));
            subjects = subjectService.getAll();
        } catch (DataFetchingException e) {
            resultView = "error";
        }
        ModelAndView modelAndView = new ModelAndView(resultView);
        modelAndView.addObject("subjects", subjects);

        return modelAndView;
    }

    @RequestMapping(value = "delete", method = POST)
    public ModelAndView deleteSubject(String id) {
        List<Subject> subjects = null;
        String resultView = "showSubjects";
        try {
            subjectService.deleteSubject(Integer.valueOf(id));
            subjects = subjectService.getAll();
        } catch (DataFetchingException e) {
            resultView = "error";
        }
        ModelAndView modelAndView = new ModelAndView(resultView);
        modelAndView.addObject("subjects", subjects);

        return modelAndView;
    }
}
