
package model.Student;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
//create a table in database 
@Table(name = "students")
public class Student {
    //Inside table creates ID & Column
    @Id
    int studentid;
    @Column
    String studentname;
    //Look in Coures class
    @ManyToMany(fetch = FetchType.EAGER)
    List<Course> courses;

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    
}
