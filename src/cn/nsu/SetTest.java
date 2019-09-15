package cn.nsu;

import java.util.*;

public class SetTest {
    public List<Course>coursesToSelect;

    private   Scanner  console;
    public  Student stu;
    public  SetTest(){
        coursesToSelect =new ArrayList<Course>();
        console=new Scanner(System.in);
    }
    public  void testAdd() {
        //创建一个课程对象，并通过调用add方法，添加到备选课程List中
        Course cr1 = new Course("1", "数据结构");
        coursesToSelect.add(cr1);
        Course temp = (Course) coursesToSelect.get(0);
       // System.out.println("添加了课程：" + temp.id + ":" + temp.name);

        Course  cr2=new Course("2","C语言");
        coursesToSelect.add(0,cr2);
        Course temp2=(Course)coursesToSelect.get(0);
        //System.out.println("添加了课程：" + temp2.id + ":" + temp2.name);

//        coursesToSelect.add(cr1);
//        Course temp0 = (Course) coursesToSelect.get(2);
//        System.out.println("添加了课程：" + temp0.id + ":" + temp0.name);


        Course [] course={new Course("3","离散数学"),new Course("4","汇编语言")};
        coursesToSelect.addAll(Arrays.asList(course));
        Course  temp3=(Course) coursesToSelect.get(3);
        Course  temp4=(Course) coursesToSelect.get(2);
        //System.out.println("添加了课程：" + temp3.id + ":" + temp3.name);
       // System.out.println("添加了课程：" + temp4.id + ":" + temp4.name);

        Course []course2={new Course("5","高等数学"),new Course("6","英语")};
        coursesToSelect.addAll(2,Arrays.asList(course2));
        Course  temp5=(Course) coursesToSelect.get(2);
        Course  temp6=(Course) coursesToSelect.get(3);
        //System.out.println("添加了课程：" + temp5.id + ":" + temp5.name);
        //System.out.println("添加了课程：" + temp6.id + ":" + temp6.name);
    }
    public  void  testforeach(){
        System.out.println("有如下课程供选择(通过Foreach" + "访问)");
        for(Object  obj:coursesToSelect){
            Course cr=(Course)obj;
            System.out.println("课程："+cr.id+":"+cr.name);
        }
    }
    public   void  testForEachForstudent(Student student ){
        for(Course cr:student.course){
            System.out.println("选择了课程:"+cr.id+":"+cr.name);
        }
    }
    /*
    测试List的contains方法
     */
    public  void testListContains(){
        //取得备选课程序列的第0个元素
        Course  course=coursesToSelect.get(0);
        //打印输出是否包含course对象
        System.out.println("取得课程:"+course.name);
        System.out.println("备选课程是否包含课程："+course.name+","+coursesToSelect.contains(course));

        //提示输入课程名称
        System.out.println("请输入课程名称：");
        String name=console.next();
        //新创建一个课程对象，ID和名称一样
        Course course2=new Course(course.id,course.name);
        course2.name=name;
        System.out.println("新创建课程："+course2.name);
        System.out.println("备选课程是否包含课程："+course2.name+","+coursesToSelect.contains(course2));

    }
//创建学生对象
    public   void  creatStudentAndSelect(){
        Student  student=new Student("1","小明");
        System.out.println("欢迎学生:"+student.name+"选课");

        //创建一个Scanner对象
        Scanner console=new Scanner(System.in);

        for(int i=0;i<3;i++){
            System.out.println("请输入课程ID:");
            String courseId=console.next();
            for(Course cr:coursesToSelect){
                if(cr.id.equals(courseId)){
                    student.course.add(cr);
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetTest setTest = (SetTest) o;
        return Objects.equals(coursesToSelect, setTest.coursesToSelect) &&
                Objects.equals(console, setTest.console) &&
                Objects.equals(stu, setTest.stu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coursesToSelect, console, stu);
    }

    //测试Set的contains方法
    public void testSetContains(){
        //提示输入课程名称
        System.out.println("请输入学生已选的课程名称:");
        String name=console.next();
        //新创建一个课程对象，ID和名称一样
        Course course2=new Course();
        course2.name=name;
        System.out.println("新创建课程："+course2.name);
        System.out.println("备选课程是否包含课程："+course2.name+","
                +coursesToSelect.contains(course2));
        //通过indexOf()方法取得某元素的索引位置
        if(coursesToSelect.contains(course2)){
            System.out.println("课程:"+course2.name+"的索引位置为"+coursesToSelect.indexOf(course2));
        }

    }


    public static void main(String[] args) {
        SetTest st = new SetTest();
        st.testAdd();
        st.testSetContains();
        st.testforeach();

//        st.creatStudentAndSelect();
//        st.testSetContains();
//        st.testforeach();
//
//        Student  student=new Student("1","小明");
//        System.out.println("欢迎学生:"+student.name+"选课");
//
//        //创建一个Scanner对象
//        Scanner console=new Scanner(System.in);
//
//        for(int i=0;i<3;i++){
//            System.out.println("请输入课程ID:");
//            String courseId=console.next();
//            for(Course cr:st.coursesToSelect){
//                if(cr.id.equals(courseId)){
//                    student.course.add(cr);
//                }
//            }
//        }
//        //打印输出学生所选课程
//        st.testForEachForstudent(student);
    }
    }
