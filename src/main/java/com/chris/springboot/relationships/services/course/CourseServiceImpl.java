package com.chris.springboot.relationships.services.course;

import com.chris.springboot.relationships.models.Course;
import com.chris.springboot.relationships.repositories.CourseRepository;

import java.util.List;
import java.util.Optional;

public class CourseServiceImpl implements ICourseService{

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public Course create(Course course) {
        return null;
    }

    @Override
    public List<Course> findAll(){
        return null;
    }

    @Override
    public Optional<Course> findById(){
        return null;
    }
}
