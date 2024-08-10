package org.example.crmforfshm.service;

import org.example.crmforfshm.dto.Person;

import java.util.List;

public interface PersonService {
    Person addPerson(Person person);
    Person updatePerson(Person person);
    Person deletePerson(Person person);
    List<Person> getPersons();
    Person getPerson(Long id);
}
