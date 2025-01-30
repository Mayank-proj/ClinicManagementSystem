package com.apollo.clinicManagementSystem.controller;

import com.apollo.clinicManagementSystem.dto.DoctorOutputDto;
import com.apollo.clinicManagementSystem.dto.PatientInputDto;
import com.apollo.clinicManagementSystem.dto.PatientOutputDto;
import com.apollo.clinicManagementSystem.service.PatientSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientSerivce patientSerivce;
    @GetMapping("/{id}")
    public ResponseEntity<PatientOutputDto> getPatient(@PathVariable Long id){
        return new ResponseEntity<>(patientSerivce.getPatient(id), HttpStatusCode.valueOf(200));
    }
    @GetMapping
    public ResponseEntity<List<PatientOutputDto>> getAllPatient(){
        return new ResponseEntity<>(patientSerivce.getAllPatient(),HttpStatusCode.valueOf(200));
    }
    @PostMapping
    public ResponseEntity<PatientOutputDto> addPatient(@RequestBody PatientInputDto patientInputDto) {
        return new ResponseEntity<>(patientSerivce.addPatient(patientInputDto), HttpStatusCode.valueOf(201));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<PatientOutputDto> updatePatient(@PathVariable Long id, @RequestBody PatientInputDto patientInputDto) {
        return new ResponseEntity<>(patientSerivce.updatePatient(id,patientInputDto ), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<String> removePatient(@PathVariable Long id) {
        return new ResponseEntity<>(patientSerivce.removePatient(id), HttpStatusCode.valueOf(200));
    }
    @GetMapping("/suggest/{id}")
    public ResponseEntity<List<DoctorOutputDto>> suggestDoctors(@PathVariable Long id){
        return new ResponseEntity<>(patientSerivce.suggestDoctors(id),HttpStatusCode.valueOf(200));
    }



}


