package cn.nsu;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
    //带有泛型--course的List类型属性
    public List<Course>   courses;
    public  TestGeneric(){
        this.courses=new ArrayList<Course>();
    }
    //测试添加
    public  void  testAdd(){
        Course cr1=new Course("1","大学语文");
        courses.add(cr1);
        Course cr2=new Course("2","Java基础");
        courses.add(cr2);
    }
    //测试循环遍历方法
    public   void  testForeach(){
        for(Course  cr:courses){
            System.out.println(cr.id+":"+cr.name);;
        }
    }
    //测试泛型集合可以添加泛型的子类型的对象实例
    public   void testChild(){
        ChileCourse ccr=new ChileCourse();
        ccr.id="3";
        ccr.name="hajds";
        courses.add(ccr);
    }
    public static void main(String[] args) {
        TestGeneric  tg=new TestGeneric();
        tg.testAdd();
        tg.testForeach();
        tg.testChild();
        tg.testForeach();
    }
}
