package org.example.crmforfshm.service;

import org.example.crmforfshm.dto.Employee;

import java.util.List;

public interface EmployeesService {
    Employee addPerson(Employee employee);
    Employee updatePerson(String snils,Employee employee);
    Employee deletePerson(String snils);
    Employee getPerson(String snils);
}
