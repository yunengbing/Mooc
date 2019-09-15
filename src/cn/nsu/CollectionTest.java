package cn.nsu;

import java.util.*;

public class CollectionTest {

    /**
     * 1、通过Collection.sort()方法排序
     * @param
     */
    public  void  testSort1(){
        List<Integer> integerList=new ArrayList<Integer>();
        Random random=new Random();
        Integer k;
        for(int i=0;i<10;i++){
            do {
                k = random.nextInt(100);
            }while (integerList.contains(k));
            integerList.add(k);
            System.out.println("成功添加整数:"+k);
        }
        System.out.println("--------排序前--------");
        for(Integer  integer:integerList){
            System.out.println("元素："+integer);
        }
        Collections.sort(integerList);
        System.out.println("--------排序后--------");
        for(Integer  integer:integerList){
            System.out.println("元素："+integer);
        }
    }
    //对String泛型的List进行排序
    public  void  testSort2(){
        List<String>stringList=new ArrayList<String>();
        stringList.add("微软");
        stringList.add("谷歌");
        stringList.add("联想");
        System.out.println("--------排序前--------");
        for(String string:stringList){
            System.out.println("元素："+string);
        }
        Collections.sort(stringList);
        System.out.println("--------排序后--------");
        for(String string:stringList){
            System.out.println("元素："+string);
        }
    }
    public  void testSort3(){
        List<Student>studentList=new ArrayList<Student>();
        Random random=new Random();
        studentList.add(new Student(random.nextInt(1000)+"","jack"));
        studentList.add(new Student(random.nextInt(1000)+"","john"));
        studentList.add(new Student(random.nextInt(1000)+"","tom"));
        studentList.add(new Student(10000+"","mike"));
        System.out.println("--------排序前--------");
        for(Student student:studentList){
            System.out.println("学生："+student.id+":"+student.name);
        }
        Collections.sort(studentList);
        System.out.println("--------排序后--------");
        for(Student student:studentList){
            System.out.println("学生："+student.id+":"+student.name);
        }
        Collections.sort(studentList,new StudentCompare());
        System.out.println("----------按照姓名排序---------");
        for(Student student:studentList){
            System.out.println("学生："+student.id+":"+student.name);
        }

    }
    public static void main(String[] args) {
        CollectionTest  ct=new CollectionTest();
        ct.testSort3();

    }
}
