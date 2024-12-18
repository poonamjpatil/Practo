package com.practo.service;


import com.practo.entity.Patients;
import com.practo.payload.PatientDto;

import java.util.List;

public interface PatientService {


    PatientDto addPatients(PatientDto patientDto);

    PatientDto getPatientById(long id);

    List<PatientDto> findAllPatient();

    String deletePatient(Long id);


//    List<PatientDto> findAllPatients();
}
