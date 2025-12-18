package com.chris.springboot.relationships.controllers;

import com.chris.springboot.relationships.dto.ApiResponse;
import com.chris.springboot.relationships.dto.category.CategoryDTO;
import com.chris.springboot.relationships.dto.course.CourseCategoryDTO;
import com.chris.springboot.relationships.dto.course.CourseCreateDTO;
import com.chris.springboot.relationships.dto.course.CourseDTO;
import com.chris.springboot.relationships.dto.lesson.LessonDTO;
import com.chris.springboot.relationships.dto.lesson.LessonResponseDTO;
import com.chris.springboot.relationships.mappers.CategoryMapper;
import com.chris.springboot.relationships.mappers.CourseMapper;
import com.chris.springboot.relationships.mappers.LessonMapper;
import com.chris.springboot.relationships.models.Category;
import com.chris.springboot.relationships.models.Course;
import com.chris.springboot.relationships.models.Lesson;
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
    private CourseMapper courseMapper;

    @Autowired
    private LessonMapper lessonMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @PostMapping("/")
    public ResponseEntity<ApiResponse<CourseDTO>> create(@RequestBody CourseCreateDTO dto){

        Long professorId = dto.getProfessor();
        Course course = courseMapper.courseCreateDTOtoCourse(dto);

        Course newCourse = courseService.create(course, professorId);

        CourseDTO courseDTO = courseMapper.courseToCourseDTO(newCourse);

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
            CourseDTO courseDTO = courseMapper.courseToCourseDTO(course);
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
            CourseDTO courseDTO = courseMapper.courseToCourseDTO(course);

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

        Course course = courseMapper.courseCreateDTOtoCourse(dto);
        Long professorId = dto.getProfessor();

        Course updatedCourse = courseService.update(course, courseId, professorId);

        CourseDTO courseDTO = courseMapper.courseToCourseDTO(updatedCourse);

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

    @GetMapping("/{courseId}/lessons")
    public ResponseEntity<ApiResponse<List<LessonResponseDTO>>> listCourses(@PathVariable Long courseId){

        List<Lesson> lessons = courseService.getLessonsByCourse(courseId);
        List<LessonResponseDTO> lessonResponseDTOS = new ArrayList<>();

        lessons.forEach(lesson -> {
            LessonResponseDTO lessonDTO = lessonMapper.lessonToLessonResponseDTO(lesson);
            lessonResponseDTOS.add(lessonDTO);
        });

        ApiResponse<List<LessonResponseDTO>> response = new ApiResponse<>(
                true,
                "Lista de lecciones por el curso: " + courseId,
                200,
                lessonResponseDTOS
        );

        return ResponseEntity.status(HttpStatus.OK.value()).body(response);

    }

    @GetMapping("/{courseId}/categories")
    public ResponseEntity<ApiResponse<CourseCategoryDTO>> listCategories(@PathVariable Long courseId){

        Course course = courseService.getCourseWithCategories(courseId);
        CourseCategoryDTO courseCategoryDTO = courseMapper.courseToCourseCategoryDTO(course);

        ApiResponse<CourseCategoryDTO> response = new ApiResponse<>(
                true,
                "Categorias por curso obtenidas exitosamente",
                200,
                courseCategoryDTO
        );

        return ResponseEntity.status(HttpStatus.OK.value()).body(response);

    }

    @PostMapping("/{courseId}/categories/{categoryId}")
    public ResponseEntity<ApiResponse<CourseCategoryDTO>> createCategoryByCourseId(@PathVariable Long courseId, @PathVariable Long categoryId){

        Course course = courseService.createCategoryByCourseId(courseId, categoryId);
        CourseCategoryDTO courseCategoryDTO = courseMapper.courseToCourseCategoryDTO(course);

        ApiResponse<CourseCategoryDTO> response = new ApiResponse<>(
                true,
                "Categoria aignada correctamente en el curso: " + courseId,
                201,
                courseCategoryDTO
        );

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
    }

    @DeleteMapping("/{courseId}/categories/{categoryId}")
    public ResponseEntity<Void> deleteCategoryByCourseId(@PathVariable Long courseId, @PathVariable Long categoryId){

        courseService.deleteCategoryByCourseId(courseId, categoryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).build();

    }

}
