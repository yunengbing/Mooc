package cn.nsu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapTest {
    //用来承装学生类型对象
    public Map<String,Student>students;
    //在构造方法中初始化
    public  MapTest(){
        this.students=new HashMap<String,Student>();
    }

    //测试添加：学生ID，判断是否被占用
    //若未被占用，则输入姓名，创建学生对象，并且添加到students中
    public  void  testPut(){
        //创建一个Scanner对象
        Scanner console=new Scanner(System.in);
        int i=0;
        while(i<3)
        {
            System.out.println("请输入学生ID:");
            String ID=console.next();
            //判断ID是否被占用
            Student st=students.get(ID);
            if(st==null){
                //提示输入学生姓名
                System.out.println("请输入学生姓名:");
                String name=console.next();
                //创建学生对象
                Student newStudent=new Student(ID,name);
                //通过调用student的put方法，添加ID-学生映射
                students.put(ID,newStudent);
                System.out.println("成功添加学生"+students.get(ID).name);
                i++;
            }
            else{
                System.out.println("该学生ID已被占用");
                continue;
            }
        }
    }
    //测试Map的keySet方法
    public  void  testKeySet(){
        //通过KeySet方法，返回Map中所有“键”的集合
        Set<String>keySet=students.keySet();
        //取得students的容量
        System.out.println("总共有："+students.size()+"个学生！");
        //遍历keySet对象，取得每一个键，在调研get（）方法
        for(String stuId:keySet){
            Student st=students.get(stuId);
            if(st!=null){
                System.out.println("学生:"+st.name);
            }
        }
    }
    /*
    测试删除Map中的映射
     */
    public  void testRemove(){

        //获取学生id
        Scanner console=new Scanner(System.in);

        while(true){
            //提示待删除学生的ID
            System.out.println("请输入要删除学生的id：");
            String ID=console.next();
            //判断该Id是否有对应学生
            Student st=students.get(ID);
            if(st==null){
                //提示输入id不存在
                System.out.println("该id不存在！");
                continue;
            }
            students.remove(ID);
            System.out.println("成功删除学生："+st.name);
            break;
        }
    }
    /*
    通过entrySet方法遍历Map
     */
    public   void  testEntrySet(){
        //通过entrySet方法，返回Map中所有键值对
        Set<Map.Entry<String,Student>>entrySet=students.entrySet();
        for(Map.Entry<String,Student>entry:entrySet){
            System.out.println("取得键："+entry.getKey());
            System.out.println("对应的值为："+entry.getValue().name);
        }
    }
    /*
    利用put方法修改Map中的已有映射
     */
    public  void testModify(){
        System.out.println("请输入要修改的学生id：");
        //创建一个Scanner对象
        Scanner  console=new Scanner(System.in);
        while(true){
            //取得学生id
            String stuID=console.next();
            //从students中查找是否有相应id的学生对象
            Student st=students.get(stuID);
            if(st ==null){
                System.out.println("该ID不存在，请重新输入！");
                continue;
            }
            //提示当前对应的学生对象姓名
            System.out.println("当前该学生ID，对应学生为:"+st.name);
            //提示输入新的学生姓名，
            System.out.println("请输入新的学生姓名：");
            String name=console.next();
            Student newStudent=new Student(stuID,name);
            students.put(stuID,newStudent);
            System.out.println("修改成功！");
            break;
        }
    }

    public static void main(String[] args) {
        MapTest mt=new MapTest();
        mt.testPut();
        mt.testKeySet();
//        mt.testRemove();
//        mt.testEntrySet();
        mt.testModify();
        mt.testEntrySet();
    }
}
