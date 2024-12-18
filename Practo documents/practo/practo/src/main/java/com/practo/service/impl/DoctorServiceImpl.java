package com.practo.service.impl;

import com.practo.entity.Doctor;
import com.practo.repository.DoctorRepository;
import com.practo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor addDoctors(Doctor doctor) {
        Doctor saved = doctorRepository.save(doctor);
        return saved;
    }

   @Override
    public List<Doctor> searchDoctorsByNameOrSpecializations(String search) {
        return doctorRepository.findByDoctorNameOrSpecializations(search);
    }
}


