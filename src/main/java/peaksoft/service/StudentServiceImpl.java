package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.StudentDao;
import peaksoft.entity.Student;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

    private final StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> studentList() {
        return studentDao.studentList();
    }

    @Override
    public void saveStudent(Student student) {
       studentDao.saveStudent(student);
    }

    @Override
    public Student findId(Long id) {
        return studentDao.findId(id);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public void delete(Long id) {
        studentDao.delete(id);
    }

    @Override
    public List<Student> search(String firstName) {
        return studentDao.search(firstName);
    }
}
