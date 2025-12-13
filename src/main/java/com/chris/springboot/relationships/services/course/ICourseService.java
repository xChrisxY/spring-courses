package com.chris.springboot.relationships.services.course;

import com.chris.springboot.relationships.models.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseService {

    Course create(Course course);
    List<Course> findAll();
    Optional<Course> findById();
}
