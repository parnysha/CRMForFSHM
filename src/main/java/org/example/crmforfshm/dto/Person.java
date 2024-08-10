package org.example.crmforfshm.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String subdivision;
    @Column(nullable = false)
    private String post;
    @Column(nullable = false)
    private String dateFormatAdd;
    @Column(nullable = false)
    private String dateFormatDis;
}
