package com.huston;

import com.huston.Entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Collection;

public interface StudentRepository extends CrudRepository<Student , Long> {

    @Query( value = "SELECT * FROM Students" , nativeQuery = true )
    public Collection<Student> getAllStudents();

    @Query( value = "SELECT * FROM Students where StudentID = :studentid" , nativeQuery = true )
    public Student getStudentById( @Param("studentid") long studentid );

    @Query( value = "SELECT * FROM Students where StudentName = :studentName" , nativeQuery = true )
    public Collection< Student > getStudentsByName( @Param("studentName") String studentName );

    @Query( value = "SELECT * FROM Students where Course = :course" , nativeQuery = true )
    public Collection< Student > getStudentsByCourse( @Param("course") String course );

    @Query( value = "DELETE FROM Students WHERE StudentID = :studentid" , nativeQuery = true )
    @Modifying
    @Transactional
    public void removeStudentById( @Param("studentid") long id );

    @Query( value = "UPDATE Students SET StudentName = :name , Course = :course WHERE StudentID = :id" , nativeQuery = true )
    @Modifying
    @Transactional
    public void updateStudent( @Param("name") String name , @Param("course") String course , @Param("id") long id );

    @Query( value = "INSERT INTO Students VALUES ( :id , :name , :course )" , nativeQuery = true )
    @Modifying
    @Transactional
    public void insertStudent( @Param("name") String name , @Param("course") String course , @Param("id") long id );

}
