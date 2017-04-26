package rest;


import entities.Subject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping(value = "/subject")
public class SubjectController {

    @RequestMapping(method = GET)
    public Subject getSubject() {

    }

    @RequestMapping(value = "/all", method = GET)
    public Subject getAllSubjects() {

    }

    @RequestMapping(method = POST)
    public ResponseEntity createSubject() {

    }

    @RequestMapping(method = PUT)
    public ResponseEntity updateSubject() {

    }

    @RequestMapping(method = DELETE)
    public ResponseEntity deleteSubject() {

    }
}
