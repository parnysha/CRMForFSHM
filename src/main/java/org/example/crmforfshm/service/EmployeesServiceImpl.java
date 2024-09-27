package org.example.crmforfshm.service;

import lombok.RequiredArgsConstructor;
import org.example.crmforfshm.dto.Employee;
import org.example.crmforfshm.repository.EmployeesRepository;
import org.example.crmforfshm.service.validation.CheckCorrect;
import org.example.crmforfshm.service.validation.CheckCorrectEmployeeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    private final EmployeesRepository employeesRepository;
    private final CheckCorrect<Employee> employeesService;

    @Autowired
    EmployeesServiceImpl(EmployeesRepository employeesRepository,@Qualifier("checkCorrectEmployeeImpl") CheckCorrect<Employee> employeesService){
        this.employeesRepository=employeesRepository;
        this.employeesService=employeesService;
    }

    @Override
    public Employee addPerson(Employee employee) {
        if (!employeesService.check(employee)){
            throw new IllegalArgumentException("Указаны некорректные поля");
        }
        if(employeesRepository.findBySnils(employee.getSnils())!=null){
            throw new IllegalArgumentException("Пользователь с таким снилсом уже существует");
        }
        return employeesRepository.saveAndFlush(employee);
    }

    @Override
    public Employee updatePerson(String snils,Employee employee) {
        if (!employeesService.check(employee)){
            throw new IllegalArgumentException("Указаны некорректные поля");
        }
        final Employee updateEmployee = employeesRepository.findBySnils(snils);
        if(!employee.getSnils().equals(updateEmployee.getSnils())){
            if(employeesRepository.findBySnils(employee.getSnils())!=null){
                throw new IllegalArgumentException("Пользователь с таким снилсом уже существует");
            }
            employeesRepository.delete(updateEmployee);
        }
        return  employeesRepository.saveAndFlush(employee);
    }

    @Override
    public Employee deletePerson(String snils) {
        final Employee employee = employeesRepository.findBySnils(snils);
        employeesRepository.delete(employee);
        return employee;
    }

    @Override
    public Employee getPerson(String snils){
        return employeesRepository.findBySnils(snils);
    }
}
