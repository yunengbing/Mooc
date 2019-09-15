package cn.nsu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import  java.util.List;

/*
备选课程类
 */
public class ListTest {
    public   List  coursesToSelect;
    public  ListTest(){
        this.coursesToSelect=new ArrayList();
    }
    /*
    用于添加备选课程
     */
    public  void testAdd() {
        //创建一个课程对象，并通过调用add方法，添加到备选课程List中
        Course cr1 = new Course("1", "数据结构");
        coursesToSelect.add(cr1);
        Course temp = (Course) coursesToSelect.get(0);
        System.out.println("添加了课程：" + temp.id + ":" + temp.name);

        Course  cr2=new Course("2","C语言");
        coursesToSelect.add(0,cr2);
        Course temp2=(Course)coursesToSelect.get(0);
        System.out.println("添加了课程：" + temp2.id + ":" + temp2.name);

        coursesToSelect.add(cr1);
        Course temp0 = (Course) coursesToSelect.get(2);
        System.out.println("添加了课程：" + temp0.id + ":" + temp0.name);


        Course [] course={new Course("3","离散数学"),new Course("4","汇编语言")};
        coursesToSelect.addAll(Arrays.asList(course));
        Course  temp3=(Course) coursesToSelect.get(3);
        Course  temp4=(Course) coursesToSelect.get(4);
        System.out.println("添加了课程：" + temp3.id + ":" + temp3.name);
        System.out.println("添加了课程：" + temp4.id + ":" + temp4.name);

        Course []course2={new Course("5","高等数学"),new Course("6","英语")};
        coursesToSelect.addAll(2,Arrays.asList(course2));
        Course  temp5=(Course) coursesToSelect.get(2);
        Course  temp6=(Course) coursesToSelect.get(3);
        System.out.println("添加了课程：" + temp5.id + ":" + temp5.name);
        System.out.println("添加了课程：" + temp6.id + ":" + temp6.name);
    }
    //取得List中的元素
    public  void  testGet(){
        int size=coursesToSelect.size();
        System.out.println("有如下课程供选择");
        for(int i=0;i<size;i++){
            Course cr=(Course) coursesToSelect.get(i);

            System.out.println("课程："+cr.id+":"+cr.name);
        }
    }

    //通过迭代器来遍历List
    public  void  testIterator(){
        Iterator it=coursesToSelect.iterator();
        System.out.println("有如下课程供选择(通过迭代器访问)");
        while(it.hasNext()){
            Course  cr=(Course) it.next();
            System.out.println("课程："+cr.id+":"+cr.name);
        }
    }
    //通过foreach
    public  void  testforeach(){
        System.out.println("有如下课程供选择(通过Foreach" + "访问)");
        for(Object  obj:coursesToSelect){
            Course cr=(Course)obj;
            System.out.println("课程："+cr.id+":"+cr.name);
        }
    }

    //修改List中的元素
    public   void  testModify(){
        coursesToSelect.set(4,new Course("7","大物"));
    }
    //删除List中的元素
    public   void  testDelete(){
        Course cr=(Course)coursesToSelect.get(4);
        System.out.println("我是课程:"+cr.id+":"+cr.name);
        coursesToSelect.remove(cr);
        System.out.println("成功删除课程！");
        testforeach();
    }
    //往List中添加一些奇怪的东西
    public   void  testtype(){
        System.out.println("能否加入一些奇怪的东西？");
        coursesToSelect.add("我不是课程");
    }

    public static void main(String[] args) {
        ListTest  lt=new ListTest();
        lt.testAdd();
        lt.testGet();
//        lt.testIterator();
//        lt.testforeach();
//        lt.testModify();
//        lt.testforeach();
//        lt.testDelete();
        lt.testtype();
        lt.testforeach();

    }
}
