package com.apollo.clinicManagementSystem.dto;

import com.apollo.clinicManagementSystem.enums.City;
import com.apollo.clinicManagementSystem.enums.Gender;
import com.apollo.clinicManagementSystem.enums.Specialization;
import lombok.Data;

@Data
public class DoctorOutputDto {
    private Long id;
    private String name;
    private City city;
    private String email;
    private String phone;
    private Specialization specialization;
    private Gender gender;
    private Long salary;

}
