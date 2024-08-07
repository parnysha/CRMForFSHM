package org.example.crmforfshm.service;

import lombok.RequiredArgsConstructor;
import org.example.crmforfshm.dto.Person;
import org.example.crmforfshm.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{
    private final PersonRepository personRepository;

    @Override
    public Person addPerson(Person person) {
        final Person addedBook = personRepository.save(person);
        personRepository.flush();
        return addedBook;
    }

    @Override
    public Person updatePerson(Person person) {
        final Person updateBook = personRepository.save(person);
        personRepository.flush();
        return updateBook;
    }

    @Override
    public Person deletePerson(Person person) {
        final Person personOpt = personRepository.findByName(person.getName());
        personRepository.delete(personOpt);
        return personOpt;
    }

    @Override
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPerson(Long id){
        return personRepository.findByName(String.valueOf(id));
    }
}
