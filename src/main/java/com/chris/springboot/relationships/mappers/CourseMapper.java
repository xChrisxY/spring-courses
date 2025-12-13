package com.chris.springboot.relationships.mappers;

import com.chris.springboot.relationships.dto.course.CourseCreateDTO;
import com.chris.springboot.relationships.models.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course courseCreateDTOtoCourse(CourseCreateDTO dto);
}
