package peaksoft.entity;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "course_duration")
    private int duration;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "group_course", joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Group> group;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "company_id")
//    private Company company;

    @OneToOne(mappedBy = "course" , cascade = CascadeType.ALL)
    private Teacher teacher;

    @ManyToOne(cascade = {PERSIST,MERGE},fetch = FetchType.LAZY)
    @JoinColumn(name="company_id")
    private Company company;

    public Course() {
    }

    public Course(String courseName, int duration, List<Group> group, Company company, Teacher teacher) {
        this.courseName = courseName;
        this.duration = duration;
        this.group = group;
        this.company = company;
        this.teacher = teacher;
    }

    //    public Course(String courseName,  Company company, int duration) {
//        this.courseName = courseName;
//        this.company = company;
//        this.duration = duration;
//    }
//
//    public Course(List<Group> group) {
//        this.group = group;
//    }
//
//    public Course(Teacher teacher) {
//        this.teacher = teacher;
//    }
//
//    public Course(Company company) {
//        this.company = company;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Group> getGroup() {
        return group;
    }

    public void setGroup(List<Group> group) {
        this.group = group;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", company=" + company +
                ", teacher=" + teacher +
                '}';
    }
}
