package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.*;
@Service
public class StudentService {
    @Autowired
    private StudentRepo Strepo;
    /*post method*/
    public void addStudent(Student s)
    {
        Strepo.addStudent(s);
    }

    public void addTeacher(Teacher t)
    {
        Strepo.addTeacher(t);
    }

    /*PUT METHOD*/
    public  void addStudentTeacherPair(String Sname,String Tname)
    {
        Strepo.addStudentTeacherPair(Sname,Tname);
    }

    /* Get Method */

    public Student getStudentByName(String name)
    {
        return Strepo.getStudentByName(name);
    }

    public Teacher getTeacherByName(String name)
    {
        return Strepo.getTeacherByName(name);
    }
    public  List<String> getStudentByTeacherName(String  Tname)
    {
        return Strepo.getStudentByTeacherName(Tname);
    }
    public List<String> getAllStudent()
    {
        return  Strepo.getAllStudent();
    }

    /* DELETE Method */
    public void deleteTeacherByName(String Tname)
    {
        Strepo.deleteTeacherName(Tname);
    }
    public void deleteAllTeacher()
    {
        Strepo.deleteAllTeacher();
    }
}