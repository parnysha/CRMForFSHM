package org.example.crmforfshm.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    private String id;

    @Column(nullable = false, name = "FIO")
    private String name;
    @Column(nullable = false, name = "groupPerson")
    private String groupPerson;
    @Column(nullable = false, name = "sex")
    private String sex;
    @Column(nullable = false, name = "dateBirth")
    private String dateBirth;
    @Column(nullable = false, name = "snils")
    private String snils;
    @Column(nullable = false, name = "subdivision")
    private String subdivision;
    @Column(nullable = false, name = "post")
    private String post;
    @Column(nullable = false, name = "dateFormatAdd")
    private String dateFormatAdd;
    @Column(name = "dateFormatDis")
    private String dateFormatDis;
}
