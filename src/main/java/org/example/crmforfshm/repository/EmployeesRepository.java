package org.example.crmforfshm.repository;

import org.example.crmforfshm.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee,String> {
    Employee findBySnils(String snils);
}
