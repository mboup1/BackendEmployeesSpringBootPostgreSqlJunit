package com.app.postgresqlspring.service;

import com.app.postgresqlspring.model.Employer;
import com.app.postgresqlspring.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    public List<Employer> getEmployers() {
        List<Employer> employers = new ArrayList<>();
        employerRepository.findAll().forEach(employer -> {
            employers.add(employer);
        });
        return employers;
    }

    public Employer getEmployer(long id) { return employerRepository.findById(id).orElse(null); }

    public void deleteEmployer(long id) { employerRepository.deleteById(id);  }

    public Employer addEmployer(Employer employer) {
        employerRepository.save(employer);
        return employer;
    }

    public Employer updateEmployer(Employer employer, long id) {
        employerRepository.save(employer);
        return employer;

    }
}
