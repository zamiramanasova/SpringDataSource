package peaksoft.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "croup")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "group_date_start")
    // @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfStart;
    @Column(name = "group_date_finish")
   // @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfFinish;

    //bi directional
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "group_course",joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> course;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    public Group() {
    }

    public Group(String groupName, LocalDate dateOfStart, LocalDate dateOfFinish, Student student) {
        this.groupName = groupName;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
        this.student = student;
    }

    public Group(List<Course> course) {
        this.course = course;
    }

    public Group(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public LocalDate getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(LocalDate dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public LocalDate getDateOfFinish() {
        return dateOfFinish;
    }

    public void setDateOfFinish(LocalDate dateOfFinish) {
        this.dateOfFinish = dateOfFinish;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", dateOfStart=" + dateOfStart +
                ", dateOfFinish=" + dateOfFinish +
                '}';
    }
}

