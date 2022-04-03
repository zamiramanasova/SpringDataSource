package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.dao.TeacherDao;
import peaksoft.entity.Teacher;
import peaksoft.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("teacher")
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping()
    public String index(Model model) {
        List<Teacher> teacherList = teacherService.teacherList();
        model.addAttribute("teacherList", teacherList);
        return "teacher/index";
    }

    @GetMapping("/new")
    public String newTeacher(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "teacher/new_teacher";
    }

    @PostMapping()
    public String save(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:teacher";
    }

    @GetMapping("/teach/{id}")
    public String getById(@PathVariable("id") long id, Model model) {
        model.addAttribute("teacher", teacherService.findId(id));
        return "teacher/show";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model){
        Teacher teacher = teacherService.findId(id);
        model.addAttribute("teacher", teacher);
        return "teacher/edit";
    }

    @PostMapping("/update/{id}")
    public String update(Teacher teacher){
        teacherService.update(teacher);
        return "redirect:/teacher";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        teacherService.delete(id);
        return "redirect:/teacher";
    }
}

