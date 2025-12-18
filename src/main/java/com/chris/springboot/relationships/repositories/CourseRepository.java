package com.chris.springboot.relationships.repositories;

import com.chris.springboot.relationships.models.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course, Long> {

    @Query("select distinct c from Course c left join fetch c.categories where c.id = ?1")
    Optional<Course> findCategoriesByCourseId(Long courseId);
}
