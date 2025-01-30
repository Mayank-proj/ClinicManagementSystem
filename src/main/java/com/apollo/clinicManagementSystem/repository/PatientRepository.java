package com.apollo.clinicManagementSystem.repository;

import com.apollo.clinicManagementSystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient , Long> {
   /* //Dummy Database
    public Map<Long, Patient> patients = new HashMap<>();

    //Dummy Doctor id generator
    public Long id= 0L;*/
}
