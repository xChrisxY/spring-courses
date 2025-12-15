package com.chris.springboot.relationships.mappers;

import com.chris.springboot.relationships.dto.course.CourseCreateDTO;
import com.chris.springboot.relationships.dto.course.CourseDTO;
import com.chris.springboot.relationships.models.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface CourseMapper {

    @Mapping(target = "professor", ignore = true)
    Course courseCreateDTOtoCourse(CourseCreateDTO dto);
    CourseDTO courseToCourseDTO(Course course);
}
