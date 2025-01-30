package com.apollo.clinicManagementSystem.service;

import com.apollo.clinicManagementSystem.dto.DocotorInputDto;
import com.apollo.clinicManagementSystem.dto.DoctorOutputDto;
import com.apollo.clinicManagementSystem.entity.Doctor;
import com.apollo.clinicManagementSystem.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImp implements DoctorService{

    @Autowired
    DoctorRepository doctorRepository;
    @Override
    public DoctorOutputDto getDoctor(Long id) {
        DoctorOutputDto doctorOutputDto=new DoctorOutputDto();

      Doctor doctor=doctorRepository.findById(id).orElse(null);
      doctorOutputDto.setId(doctor.getId());
      doctorOutputDto.setName(doctor.getName());
      doctorOutputDto.setCity(doctor.getCity());
      doctorOutputDto.setEmail(doctor.getEmail());
      doctorOutputDto.setPhone(doctor.getPhone());
      doctorOutputDto.setSpecialization(doctor.getSpecialization());
        doctorOutputDto.setGender(doctor.getGender());
        doctorOutputDto.setSalary(doctor.getSalary());
        return  doctorOutputDto;

    }

    @Override
    public List<DoctorOutputDto> getAllDoctors() {
       List<DoctorOutputDto> doctorOutputDtoList=new ArrayList<>();
       List<Doctor> doctors=doctorRepository.findAll();

       for(Doctor doctor:doctors){
           DoctorOutputDto doctorOutputDto=new DoctorOutputDto();

           doctorOutputDto.setId(doctor.getId());
           doctorOutputDto.setName(doctor.getName());
           doctorOutputDto.setCity(doctor.getCity());
           doctorOutputDto.setEmail(doctor.getEmail());
           doctorOutputDto.setPhone(doctor.getPhone());
           doctorOutputDto.setSpecialization(doctor.getSpecialization());
           doctorOutputDto.setGender(doctor.getGender());
           doctorOutputDto.setSalary(doctor.getSalary());

           doctorOutputDtoList.add(doctorOutputDto);

       }
       return doctorOutputDtoList;
    }

    @Override
    public DoctorOutputDto addDoctor(DocotorInputDto doctorInputDto) {

        //Long id= ++doctorRepository.id;

        Doctor doctor=new Doctor();

       // doctor.setId(id);
        doctor.setName(doctorInputDto.getName());
        doctor.setPhone(doctorInputDto.getPhone());
        doctor.setEmail((doctorInputDto.getEmail()));
        doctor.setCity(doctorInputDto.getCity());
        doctor.setSpecialization(doctorInputDto.getSpecialization());
        doctor.setGender(doctorInputDto.getGender());
        doctor.setSalary(doctorInputDto.getSalary());

         doctor = doctorRepository.save(doctor);

        DoctorOutputDto doctorOutputDto=new DoctorOutputDto();
       // doctor=doctorRepository.doctors.get(id);

        doctorOutputDto.setId(doctor.getId());
        doctorOutputDto.setName(doctor.getName());
        doctorOutputDto.setCity(doctor.getCity());
        doctorOutputDto.setEmail(doctor.getEmail());
        doctorOutputDto.setPhone(doctor.getPhone());
        doctorOutputDto.setSpecialization(doctor.getSpecialization());
        doctorOutputDto.setGender(doctor.getGender());
        doctorOutputDto.setSalary(doctor.getSalary());

       return doctorOutputDto;


    }

    @Override
    public DoctorOutputDto updateDoctor(Long id, DocotorInputDto doctorInputDto) {

        Doctor doctor=new Doctor();

        doctor.setId(id);
        doctor.setName(doctorInputDto.getName());
        doctor.setPhone(doctorInputDto.getPhone());
        doctor.setEmail((doctorInputDto.getEmail()));
        doctor.setCity(doctorInputDto.getCity());
        doctor.setSpecialization(doctorInputDto.getSpecialization());
        doctor.setGender(doctorInputDto.getGender());
        doctor.setSalary(doctorInputDto.getSalary());

        doctor=doctorRepository.save(doctor);

        DoctorOutputDto doctorOutputDto=new DoctorOutputDto();
        //doctor=doctorRepository.doctors.get(id);

        doctorOutputDto.setId(doctor.getId());
        doctorOutputDto.setName(doctor.getName());
        doctorOutputDto.setCity(doctor.getCity());
        doctorOutputDto.setEmail(doctor.getEmail());
        doctorOutputDto.setPhone(doctor.getPhone());
        doctorOutputDto.setSpecialization(doctor.getSpecialization());
        doctorOutputDto.setGender(doctor.getGender());
        doctorOutputDto.setSalary(doctor.getSalary());

        return doctorOutputDto;
            }

    @Override
    public String removeDoctor(Long id) {
       // String name = doctorRepository.doctors.get(id).getName();
        String name=doctorRepository.findById(id).orElse(null).getName();
        //doctorRepository.doctors.remove(id);
        doctorRepository.deleteById(id);
        return "Doctor name: " + name + " and their id: "+ id + " is removed successfully";
    }
}
