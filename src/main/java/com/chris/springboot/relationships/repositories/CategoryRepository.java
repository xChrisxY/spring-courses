package com.chris.springboot.relationships.repositories;

import com.chris.springboot.relationships.models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByCoursesId(Long courseId);

}
