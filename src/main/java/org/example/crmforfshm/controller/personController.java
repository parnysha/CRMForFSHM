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
    public String getPersonInfo(@PathVariable String id, Model model) {
        model.addAttribute("person", personService.getPerson(id));
        System.out.println(personService.getPerson(id));
        return "infoPage";
    }
    @GetMapping("/change/{id}")
    public String changePersonInfo(@PathVariable String id, Model model) {
        model.addAttribute("person", personService.getPerson(id));
        System.out.println(personService.getPerson(id));
        return "changePage";
    }
    @PostMapping("/change/{id}")
    public String changePersonInfo(@ModelAttribute Person person){
        if(!checkState.checkCorrect(person)){
            log.info("Сотрудник имеет некорректные поля");
            return "changePage";
        }
        log.info("Изменен сотрудник: {}", person);
        personService.updatePerson(person);
        return "redirect:/person/main";
    }

    @GetMapping ("/main")//главная страница
    public String getAllPerson(Model model) {
        model.addAttribute("persons", personService.getPersons());
        return "MainPage";
    }

    @PostMapping("/delete/{id}")
    public String deletePerson(@PathVariable String id){
        log.info("Удален сотрудник: {}", personService.getPerson(id));
        personService.deletePerson(id);
        return "redirect:/person/main";
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
