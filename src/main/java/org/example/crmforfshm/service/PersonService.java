package org.example.crmforfshm.service;

import org.example.crmforfshm.dto.Person;

import java.util.List;

public interface PersonService {
    Person addPerson(Person person);
    Person updatePerson(Person person,long id);
    void deletePerson(long id);
    List<Person> getPersons();
    Person getPerson(long id);
}
