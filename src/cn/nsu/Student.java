package cn.nsu;
import java.util.HashSet;
import  java.util.Set;

public class Student implements  Comparable<Student>{
    public  String id;
    public   String name;
    public  Set<Course> course;

    public  Student(String id,String name){
        this.id=id;
        this.name=name;
        this.course=new HashSet<Course>();
    }
    public  int compareTo(Student o){
        return this.id.compareTo(o.id);
    }
}
