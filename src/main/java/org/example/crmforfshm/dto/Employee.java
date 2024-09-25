package org.example.crmforfshm.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String groupPerson;
    @Column(nullable = false)
    private String sex;
    @Column(nullable = false)
    private String dateBirth;
    @Id
    private String snils;
    @Column(nullable = false)
    private String subdivision;
    @Column(nullable = false)
    private String post;
    @Column(nullable = false)
    private String dateFormatAdd;
    @Column
    private String dateFormatDis;
}
