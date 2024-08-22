package org.example.crmforfshm.service;

import lombok.RequiredArgsConstructor;
import org.example.crmforfshm.dto.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{
    private static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    @Override
    public void addPerson(Person person) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            person.setId(UUID.randomUUID().toString());
            session.persist(person);
            session.flush();
            transaction.commit();
        }
    }

    @Override
    public void updatePerson(Person person) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(person);
        session.flush();
        tx1.commit();
        session.close();
    }

    @Override
    public void deletePerson(String id) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        Person personDel = session.get(Person.class, id);
        session.delete(personDel);
        session.flush();
        tx1.commit();
        session.close();
    }

    @Override
    public List<Person> getPersons() {
        Session session = sessionFactory.openSession();
        List<Person> persons = session.createQuery("from Person").list();
        session.close();
        return persons;
    }

    @Override
    public Person getPerson(String id){
        Session session = sessionFactory.openSession();
        Person person = session.get(Person.class, id);
        session.close();
        return person;
    }
}
