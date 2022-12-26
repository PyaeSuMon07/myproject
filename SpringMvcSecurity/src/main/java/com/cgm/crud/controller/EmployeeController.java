package com.cgm.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.crud.dto.EmployeeDto;
import com.cgm.crud.entity.Employee;
import com.cgm.crud.form.CreateEmpForm;
import com.cgm.crud.service.EmployeeService;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeServices;

    /**
     *<h2>showRegister
     *<p>
     *
     *</p>
     *
     * @param model
     * @return
     *@return String
     */
    @RequestMapping(value = { "/addEmployee" }, method = RequestMethod.GET)
    public String showRegister(Model model) {
        model.addAttribute("employee", new Employee());
        return "register";
    }

    /**
     *<h2>insertEmployee
     *<p>
     *
     *</p>
     *
     * @param emp
     * @param result
     * @return
     *@return String
     */
    @RequestMapping(value = { "/insertEmployee" }, method = RequestMethod.POST)
    public String insertEmployee(@Valid @ModelAttribute("employee") CreateEmpForm emp, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        else {
            employeeServices.addEmp(emp);
            return "redirect:/addEmployee";
        }
    }

    // lode employee data
    /**
     *<h2>lodeEmployee
     *<p>
     *
     *</p>
     *
     * @return
     *@return ModelAndView
     */
    @GetMapping("/employeeReport")
    public ModelAndView lodeEmployee() {
        ModelAndView report = new ModelAndView("employeeReport");
        List<EmployeeDto> emp = employeeServices.getAllEmp();
        report.addObject("employee", emp);
        //report.addObject("title", "Employee Report");

        return report;
    }

    // lode edit form
    /**
     *<h2>lodeEditForm
     *<p>
     *
     *</p>
     *
     * @param id
     * @param m
     * @return
     *@return String
     */
    @GetMapping("/editEmployee/{id}")
    public String lodeEditForm(@PathVariable(value = "id") int id, Model m) {
        Employee emp = employeeServices.getById(id);

        System.out.println(emp);
        m.addAttribute("employee", emp);
        m.addAttribute("title", "Edit Employee");

        return "editEmployee";
    }

    /**
     *<h2>updateEmp
     *<p>
     *
     *</p>
     *
     * @param emp
     * @return
     *@return String
     */
    @PostMapping("/editEmployee/updateEmployee")
    public String updateEmp(@ModelAttribute("updateEmployee") Employee emp) {
        employeeServices.updateEmp(emp);

        return "redirect:/employeeReport";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeServices.deleteEmployee(id);

        return "redirect:/employeeReport";
    }
    
 // lode update form
    /**
     *<h2>lodeUpdateForm
     *<p>
     *
     *</p>
     *
     * @param id
     * @param m
     * @return
     *@return String
     */
    @GetMapping("/updateEmployee/{id}")
    public String lodeUpdateForm(@PathVariable(value = "id") int id, Model m) {
        Employee emp = employeeServices.getById(id);

        System.out.println(emp);
        m.addAttribute("employee", emp);
        m.addAttribute("title", "Edit Employee");

        return "editEmployee";
    }
}