package com.apollo.clinicManagementSystem.service;

import com.apollo.clinicManagementSystem.dto.DoctorOutputDto;
import com.apollo.clinicManagementSystem.dto.PatientInputDto;
import com.apollo.clinicManagementSystem.dto.PatientOutputDto;

import java.util.List;

public interface PatientSerivce {
 public PatientOutputDto getPatient(Long id);
  public List<PatientOutputDto> getAllPatient();
  public PatientOutputDto addPatient(PatientInputDto patientOutputDto);
  public PatientOutputDto updatePatient(Long id, PatientInputDto patientInputDto);
  public String removePatient(Long id);
  List<DoctorOutputDto> suggestDoctors(Long id);

}
