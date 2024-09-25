package org.example.crmforfshm.controller;

import lombok.RequiredArgsConstructor;
import org.example.crmforfshm.dto.Employee;
import org.example.crmforfshm.service.EmployeesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class EmployeesController {
    private static final Logger log = LoggerFactory.getLogger(EmployeesController.class);
    private final EmployeesService employeesService;


    @PostMapping
    public Employee addPerson(@RequestBody Employee employee){
        System.out.println(employee);
        log.info("Добавлен сотрудник: {}", employee);
        return employeesService.addPerson(employee);
    }

    @PatchMapping("/{snils}") //подумать над id
    public Employee changePersonInfo(@PathVariable String snils, @RequestBody Employee employee){
        log.info("Изменен сотрудник: {}", employee);
        return employeesService.updatePerson(snils,employee);
    }
    @DeleteMapping("/{snils}")
    public Employee deletePerson(@PathVariable String snils){
        log.info("Удален сотрудник: {}", employeesService.getPerson(snils));
        return employeesService.deletePerson(snils);
    }
}
