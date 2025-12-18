package com.chris.springboot.relationships.controllers;

import com.chris.springboot.relationships.dto.enrollment.EnrollmentDTO;
import com.chris.springboot.relationships.mappers.EnrollmentMapper;
import com.chris.springboot.relationships.models.Enrollment;
import com.chris.springboot.relationships.services.enrollment.IEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/enrollments")
public class EnrollmentController {

    @Autowired
    private IEnrollmentService enrollmentService;

    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @PostMapping("/")
    public ResponseEntity<Void> create(@RequestBody EnrollmentDTO dto){

        Enrollment enrollment = enrollmentMapper.enrollmentDTOToEnrollment(dto);
        System.out.println(enrollment.getCourse());
        System.out.println(enrollment.getUser());


        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).build();
    }
}
