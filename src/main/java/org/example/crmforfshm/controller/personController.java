package org.example.crmforfshm.controller;

import lombok.RequiredArgsConstructor;
import org.example.crmforfshm.dto.Person;
import org.example.crmforfshm.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class personController {
    private final PersonService personService;

    @GetMapping("/info/{id}")
    public Person getPersonInfo(@PathVariable long id) {
        return personService.getPerson(id);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Person> getAllPerson() {
        System.out.println(personService.getPersons());
        return personService.getPersons();
    }

    @GetMapping("/update")
    public Person updatePerson(@RequestParam Person person) {
        return personService.updatePerson(person);
    }

    @PostMapping("/add/single")
    public Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }

    @DeleteMapping("/delete/single")
    public Person deleteBook(@RequestBody Person person){
        return personService.deletePerson(person);
    }
}
