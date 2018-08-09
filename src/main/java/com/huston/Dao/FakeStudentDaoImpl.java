package com.huston.Dao;

import com.huston.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class FakeStudentDaoImpl implements StudentDao {

    @Autowired
    private static Map< Long , Student > students;

    static {
        students = new HashMap< Long , Student >() {

            {
                put( (long)1 , new Student( 1 , "John" , "Computer Science" ));
                put( (long)2 , new Student( 2 , "Alex" , "Finance" ));
                put( (long)3 , new Student( 3 , "Anna" , "Math" ));
            }

        };
    }

    @Override
    public Collection< Student > getAllStudents() {

        return this.students.values();

    }

    @Override
    public Student getStudentById(long id) {

        return this.students.get(id);

    }

    @Override
    public void removeStudentById(long id) {

        this.students.remove( id );

    }

    @Override
    public void updateStudent(Student student) {

        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put( student.getId() , student );

    }

    @Override
    public void insertStudent(Student student) {

        this.students.put( student.getId() , student );

    }
}
