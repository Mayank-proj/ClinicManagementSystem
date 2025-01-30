
package com.apollo.clinicManagementSystem.service;

import com.apollo.clinicManagementSystem.dto.DoctorOutputDto;
import com.apollo.clinicManagementSystem.dto.PatientInputDto;
import com.apollo.clinicManagementSystem.dto.PatientOutputDto;
import com.apollo.clinicManagementSystem.entity.Doctor;
import com.apollo.clinicManagementSystem.entity.Patient;
import com.apollo.clinicManagementSystem.enums.City;
import com.apollo.clinicManagementSystem.enums.Specialization;
import com.apollo.clinicManagementSystem.enums.Symptoms;
import com.apollo.clinicManagementSystem.repository.DoctorRepository;
import com.apollo.clinicManagementSystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImp implements PatientSerivce {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public PatientOutputDto getPatient(Long id) {
        PatientOutputDto patientOutputDto = new PatientOutputDto();

        Patient patient = patientRepository.findById(id).orElse(null);

        patientOutputDto.setId(patient.getId());
        patientOutputDto.setName(patient.getName());
        patientOutputDto.setCity(patient.getCity());
        patientOutputDto.setEmail(patient.getEmail());
        patientOutputDto.setPhone(patient.getPhone());
        patientOutputDto.setSymptoms(patient.getSymptoms());
        patientOutputDto.setGender(patient.getGender());

        return patientOutputDto;
    }

    @Override
    public List<PatientOutputDto> getAllPatient() {
        List<PatientOutputDto> patientOutputDtoList = new ArrayList<>();

        List<Patient> patients = patientRepository.findAll();

        for (Patient patient : patients) {
            PatientOutputDto patientOutputDto = new PatientOutputDto();

            patientOutputDto.setId(patient.getId());
            patientOutputDto.setName(patient.getName());
            patientOutputDto.setCity(patient.getCity());
            patientOutputDto.setEmail(patient.getEmail());
            patientOutputDto.setPhone(patient.getPhone());
            patientOutputDto.setSymptoms(patient.getSymptoms());
            patientOutputDto.setGender(patient.getGender());

            patientOutputDtoList.add(patientOutputDto);
        }

        return patientOutputDtoList;
    }

    @Override
    public PatientOutputDto addPatient(PatientInputDto patientInputDto) {
        // Long id = ++patientRepository.findById(id);

        Patient patient = new Patient();

        //patient.setId(id);
        patient.setName(patientInputDto.getName());
        patient.setCity(patientInputDto.getCity());
        patient.setEmail(patientInputDto.getEmail());
        patient.setPhone(patientInputDto.getPhone());
        patient.setSymptoms(patientInputDto.getSymptoms());
        patient.setGender(patientInputDto.getGender());

        patient = patientRepository.save(patient);

        PatientOutputDto patientOutputDto = new PatientOutputDto();

        // patient = patientRepository.patients.get(id);

        patientOutputDto.setId(patient.getId());
        patientOutputDto.setName(patient.getName());
        patientOutputDto.setCity(patient.getCity());
        patientOutputDto.setEmail(patient.getEmail());
        patientOutputDto.setPhone(patient.getPhone());
        patientOutputDto.setSymptoms(patient.getSymptoms());
        patientOutputDto.setGender(patient.getGender());

        return patientOutputDto;
    }

    @Override
    public PatientOutputDto updatePatient(Long id, PatientInputDto patientInputDto) {
        Patient patient = new Patient();

        patient.setId(id);
        patient.setName(patientInputDto.getName());
        patient.setCity(patientInputDto.getCity());
        patient.setEmail(patientInputDto.getEmail());
        patient.setPhone(patientInputDto.getPhone());
        patient.setSymptoms(patientInputDto.getSymptoms());
        patient.setGender(patientInputDto.getGender());

        patient = patientRepository.save(patient);

        PatientOutputDto patientOutputDto = new PatientOutputDto();

        //patient = patientRepository.patients.get(id);

        patientOutputDto.setId(patient.getId());
        patientOutputDto.setName(patient.getName());
        patientOutputDto.setCity(patient.getCity());
        patientOutputDto.setEmail(patient.getEmail());
        patientOutputDto.setPhone(patient.getPhone());
        patientOutputDto.setSymptoms(patient.getSymptoms());
        patientOutputDto.setGender(patient.getGender());

        return patientOutputDto;
    }

    @Override
    public String removePatient(Long id) {
        String name = patientRepository.findById(id).orElse(null).getName();
        patientRepository.deleteById(id);

        return "Patient id: " + id + ", removed successfully!";
    }

    @Override
    public List<DoctorOutputDto> suggestDoctors(Long id) {
        Patient patient = patientRepository.findById(id).orElse(null);
        City patientCity = City.valueOf(patient.getCity().toUpperCase());

        Specialization needSpecailtization= getSpecialization(patient.getSymptoms());
        List<Doctor> doctorList=doctorRepository.findByCityAndSpecialization(patientCity,needSpecailtization);
        List<DoctorOutputDto> doctorOutputDtoList=new ArrayList<>();

        for(Doctor doctor : doctorList) {
            DoctorOutputDto doctorOutputDto = new DoctorOutputDto();

            doctorOutputDto.setId(doctor.getId());
            doctorOutputDto.setName(doctor.getName());
            doctorOutputDto.setCity(doctor.getCity());
            doctorOutputDto.setEmail(doctor.getEmail());
            doctorOutputDto.setPhone(doctor.getPhone());
            doctorOutputDto.setSpecialization(doctor.getSpecialization());
            doctorOutputDto.setGender(doctor.getGender());

            doctorOutputDtoList.add(doctorOutputDto);
        }

        return doctorOutputDtoList;
    }

    public Specialization getSpecialization(Symptoms symptom){
        return switch (symptom){
            case ARTHTITIS ,BACK_PAIN,TISSUE_INJURIES->Specialization.ORTHOPEDIC;
            case DYSMENORRHEA -> Specialization.GYNAECOLOGY;
            case SKIN_BURN,SKIN_INFECTION ->Specialization.DERMATOLOGY ;
            case EAR_PAIN -> Specialization.ENT;

        };
    }
}
