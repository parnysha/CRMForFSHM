package org.example.crmforfshm.service.employeeInfo;

import org.example.crmforfshm.dto.Employee;

public interface EmployeesService {
    Employee addPerson(Employee employee);
    Employee updatePerson(String snils,Employee employee);
    Employee deletePerson(String snils);
    Employee getPerson(String snils);
}
