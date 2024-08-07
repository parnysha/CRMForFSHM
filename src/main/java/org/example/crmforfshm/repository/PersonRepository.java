package org.example.crmforfshm.repository;

import org.example.crmforfshm.dto.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    Person findByName(String lastName);
}
