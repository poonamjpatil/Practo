package com.practo.service.impl;

import com.practo.entity.Patients;
import com.practo.exception.PatientException;
import com.practo.exception.PatientNotFoundException;
import com.practo.payload.PatientDto;
import com.practo.repository.PatientsRepository;
import com.practo.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PatientsServiceImpl implements PatientService {

    @Autowired
    private PatientsRepository patientsRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PatientDto addPatients(PatientDto patientDto){
        Patients patients = modelMapper.map(patientDto, Patients.class);
        if (patients.getAge().isEmpty() || patients.getAge().length() > 2) {
            throw new PatientException("Patient age must be a two-digit number.");
        }
        Patients savePatient = patientsRepository.save(patients);

        return modelMapper.map(savePatient, PatientDto.class);
    }

    @Override
    public PatientDto getPatientById(long id) {
        Patients patients = patientsRepository.findById(id).orElseThrow(
                () -> new PatientNotFoundException("Patient not found with id" + id)
        );
        return modelMapper.map(patients,PatientDto.class);
    }

    @Override
    public List<PatientDto> findAllPatient() {
        List<Patients> allPatients = patientsRepository.findAll();
        List<PatientDto> patientDtos = allPatients.stream().map(patients -> modelMapper.map(patients, PatientDto.class)).
                collect(Collectors.toList());
        return patientDtos;
    }

    @Override
    public String deletePatient(Long id) {
        Patients patients = patientsRepository.findById(id).orElseThrow(
                () -> new PatientNotFoundException("Patient not found with id " + id + " to delete")
        );

        patientsRepository.deleteById(id);
        return "Patients deleted successfully with id "+id;
    }
//    @Override
//    public PatientDto getPatientById(long id)
//    {
//        Patients patients = patientsRepository.findById(id).orElseThrow(
//                () -> new PatientNotFoundException("Patient not find with id " + id)
//        );
//        return modelMapper.map(patients,PatientDto.class);
//    }
//
//    @Override
//    public List<Patients> findAllPatient() {
//        List<Patients> allPatient = patientsRepository.findAll();
//        return allPatient;
//    }
}
