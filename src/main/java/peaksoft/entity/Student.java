package peaksoft.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "student_name")
    private String firstName;
    @Column(name = "student_email")
    private String email;
    @Column(name = "student_lastName")
    private String LastName;
    @Column(name = "student_study_format")
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Group> group;

    public Student(List<Group> group) {
        this.group = group;
    }

    public Student() {
    }

    public Student(String firstName, String email, String lastName, StudyFormat studyFormat) {
        this.firstName = firstName;
        this.email = email;
        this.LastName = lastName;
        this.studyFormat = studyFormat;

    }


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public StudyFormat getStudyFormat() {
        return studyFormat;
    }

    public void setStudyFormat(StudyFormat studyFormat) {
        this.studyFormat = studyFormat;
    }

    public List<Group> getGroup() {
        return group;
    }

    public void setGroup(List<Group> group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", LastName='" + LastName + '\'' +
                ", studyFormat=" + studyFormat +
                ", group=" + group +
                '}';
    }
}
