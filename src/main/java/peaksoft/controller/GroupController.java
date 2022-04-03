package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Group;
import peaksoft.service.GroupService;

import java.util.List;

@Controller
@RequestMapping("group")
public class GroupController {

    public GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping()
    public String index(Model model) {
        List<Group> groupList = groupService.groupList();
        model.addAttribute("groupList", groupList);
        return "group/index";
    }

    @GetMapping("/new")
    public String newCourse(Model model) {
        Group group = new Group();
        model.addAttribute("group", group);
        return "group/new_group";
    }

    @PostMapping()
    public String save(@ModelAttribute("group") Group group) {
        groupService.saveGroup(group);
        return "redirect:group";
    }

    @GetMapping("/gro/{id}")
    public String getById(@PathVariable("id") long id, Model model) {
        model.addAttribute("group", groupService.findId(id));
        return "group/show";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model){
        Group group = groupService.findId(id);
        model.addAttribute("group", group);
        return "group/edit";
    }

    @PostMapping("/update/{id}")
    public String update(Group group){
        groupService.update(group);
        return "redirect:/group";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        groupService.delete(id);
        return "redirect:/group";
    }
}
