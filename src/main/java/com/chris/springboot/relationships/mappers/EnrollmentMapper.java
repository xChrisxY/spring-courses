package com.chris.springboot.relationships.mappers;

import com.chris.springboot.relationships.dto.enrollment.EnrollmentDTO;
import com.chris.springboot.relationships.models.Enrollment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {

    Enrollment enrollmentDTOToEnrollment(EnrollmentDTO dto);

}
