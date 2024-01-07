package com.driver;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class StudentRepo {
    private HashMap<String,Student>Smap=new HashMap<>();
    private HashMap<String,Teacher>Tmap=new HashMap<>();
    private HashMap<String,List<String>>STmap=new HashMap<>();

    //private List<String>StudentList=new ArrayList<>();

    /* POST METHOD */
    public void addStudent(Student s)
    {
        Smap.put(s.getName(),s);
        //StudentList.add(s.getName());
    }

    public void addTeacher(Teacher t)
    {
        Tmap.put(t.getName(),t);
        //return "addTeacher";
    }
    /*PUT METHOD*/
    public void addStudentTeacherPair(String Sname,String Tname)
    {
        if(Smap.containsKey(Sname) && Tmap.containsKey(Tname))
        {
            List<String>pairL=STmap.getOrDefault(Tname,new ArrayList<>());
            pairL.add(Sname);
            STmap.put(Tname,pairL);
        }
    }

    /* Get Method */
    public Student getStudentByName(String name)
    {
        return Smap.get(name);
    }
    public Teacher getTeacherByName(String name)
    {
        return Tmap.get(name);
    }
    public  List<String> getStudentByTeacherName(String Tname)
    {
        return new ArrayList<>(STmap.get(Tname));
    }
    public List<String> getAllStudent()
    {
        List<String>SL=new ArrayList<>();
        for(String s:Smap.keySet())
        {
            SL.add(s);
        }
        return SL;
    }

    /* Delete Method */
    public void deleteTeacherName(String Tname)
    {
        Tmap.remove(Tname);
        if(STmap.containsKey(Tname))
        {
            List<String>SL=STmap.get(Tname);
            STmap.remove(Tname);
            for(String s:SL)
            {
                Smap.remove(s);
            }
        }
    }

    public void deleteAllTeacher()
    {
        HashSet<String> std_hash = new HashSet<>();

        for(String teacher : STmap.keySet()) {

            std_hash.addAll(STmap.get(teacher));
        }
        for(String student : std_hash) {
            Smap.remove(student);
        }
    }

}