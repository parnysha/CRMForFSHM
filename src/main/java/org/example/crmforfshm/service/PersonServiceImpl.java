package org.example.crmforfshm.service;

import lombok.RequiredArgsConstructor;
import org.example.crmforfshm.dto.Person;
import org.example.crmforfshm.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
    public void deletePerson(long id) {
        final Person person = personRepository.findById(id);
        personRepository.delete(person);
    }

    @Override
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPerson(long id){
        return personRepository.findById(id);
    }
}
