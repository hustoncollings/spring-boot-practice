package com.huston.Dao;

import com.huston.Entity.Student;

import java.util.Collection;

public interface StudentDao {
    Collection< Student > getAllStudents();

    Student getStudentById(long id);

    void removeStudentById(long id);

    void updateStudent(Student student);

    void insertStudent(Student student);
}
