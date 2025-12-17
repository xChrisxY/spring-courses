package com.chris.springboot.relationships.controllers;

import com.chris.springboot.relationships.dto.ApiResponse;
import com.chris.springboot.relationships.dto.lesson.LessonDTO;
import com.chris.springboot.relationships.dto.lesson.LessonResponseDTO;
import com.chris.springboot.relationships.exceptions.lessons.LessonNotFoundException;
import com.chris.springboot.relationships.mappers.LessonMapper;
import com.chris.springboot.relationships.models.Lesson;
import com.chris.springboot.relationships.services.lessons.ILessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/lessons")
public class LessonController {

    @Autowired
    private ILessonService lessonService;

    @Autowired
    private LessonMapper mapper;

    @PostMapping("/")
    public ResponseEntity<ApiResponse<LessonResponseDTO>> create(@RequestBody LessonDTO dto){

        Lesson newLesson = mapper.lessonDTOToLesson(dto);
        Long courseId = dto.getCourse();

        Lesson lesson = lessonService.create(newLesson, courseId);
        LessonResponseDTO lessonResponseDTO = mapper.lessonToLessonResponseDTO(lesson);

        ApiResponse<LessonResponseDTO> response = new ApiResponse<>(
                true,
                "Clase creada correctamente",
                201,
                lessonResponseDTO
        );

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<LessonResponseDTO>> findById(@PathVariable Long id){

        Optional<Lesson> optionalLesson = lessonService.findById(id);
        ApiResponse<LessonResponseDTO> response = new ApiResponse<>();

        if (optionalLesson.isPresent()){
            Lesson lesson = optionalLesson.get();
            LessonResponseDTO lessonDTO = mapper.lessonToLessonResponseDTO(lesson);

            response.setSuccess(true);
            response.setMessage("Clase obtenida correctamente");
            response.setStatus(200);
            response.setData(lessonDTO);

            return ResponseEntity.status(HttpStatus.OK.value()).body(response);
        }

        response.setSuccess(false);
        response.setMessage("No se pudo obtener la clase");
        response.setStatus(404);

        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

    @PutMapping("/{lessonId}")
    public ResponseEntity<ApiResponse<LessonResponseDTO>> update(@PathVariable Long lessonId, @RequestBody LessonDTO dto){

        Lesson lessonData = mapper.lessonDTOToLesson(dto);
        Long courseId = dto.getCourse();

        Lesson updatedLesson = lessonService.update(lessonData, lessonId, courseId);

        LessonResponseDTO lessonResponseDTO = mapper.lessonToLessonResponseDTO(updatedLesson);

        ApiResponse<LessonResponseDTO> response = new ApiResponse<>(
                true,
                "Clase actualizada correctamente",
                200,
                lessonResponseDTO
        );

        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

    @DeleteMapping("/{lessonId}")
    public ResponseEntity<Void> delete(@PathVariable Long lessonId){

        lessonService.delete(lessonId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).build();
    }

}
