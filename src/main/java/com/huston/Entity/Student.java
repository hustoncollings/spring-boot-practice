package com.huston.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long studentid;

    private String studentname;

    private String course;

    public Student(long id, String name, String course) {
        this.studentid = id;
        this.studentname = name;
        this.course = course;
    }

    public Student() {}

    public long getId() {
        return studentid;
    }

    public String getName() {
        return studentname;
    }

    public String getCourse() {
        return course;
    }

    public void setId(long id) {
        this.studentid = id;
    }

    public void setName(String name) {
        this.studentname = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

}
