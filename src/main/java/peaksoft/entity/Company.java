package peaksoft.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "company_located")
    private String locatedCompany;

//    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
//    private List<Course> courseList;
//
    @OneToMany(cascade ={PERSIST,MERGE,REFRESH,DETACH,REMOVE} ,
            fetch = FetchType.LAZY,mappedBy = "company")
    private List<Course> courseList=new ArrayList<>();

    public Company() {
    }

    public Company(String companyName, String locatedCompany, List<Course> courseList) {
        this.companyName = companyName;
        this.locatedCompany = locatedCompany;
        this.courseList = courseList;
    }

    //    public Company(String companyName, String locatedCompany) {
//        this.companyName = companyName;
//        this.locatedCompany = locatedCompany;
//    }

//    public Company(List<Course> courseList) {
//        this.courseList = courseList;
//    }
//
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocatedCompany() {
        return locatedCompany;
    }

    public void setLocatedCompany(String locatedCompany) {
        this.locatedCompany = locatedCompany;
    }
    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", locatedCompany='" + locatedCompany + '\'' +
                '}';
    }
}
