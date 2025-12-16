package com.chris.springboot.relationships.repositories;

import com.chris.springboot.relationships.models.Lesson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LessonRepository extends CrudRepository<Lesson, Long> {

    @Query("select l from Lesson l join fetch l.course c join fetch c.professor p left join fetch p.userProfile where l.id = ?1")
    Optional<Lesson> findByIdWithAllData(Long id);

}
