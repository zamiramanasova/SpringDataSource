package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Company;
import peaksoft.service.CompanyService;

import java.util.List;

@Controller
@RequestMapping("company")
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping()
    public String index(Model model) {
        List<Company> companyList = companyService.companyList();
        model.addAttribute("companyList", companyList);
        return "company/index";
    }

    @GetMapping("/new")
    public String newCompany(Model model) {
        model.addAttribute("company", new Company());
        return "company/new_company";
    }

    @PostMapping()
    public String save(@ModelAttribute("company") Company company){
       companyService.saveCompany(company);
        return "redirect:company";
    }

    @GetMapping("/comp/{id}")
    public String getById(@PathVariable("id") long id, Model model) {
        model.addAttribute("company", companyService.findId(id));
        return "company/show";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model){
        Company company = companyService.findId(id);
        model.addAttribute("company", company);
        return "company/edit";
    }

    @PostMapping("/update/{id}")
    public String update(Company company){
        companyService.update(company);
        return "redirect:/company";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        companyService.delete(id);
        return "redirect:/company";
    }

}
