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
    public Person updatePerson(Person person,long id) {
        final Person updatePerson = personRepository.findById(id);
        //fix if
        if(person.getName()!=updatePerson.getName()) {
            updatePerson.setName(person.getName());
        }
        if (person.getGroupPerson()!=updatePerson.getGroupPerson()) {
            updatePerson.setGroupPerson(person.getGroupPerson());
        }
        if(person.getSex()!=updatePerson.getSex()){
            updatePerson.setSex(person.getSex());
        }
        if(person.getDateBirth()!=updatePerson.getDateBirth()) {
            updatePerson.setDateBirth(person.getDateBirth());
        }
        if(person.getSnils()!=updatePerson.getSnils()) {
            updatePerson.setSnils(person.getSnils());
        }
        if(person.getSubdivision()!=updatePerson.getSubdivision()) {
            updatePerson.setSubdivision(person.getSubdivision());
        }
        if(person.getPost()!=updatePerson.getPost()) {
            updatePerson.setPost(person.getPost());
        }
        if (person.getDateFormatAdd()!=updatePerson.getDateFormatAdd()) {
            updatePerson.setDateFormatAdd(person.getDateFormatAdd());
        }
        if(person.getDateFormatDis()!=updatePerson.getDateFormatDis()) {
            updatePerson.setDateFormatDis(person.getDateFormatDis());
        }
        return  personRepository.saveAndFlush(updatePerson);
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
