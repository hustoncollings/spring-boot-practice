package com.huston.Dao;

import com.huston.Entity.Student;
import com.huston.StudentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Qualifier("realData")
public class MySQLStudentDaoImpl implements StudentDao {

    private StudentRepository studentRepository;

    @Query("SELECT * FROM Students")
    @Override
    public Collection<Student> getAllStudents() { return null; }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void removeStudentById(long id) {
        Student student = studentRepository.findById(id).get();
        studentRepository.delete(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.delete(studentRepository.findById(student.getId()).get());
        studentRepository.save(student);
    }

    @Override
    public void insertStudent(Student student) {
        studentRepository.save(student);
    }
}
