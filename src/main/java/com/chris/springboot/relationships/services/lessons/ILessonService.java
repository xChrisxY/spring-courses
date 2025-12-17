package com.chris.springboot.relationships.services.lessons;

import com.chris.springboot.relationships.models.Lesson;

import java.util.List;
import java.util.Optional;

public interface ILessonService {

    Lesson create(Lesson lesson, Long courseId);
    Optional<Lesson> findById(Long id);
    Lesson update(Lesson lesson, Long lessonId, Long courseId);
    void delete(Long lessonId);
}
