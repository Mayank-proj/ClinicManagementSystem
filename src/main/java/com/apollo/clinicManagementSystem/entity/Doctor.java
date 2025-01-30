package com.apollo.clinicManagementSystem.entity;

import com.apollo.clinicManagementSystem.enums.City;
import com.apollo.clinicManagementSystem.enums.Gender;
import com.apollo.clinicManagementSystem.enums.Specialization;
import jakarta.persistence.*;
import lombok.Data;

//If you want to change your table name according to need you use @Table annotation
//@Table(name="doctors")

@Data
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private City city;

    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Long salary;


}
