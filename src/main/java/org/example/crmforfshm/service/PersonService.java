package org.example.crmforfshm.service;

import org.example.crmforfshm.dto.Person;

import java.util.List;

public interface PersonService {
    void addPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(String id);
    List<Person> getPersons();
    Person getPerson(String id);
}
