package org.example.crmforfshm.controller;

import lombok.RequiredArgsConstructor;
import org.example.crmforfshm.dto.Person;
import org.example.crmforfshm.service.CheckStateImpl;
import org.example.crmforfshm.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/person")
public class personController {
    private static final Logger log = LoggerFactory.getLogger(personController.class);
    private final PersonService personService;
    private final CheckStateImpl checkState;

    @GetMapping("/info/{id}")
    public Person getPersonInfo(@PathVariable long id) {
        return personService.getPerson(id);
    }

    @GetMapping ("/main")//главная страница
    public String getAllPerson(Model model) {
        model.addAttribute("persons", personService.getPersons());
        return "MainPage";
    }

    @GetMapping("/update")
    public Person updatePerson(@RequestParam Person person) {
        return personService.updatePerson(person);
    }

    @DeleteMapping("/delete/single")
    public Person deleteBook(@RequestBody Person person){
        return personService.deletePerson(person);
    }

    @GetMapping("/create")
    public String createPerson(Model model) {
        model.addAttribute("person",new Person());
        return "CreatePage";
    }

    @PostMapping("/create")
    public String addPerson(@ModelAttribute Person person){
        if(!checkState.checkCorrect(person)){
            log.info("Сотрудник имеет некорректные поля");
            return "CreatePage";
        }
        log.info("Добавлен сотрудник: {}", person);
        personService.addPerson(person);
        return "redirect:/person/main";
    }
}
