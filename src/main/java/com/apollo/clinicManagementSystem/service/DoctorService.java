package com.apollo.clinicManagementSystem.service;

import com.apollo.clinicManagementSystem.dto.DocotorInputDto;
import com.apollo.clinicManagementSystem.dto.DoctorOutputDto;

import java.util.List;

public interface DoctorService {
    public DoctorOutputDto getDoctor(Long id);
    public List<DoctorOutputDto> getAllDoctors();
    public DoctorOutputDto addDoctor(DocotorInputDto doctorInputDto);
    public DoctorOutputDto updateDoctor(Long id, DocotorInputDto docotorInputDto);
    public String removeDoctor(Long id);


}
