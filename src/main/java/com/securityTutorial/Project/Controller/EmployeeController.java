package com.securityTutorial.Project.Controller;

import com.securityTutorial.Project.entity.Employee;
import com.securityTutorial.Project.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/employees";
    }

    @GetMapping("/employees")
    public String list(@RequestParam(value = "q", required = false) String q, Model model) {
        if (q != null && !q.isBlank()) {
            model.addAttribute("employees", service.searchByName(q));
            model.addAttribute("q", q);
        } else {
            model.addAttribute("employees", service.getAll());
        }
        return "employees";
    }

    @GetMapping("/employees/new")
    public String addForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @PostMapping("/employees")
    public String save(@Valid @ModelAttribute("employee") Employee employee,
                       BindingResult result) {
        if (result.hasErrors()) return "employee-form";
        service.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", service.getById(id));
        return "employee-form";
    }

    @GetMapping("/employees/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/employees";
    }
}

