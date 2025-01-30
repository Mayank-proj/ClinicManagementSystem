package com.apollo.clinicManagementSystem.dto;

import com.apollo.clinicManagementSystem.enums.Gender;
import com.apollo.clinicManagementSystem.enums.Symptoms;
import lombok.Data;

@Data
public class PatientOutputDto {
    private Long id;
    private String name;
    private String city;
    private String email;
    private String phone;
    private Symptoms symptoms;
    private Gender gender;
}

