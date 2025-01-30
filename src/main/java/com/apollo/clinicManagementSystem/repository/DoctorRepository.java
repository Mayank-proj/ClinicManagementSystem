package com.apollo.clinicManagementSystem.repository;

import com.apollo.clinicManagementSystem.entity.Doctor;
import com.apollo.clinicManagementSystem.enums.City;
import com.apollo.clinicManagementSystem.enums.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository  extends JpaRepository<Doctor,Long> {

   /* //Dummy Database
    public Map<Long, Doctor> doctors = new HashMap<>();

    //Dummy Doctor id generator
    public Long id = 0L;*/

   //Custom method for findByName
    List<Doctor> findByName(String name);

    @Query("SELECT d FROM Doctor d WHERE d.specialization = :specialization")
    List<Doctor> myCustomJPQLMethod(@Param("specialization") Specialization specialization);

    //Native query -> SQL Query
    @Query(value = "SELECT * FROM doctor d WHERE d.salary BETWEEN :min AND :max", nativeQuery = true)
    List<Doctor> myCustomNativeMethod(@Param("min") Long min, @Param("max") Long max);

    //Suggest Doctors on basis city and specialtiy
    List<Doctor> findByCityAndSpecialization(City city, Specialization specialization);

}
