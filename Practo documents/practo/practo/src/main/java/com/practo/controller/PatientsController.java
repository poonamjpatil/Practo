package com.practo.controller;

import com.practo.payload.PatientDto;
import com.practo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientsController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/addPatients")
    public ResponseEntity<PatientDto> createPatients(@Valid @RequestBody PatientDto patientDto) {
        PatientDto dto = patientService.addPatients(patientDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/getPatients/{id}")
    public ResponseEntity<PatientDto>findPatientById(@PathVariable long id)
    {
        PatientDto patientById = patientService.getPatientById(id);
        return new ResponseEntity<>(patientById,HttpStatus.OK);
    }

    @GetMapping("/getAllPatients")
    public ResponseEntity<List<PatientDto>> findAllPatientByID()
    {
        List<PatientDto> allPatient = patientService.findAllPatient();
        return new ResponseEntity<>(allPatient,HttpStatus.OK);
    }

    @DeleteMapping("/deletePatients/{id}")
    public ResponseEntity<String> deletePatientById(@PathVariable Long id)
    {
        String message = patientService.deletePatient(id);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }



//    @GetMapping("/patientId/{id}")
//    public ResponseEntity<PatientDto> searchByPatientId(@PathVariable long id)
//    {
//        PatientDto patientDto = patientService.getPatientById(id);
//        return new ResponseEntity<>(patientDto,HttpStatus.OK);
//    }

//    @GetMapping("/findAllPatient")
//    public ResponseEntity<List<Patients>> SearchAllPatient()
//    {
//        List<Patients> allPatient = patientService.findAllPatient();
//        return new ResponseEntity<>(allPatient,HttpStatus.OK);
//
//    }
//    @GetMapping("/findAllPatient")
//    public ResponseEntity <List<PatientDto>> SearchAllPatients()
//    {
//        List<PatientDto> patientDtos = patientService.findAllPatients();
//        return new ResponseEntity<>(patientDtos,HttpStatus.OK);
//    }



//    @GetMapping("/getPatient/{id}")
//    public ResponseEntity<PatientDto> searchPatientById(@PathVariable long id){
//        PatientDto patientDtoById = patientService.getPatientById(id);
//        return new ResponseEntity<>(patientDtoById,HttpStatus.OK);
//    }
//
//    @GetMapping("/getAllPatients")
//    public ResponseEntity<List<Patients>> getAllPatients()
//    {
//        List<Patients> allPatients = patientService.getAllPatients();
//        return new ResponseEntity<>(allPatients,HttpStatus.OK);
//    }
//


}
