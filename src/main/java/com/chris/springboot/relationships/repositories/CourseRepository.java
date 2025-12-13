package com.chris.springboot.relationships.repositories;

import com.chris.springboot.relationships.models.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {

}
