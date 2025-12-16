package com.chris.springboot.relationships.mappers;

import com.chris.springboot.relationships.dto.lesson.LessonDTO;
import com.chris.springboot.relationships.dto.lesson.LessonResponseDTO;
import com.chris.springboot.relationships.models.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { CourseMapper.class })
public interface LessonMapper {

    @Mapping(target = "course", ignore = true)
    Lesson lessonDTOToLesson(LessonDTO dto);

    LessonResponseDTO lessonToLessonResponseDTO(Lesson lesson);
}
