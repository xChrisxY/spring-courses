package com.chris.springboot.relationships.controllers;

import com.chris.springboot.relationships.dto.ApiResponse;
import com.chris.springboot.relationships.dto.course.CourseCreateDTO;
import com.chris.springboot.relationships.dto.course.CourseDTO;
import com.chris.springboot.relationships.mappers.CourseMapper;
import com.chris.springboot.relationships.models.Course;
import com.chris.springboot.relationships.services.course.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @Autowired
    private CourseMapper mapper;

    @PostMapping("/")
    public ResponseEntity<ApiResponse<CourseDTO>> create(@RequestBody CourseCreateDTO dto){

        Long professorId = dto.getProfessor();
        Course course = mapper.courseCreateDTOtoCourse(dto);

        Course newCourse = courseService.create(course, professorId);

        CourseDTO courseDTO = mapper.courseToCourseDTO(newCourse);

        ApiResponse<CourseDTO> response = new ApiResponse<>(
                true,
                "Curso creado correctamente",
                201,
                courseDTO
        );

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<CourseDTO>>> list(){

        List<Course> courses = courseService.findAll();
        List<CourseDTO> coursesDtos = new ArrayList<>();

        courses.forEach(course -> {
            CourseDTO courseDTO = mapper.courseToCourseDTO(course);
            coursesDtos.add(courseDTO);
        });

        ApiResponse<List<CourseDTO>> response = new ApiResponse<>(
          true,
          "Cursos obtenidos correctamente",
          200,
          coursesDtos
        );

        return ResponseEntity.status(HttpStatus.OK.value()).body(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseDTO>> findById(@PathVariable Long id){

        Optional<Course> optionalCourse = courseService.findById(id);
        ApiResponse<CourseDTO> response = new ApiResponse<>();

        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            CourseDTO courseDTO = mapper.courseToCourseDTO(course);

            response.setSuccess(true);
            response.setMessage("Curso obtenido correctamente");
            response.setStatus(200);
            response.setData(courseDTO);

            return ResponseEntity.status(HttpStatus.OK.value()).body(response);
        }

        response.setSuccess(false);
        response.setMessage("No se pudo obtener ningún curso.");
        response.setStatus(404);

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(response);

    }

    @PutMapping("/{courseId}")
    public ResponseEntity<ApiResponse<CourseDTO>> update(@PathVariable Long courseId, @RequestBody CourseCreateDTO dto){

        Course course = mapper.courseCreateDTOtoCourse(dto);
        Long professorId = dto.getProfessor();

        Course updatedCourse = courseService.update(course, courseId, professorId);

        CourseDTO courseDTO = mapper.courseToCourseDTO(updatedCourse);

        ApiResponse<CourseDTO> response = new ApiResponse<>(
                false,
                "Curso actualizado correctamente",
                200,
                courseDTO
        );

        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        courseService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).build();

    }

}
