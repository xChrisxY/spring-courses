package com.chris.springboot.relationships.repositories;

import com.chris.springboot.relationships.models.Enrollment;
import org.springframework.data.repository.CrudRepository;

public interface EnrollmentRepository extends CrudRepository<Enrollment, Long> {

}
