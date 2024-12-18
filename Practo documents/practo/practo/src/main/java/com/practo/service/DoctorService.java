package com.practo.service;

import com.practo.entity.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DoctorService {

    Doctor addDoctors(Doctor doctor);

    List<Doctor> searchDoctorsByNameOrSpecializations(String search);
}
