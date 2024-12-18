package com.practo.service.impl;

import com.practo.entity.Doctor;
import com.practo.entity.Patients;
import com.practo.entity.Review;
import com.practo.exception.*;
import com.practo.payload.ReviewDto;
import com.practo.repository.DoctorRepository;
import com.practo.repository.PatientsRepository;
import com.practo.repository.ReviewRepository;
import com.practo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepo;

    @Autowired
    private PatientsRepository patientsRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Review createReview(ReviewDto reviewDto) {

        Patients patients = patientsRepository.findById(reviewDto.getPatientId())
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id" + reviewDto.getPatientId()));
        Doctor doctor = doctorRepository.findById(reviewDto.getDoctorId())
                .orElseThrow(() -> new DoctorNotFoundException("Doctors not Found with id" + reviewDto.getDoctorId()));


        if (reviewDto.getRatings() > 10 || reviewDto.getRatings() < 1) {
            throw new ReviewRatingsException("Rating range is 1-10 only");
        }
        if (reviewDto.getDescription().length() > 10) {
            throw new ReviewDescriptionException("Description should be 10 character only!!!");
        }

        Review review = new Review();
        review.setPatients(patients);
        review.setDoctor(doctor);
        review.setRatings(reviewDto.getRatings());
        review.setDescription(reviewDto.getDescription());
        return reviewRepo.save(review);
    }
}
