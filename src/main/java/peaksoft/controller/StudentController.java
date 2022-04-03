package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Student;
import peaksoft.service.StudentService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("student")
public class StudentController {

    public StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public String index(Model model) {
        List<Student> studentList = studentService.studentList();
        model.addAttribute("studentList", studentList);
        return "student/index";
    }

    @GetMapping("/new")
    public String newStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student/new_student";
    }

    @PostMapping()
    public String save(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:student";
    }

    @GetMapping("/study/{id}")
    public String getById(@PathVariable("id") long id, Model model) {
        model.addAttribute("student", studentService.findId(id));
        return "student/show";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model){
        Student student = studentService.findId(id);
        model.addAttribute("student", student);
        return "student/edit";
    }

    @PostMapping("/update/{id}")
    public String update(Student student){
        studentService.update(student);
        return "redirect:/student";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        studentService.delete(id);
        return "redirect:/student";
    }

    @GetMapping("/search")
    public String search(@RequestParam Optional<String> firstName, Model model){
        model.addAttribute("firstName", studentService.search(firstName.orElse("_")));
        return "student/search";
        //List<Student> result = studentService.search(keyword);
        //model.addAttribute("result", result);
        //return "student/search";
    }
}
