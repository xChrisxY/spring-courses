package com.chris.springboot.relationships.services.lessons;


import com.chris.springboot.relationships.exceptions.course.CourseNotFoundException;
import com.chris.springboot.relationships.exceptions.lessons.LessonNotFoundException;
import com.chris.springboot.relationships.models.Course;
import com.chris.springboot.relationships.models.Lesson;
import com.chris.springboot.relationships.repositories.CourseRepository;
import com.chris.springboot.relationships.repositories.LessonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LessonServiceImpl implements ILessonService{

    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;

    public LessonServiceImpl(LessonRepository lessonRepository, CourseRepository courseRepository){
        this.lessonRepository = lessonRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public Lesson create(Lesson lesson, Long courseId){

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Curso no encontrado"));

        lesson.setCourse(course);
        return lessonRepository.save(lesson);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Lesson> findById(Long id){
        return lessonRepository.findByIdWithAllData(id);
    }

    @Override
    @Transactional
    public Lesson update(Lesson lesson, Long lessonId){

        Long courseId = lesson.getCourse().getId();
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Curso no encontrado: " + courseId));

        Lesson existingLesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new LessonNotFoundException("Clase no encontrada: " + lessonId));

        existingLesson.setTitle(lesson.getTitle());
        existingLesson.setVideoUrl(lesson.getVideoUrl());
        existingLesson.setDurationMinutes(lesson.getDurationMinutes());
        existingLesson.setPosition(lesson.getPosition());
        existingLesson.setCourse(course);

        return lessonRepository.save(existingLesson);
    }
}
