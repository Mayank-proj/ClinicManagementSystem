package com.apollo.clinicManagementSystem.entity;

import com.apollo.clinicManagementSystem.enums.Gender;
import com.apollo.clinicManagementSystem.enums.Symptoms;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Symptoms symptoms;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
