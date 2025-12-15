package com.chris.springboot.relationships.services.course;

import com.chris.springboot.relationships.models.Course;
import com.chris.springboot.relationships.models.User;

import java.util.List;
import java.util.Optional;

public interface ICourseService {

    Course create(Course course, Long professorId);
    List<Course> findAll();
    Optional<Course> findById(Long id);
    Course update(Course course, Long courseId, Long professorId);
    User validateProfessorRol(Long professorId);
    void delete(Long id);
}
