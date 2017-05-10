package rest;

import entities.Subject;
import entities.Teacher;
import exceptions.DataFetchingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import service.SubjectService;
import service.TeacherService;

import javax.validation.Valid;
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

    @RequestMapping(value = "/all", method = GET)
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
    public ModelAndView get(String id) {
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

    @RequestMapping(value = "create", method = GET)
    public ModelAndView viewCreate() {
        List<Teacher> teachers = null;
        Subject subject = new Subject();
        String url = "createSubject";
        try {
            teachers = teacherService.getAll();
        } catch (DataFetchingException e) {
            url = "error";
        }
        ModelAndView modelAndView = new ModelAndView(url);
        modelAndView.addObject("subject", subject);
        modelAndView.addObject("teachers", teachers);
        return modelAndView;
    }

    @RequestMapping(value = "create", method = POST)
    public ModelAndView doCreate(@Valid @ModelAttribute("subject") Subject subject,
                                 BindingResult result, Model model) {
        List<Teacher> teachers = null;
        String url = "redirect:all";
        try {
            teachers = teacherService.getAll();
        } catch (DataFetchingException e) {
            url = "error";
        }
        model.addAttribute("teachers", teachers);
        ModelAndView error = new ModelAndView("createSubject");
        if (result.hasErrors()) {
            return error;
        }
        try {
            subjectService.createSubject(subject);
        } catch (DataFetchingException e) {
            url = "error";
        }
        ModelAndView all = new ModelAndView(url);
        return all;
    }

    @RequestMapping(value = "update", method = GET)
    public ModelAndView viewUpdate(String id) {
        Subject subject = null;
        String url = "editSubject";
        try {
            subject = subjectService.getSubject(Integer.valueOf(id));
        } catch (DataFetchingException e) {
            url = "error";
        }
        ModelAndView modelAndView = new ModelAndView(url);
        modelAndView.addObject("subject", subject);
        return modelAndView;
    }

    @RequestMapping(value = "update", method = POST)
    public ModelAndView doUpdate(@Valid @ModelAttribute("subject") Subject subject,
                                 BindingResult result) {
        ModelAndView error = new ModelAndView("editSubject");
        String url = "redirect:/subject/all";
        if (result.hasErrors()) {
            return error;
        }
        try {
            subjectService.updateSubject(subject);
        } catch (DataFetchingException e) {
            url = "error";
        }
        ModelAndView all = new ModelAndView(url);
        return all;
    }

    @RequestMapping(value = "delete", method = POST)
    public ModelAndView delete(String id) {
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
