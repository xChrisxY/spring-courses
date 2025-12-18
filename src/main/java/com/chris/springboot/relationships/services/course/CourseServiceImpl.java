package com.chris.springboot.relationships.services.course;

import com.chris.springboot.relationships.enums.Role;
import com.chris.springboot.relationships.exceptions.UserNotFoundException;
import com.chris.springboot.relationships.exceptions.UserNotTeacherException;
import com.chris.springboot.relationships.exceptions.category.CategoryNotFoundException;
import com.chris.springboot.relationships.exceptions.course.CourseNotFoundException;
import com.chris.springboot.relationships.models.Category;
import com.chris.springboot.relationships.models.Course;
import com.chris.springboot.relationships.models.Lesson;
import com.chris.springboot.relationships.models.User;
import com.chris.springboot.relationships.repositories.CategoryRepository;
import com.chris.springboot.relationships.repositories.CourseRepository;
import com.chris.springboot.relationships.repositories.LessonRepository;
import com.chris.springboot.relationships.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements ICourseService{

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final LessonRepository lessonRepository;
    private final CategoryRepository categoryRepository;

    public CourseServiceImpl(CourseRepository courseRepository, UserRepository userRepository, LessonRepository lessonRepository, CategoryRepository categoryRepository){
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.lessonRepository = lessonRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public Course create(Course course, Long professorId) {

        User user = validateProfessorRol(professorId);

        course.setProfessor(user);
        return courseRepository.save(course);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll(){
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Course> findById(Long id) {

        return courseRepository.findById(id);

    }

    @Override
    @Transactional
    public Course update(Course course, Long courseId, Long professorId){

        Course existingCourse = findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Curso no encontrado."));

        User professor = validateProfessorRol(professorId);

        existingCourse.setName(course.getName());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setLevel(course.getLevel());
        existingCourse.setPrice(course.getPrice());
        existingCourse.setProfessor(professor);

        return courseRepository.save(existingCourse);

    }

    @Override
    @Transactional(readOnly = true)
    public User validateProfessorRol(Long professorId){

        User user = userRepository.findById(professorId)
                .orElseThrow(() -> new UserNotFoundException("Este usuario no existe."));

        if (! (user.getRole() == Role.TEACHER) ){
            throw new UserNotTeacherException("El usuario dado no tiene el rol de profesor asignado.");
        }

        return user;
    }

    @Override
    @Transactional
    public void delete(Long id){

        Course course = validateExistingCourse(id);
        courseRepository.delete(course);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Lesson> getLessonsByCourse(Long courseId){

        validateExistingCourse(courseId);
        return lessonRepository.findByCourseId(courseId);
    }

    @Override
    @Transactional(readOnly = true)
    public Course getCourseWithCategories(Long courseId){

        return courseRepository.findCategoriesByCourseId(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Curso no encontrado: " + courseId));
    }

    @Override
    @Transactional
    public Course createCategoryByCourseId(Long courseId, Long categoryId){

        Course course = validateExistingCourse(courseId);
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("La categoria no fue encontrada: " + categoryId));

        course.addCategory(category);
        courseRepository.save(course);

        return getCourseWithCategories(courseId);
    }

    @Override
    @Transactional
    public void deleteCategoryByCourseId(Long courseId, Long categoryId){

        Course course = validateExistingCourse(courseId);
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("La categoria no fue encontrada: " + categoryId));

        course.removeCategory(category);
    }

    @Transactional(readOnly = true)
    public Course validateExistingCourse(Long courseId){

        return findById(courseId).orElseThrow(() -> new CourseNotFoundException("Curso no encontrado: " + courseId));
    }


}
