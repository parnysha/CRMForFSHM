package org.example.crmforfshm.controller;

import lombok.RequiredArgsConstructor;
import org.example.crmforfshm.dto.Person;
import org.example.crmforfshm.service.CheckStateImpl;
import org.example.crmforfshm.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class personController {
    private static final Logger log = LoggerFactory.getLogger(personController.class);
    private final PersonService personService;
    //private final CheckStateImpl checkState;


    @PostMapping
    public Person addPerson(@RequestBody Person person){
        /*if(!checkState.checkCorrect(person)){
            log.info("Сотрудник имеет некорректные поля");
            return "CreatePage";
        }*/         //СДЕЛАТЬ В ЭКСЕПШЕНЕ
        System.out.println(person);
        log.info("Добавлен сотрудник: {}", person);
        return personService.addPerson(person);
    }

    @PatchMapping("/{id}") //подумать над id
    public Person changePersonInfo(@PathVariable long id,@RequestBody Person person){
        /*if(!checkState.checkCorrect(person)){
            log.info("Сотрудник имеет некорректные поля");
            return "changePage";
        }*/         //сделать в эксепшене
        log.info("Изменен сотрудник: {}", person);
        return personService.updatePerson(person,id);
    }
    //НА ЭТОМ ОСТАНОВИЛСЯ
    @DeleteMapping("/{id}")
    public Boolean deletePerson(@PathVariable long id){
        log.info("Удален сотрудник: {}", personService.getPerson(id));
        personService.deletePerson(id);
        return true;
    }
}
