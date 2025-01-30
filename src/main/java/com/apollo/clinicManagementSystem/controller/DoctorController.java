package com.apollo.clinicManagementSystem.controller;

import com.apollo.clinicManagementSystem.dto.DocotorInputDto;
import com.apollo.clinicManagementSystem.dto.DoctorOutputDto;
import com.apollo.clinicManagementSystem.repository.DoctorRepository;
import com.apollo.clinicManagementSystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping("/search")
    public ResponseEntity<?> searchDoctor(@RequestParam String name){
        return new ResponseEntity<>(doctorRepository.findByName(name), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorOutputDto> getDoctor(@PathVariable Long id){
        return new ResponseEntity<>(doctorService.getDoctor(id), HttpStatusCode.valueOf(200));
    }
    @GetMapping
    public ResponseEntity<List<DoctorOutputDto>> getAllDoctors(){
        return new ResponseEntity<>(doctorService.getAllDoctors(),HttpStatusCode.valueOf(200));
    }
    @PostMapping
    public ResponseEntity<DoctorOutputDto> addDoctor(@RequestBody DocotorInputDto doctorInputDto) {
        return new ResponseEntity<>(doctorService.addDoctor(doctorInputDto), HttpStatusCode.valueOf(201));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<DoctorOutputDto> updateDoctor(@PathVariable Long id, @RequestBody DocotorInputDto doctorInputDto) {
        return new ResponseEntity<>(doctorService.updateDoctor(id, doctorInputDto), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<String> removeDoctor(@PathVariable Long id) {
        return new ResponseEntity<>(doctorService.removeDoctor(id), HttpStatusCode.valueOf(200));
    }


}
