package com.chris.springboot.relationships.services.enrollment;

import com.chris.springboot.relationships.models.Enrollment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnrollmentServiceImpl implements IEnrollmentService{

    @Override
    @Transactional
    public Enrollment create(Enrollment enrollment){
        return null;
    }
}
