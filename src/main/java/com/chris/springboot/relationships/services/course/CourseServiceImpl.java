package com.chris.springboot.relationships.services.course;

import com.chris.springboot.relationships.enums.Level;
import com.chris.springboot.relationships.enums.Role;
import com.chris.springboot.relationships.exceptions.UserNotFoundException;
import com.chris.springboot.relationships.exceptions.UserNotTeacherException;
import com.chris.springboot.relationships.exceptions.course.CourseNotFoundException;
import com.chris.springboot.relationships.models.Course;
import com.chris.springboot.relationships.models.User;
import com.chris.springboot.relationships.repositories.CourseRepository;
import com.chris.springboot.relationships.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements ICourseService{

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseServiceImpl(CourseRepository courseRepository, UserRepository userRepository){
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
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
    public void delete(Long id){

        Course course = findById(id).
                orElseThrow(() -> new CourseNotFoundException("Curso no encontrado: " + id));

        courseRepository.delete(course);
    }
}
