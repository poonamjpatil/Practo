//package com.practo.controller;
//
//import com.practo.entity.Doctor;
//import com.practo.service.DoctorService;
//import com.practo.service.impl.DoctorServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/doctors")
//public class DoctorController {
//
//    @Autowired
//    private DoctorService doctorService;
//
//    @PostMapping("/add")
//    public ResponseEntity<Doctor> addDoctors(@RequestBody Doctor doctor)
//    {
//        Doctor addedDoctors = doctorService.addDoctors(doctor);
//        return new ResponseEntity<>(addedDoctors, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/search")
//    public ResponseEntity<?> getDoctorsById(@RequestParam String search) {
//        List<Doctor> doctorList = doctorService.searchDoctorsByNameOrSpecializations(search);
//        if (doctorList.isEmpty()) {
//            return new ResponseEntity<>("Record Not Found", HttpStatus.INTERNAL_SERVER_ERROR);
//        } else {
//            return new ResponseEntity<>(doctorList, HttpStatus.OK);
//        }
//    }
//}
