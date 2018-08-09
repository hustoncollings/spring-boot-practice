package com.huston.Controller;

import com.huston.Entity.Student;
import com.huston.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping( method = RequestMethod.GET )
    public @ResponseBody Collection<Student> getAllStudents() {

        return studentService.getAllStudents();

    }

    @RequestMapping( value = "/{studentid}" , method = RequestMethod.GET)
    public @ResponseBody Student getStudentById( @PathVariable("studentid") long studentid ) {

        return studentService.getStudentById( studentid );

    }

    @RequestMapping( value = "/{studentid}" , method = RequestMethod.DELETE)
    public void deleteStudentById( @PathVariable("studentid") long studentid ) {

        studentService.removeStudentById(studentid);

    }

    @RequestMapping( method = RequestMethod.PUT , consumes = MediaType.APPLICATION_JSON_VALUE )
    public void updateStudent( @RequestBody Student student ) {

        this.studentService.updateStudent( student );

    }

    @RequestMapping( method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE )
    public void insertStudent( @RequestBody Student student ) {

        studentService.insertStudent( student );

    }

    @RequestMapping( value = "/name/{studentName}" , method = RequestMethod.GET )
    public @ResponseBody Collection< Student > getStudentsByName( @PathVariable("studentName") String studentName ) {

        return studentService.getStudentsByName( studentName );

    }

    @RequestMapping( value = "/course/{course}" , method = RequestMethod.GET )
    public @ResponseBody Collection< Student > getStudentsByCourse( @PathVariable("course") String course ) {

        return studentService.getStudentsByCourse( course );

    }

}
