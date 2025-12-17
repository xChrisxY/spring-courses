package com.chris.springboot.relationships.repositories;

import com.chris.springboot.relationships.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
