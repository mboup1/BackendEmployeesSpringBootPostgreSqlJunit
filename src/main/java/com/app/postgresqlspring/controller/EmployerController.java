package com.app.postgresqlspring.controller;

import com.app.postgresqlspring.model.Employer;
import com.app.postgresqlspring.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployerController {
    @Autowired
    private EmployerService employerService;

    @GetMapping("/employees")
    public String getEmployee() {
        return "Hello World";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/employers")
    public List<Employer> getEmployers(){return employerService.getEmployers();}

    @RequestMapping(method = RequestMethod.GET, value = "/employer/{id}")
    public Employer getEmployer(@PathVariable long id){return employerService.getEmployer(id); }

    @RequestMapping(method = RequestMethod.DELETE, value = "/employer/{id}")
    public void deleteEmployer(@PathVariable long id){employerService.deleteEmployer(id);}

    @RequestMapping(method =  RequestMethod.POST, value = "/employer/{id}")
    public void addEmployer(@RequestBody Employer employer){employerService.addEmployer(employer);}

    @RequestMapping(method =  RequestMethod.PUT, value = "/employer/{id}")
    public void updateEmployer(@RequestBody Employer employer, @PathVariable long id){
        employerService.updateEmployer(employer, id);
    }

}
