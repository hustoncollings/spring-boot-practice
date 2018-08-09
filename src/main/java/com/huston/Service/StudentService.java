package com.huston.Service;

import com.huston.Entity.Student;
import com.huston.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Collection< Student > getAllStudents() {

        return studentRepository.getAllStudents();

    }

    public Student getStudentById( long studentid ) {

        return this.studentRepository.getStudentById( studentid );

    }

    public Collection< Student > getStudentsByName( String studentName ) {

        return this.studentRepository.getStudentsByName( studentName );

    }

    public Collection< Student > getStudentsByCourse( String course ) {

        return this.studentRepository.getStudentsByCourse( course );

    }

    public void removeStudentById(long id) {

        this.studentRepository.removeStudentById( id );

    }

    public void updateStudent( Student student ) {

        this.studentRepository.updateStudent( student.getName() , student.getCourse() , student.getId() );

    }

    public void insertStudent(Student student) {

        this.studentRepository.insertStudent( student.getName() , student.getCourse() , student.getId() );

    }
}
