package test.code;

import model.Student.Course;
import model.Student.Student;
import hibernate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Test {
    
    public static void addCourses(){
        //First course ID & Name 
        Course c1=new Course();
        c1.setCourseid(1);
        c1.setCoursename("JAVA");
        
        //Seconed course ID & Name 
        Course c2=new Course();
        c2.setCourseid(2);
        c2.setCoursename("C++");
        
        //pass the data into database
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tr = session.beginTransaction();
        
        //save data 
        session.save(c1);
        session.save(c2);
        tr.commit();
        //Show message if the transaction of data is compleate 
        System.out.println("Courses Data Succesfuly saved");
        
    }
    
    public static void addStudent(){
    
        List<Course> courses = new ArrayList<>();
        Course c1 = new Course();
        c1.setCourseid(1);
        c1.setCoursename("JAVA");
        
        Course c2 = new Course();
        c2.setCourseid(2);
        c2.setCoursename("C++");
        
        //link the couses with student Name & ID
        courses.add(c1);
        courses.add(c2);
        
        //Now add student Data 
        Student s1=new Student();
        s1.setStudentid(124);
        s1.setStudentname("Raj");
        
        //Conect the student data to course
        s1.setCourses(courses);
        
        //session
        SessionFactory factory=HibernateUtil.getSessionFactory();
        Session session =factory.openSession();
        Transaction tr = session.beginTransaction();
        
        //save 
        session.save(s1);
        tr.commit();
        System.out.println("Data saved succesful");
    }
    public static void displayStudent(){
    
        SessionFactory factory=HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Student> students  = session.createQuery("from model.Student.Student").list();
        
        //see if the data of students & courses are connected
        for(Student student : students){
            
            System.out.println("========Student Data=========");
            System.out.println("Student ID: "+student.getStudentid());
            System.out.println("Student name: "+student.getStudentname());
            
            List<Course> courses = student.getCourses();
                    for(Course course : courses){
                        
                        System.out.println("=========Course Data==========");
                        System.out.println("Course ID: "+course.getCourseid());
                        System.out.println("Course Name: "+course.getCoursename());
                        
                    }
        }
    
    }
    public static void displayCourse(){
    
        SessionFactory factory=HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Course> courses = session.createQuery("model.Student.Course").list();
        
        for(Course course : courses){
            
            System.out.println("==========Course Data===========");
            System.out.println("Course ID: "+course.getCourseid());
            System.out.println("Course Name: "+course.getCoursename());
            
            List<Student> students=course.getStudents();
            
            System.out.println("==========Student Data===========");
            for(Student student : students) {
                
            
            System.out.println("Student ID: "+student.getStudentid());
            System.out.println("Student Name: "+student.getStudentname());
                
            }
        
        }
    
    }
   
    public static void main(String[] args){
        
        //addCourses();
        //addStudent();
        //displayStudent();
        displayCourse();
    
    }
    
}
