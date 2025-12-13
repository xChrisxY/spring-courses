package com.chris.springboot.relationships.controllers;

import com.chris.springboot.relationships.dto.course.CourseCreateDTO;
import com.chris.springboot.relationships.mappers.CourseMapper;
import com.chris.springboot.relationships.models.Course;
import com.chris.springboot.relationships.services.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    private IUserService userService;

    @Autowired
    private CourseMapper mapper;

    @PostMapping("/")
    public Map<String, Object> create(@RequestBody CourseCreateDTO dto){

        Course course = mapper.courseCreateDTOtoCourse(dto);

        System.out.println(course);

        Map<String, Object> response = new HashMap<>();
        response.put("Message", "Success");
        return response;

    }

}
