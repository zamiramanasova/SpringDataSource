package peaksoft.service;
import peaksoft.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> studentList();

    void saveStudent(Student student);

    Student findId(Long id);

    void update(Student student);

    void delete(Long id);

    List<Student> search(String firstName);

}
