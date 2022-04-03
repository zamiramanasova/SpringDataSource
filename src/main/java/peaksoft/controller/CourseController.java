package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Course;
import peaksoft.service.CourseService;

import java.util.List;

@Controller
@RequestMapping("course")
public class CourseController {

    public CourseController() {
    }

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping()
    public String list(Model model) {
        List<Course> courseList = courseService.courseList();
        model.addAttribute("courseList", courseList);
        return "course/list";
    }

    @GetMapping("/new")
    public String newCourse(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "course/new_course";
    }

//    @PostMapping()
//    public String month(@RequestParam Month month, Model model) {
//       // List<Month> enums = Arrays.asList(Month.values());
//        model.addAttribute("months",month);
//        //System.out.println(enums.size());
//        return "course/new_course";
//    }

    @PostMapping()
    public String save(@ModelAttribute("course") Course course) {
        courseService.saveCourse(course);
        return "redirect:course";
    }

    @GetMapping("/cour/{id}")
    public String getById(@PathVariable("id") long id, Model model) {
        model.addAttribute("course", courseService.findId(id));
        return "course/show";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model){
        Course course = courseService.findId(id);
        model.addAttribute("course", course);
        return "course/edit";
    }

    @PostMapping("/update/{id}")
    public String update(Course course){
        courseService.update(course);
        return "redirect:/course";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        courseService.delete(id);
        return "redirect:/course";
    }
}
