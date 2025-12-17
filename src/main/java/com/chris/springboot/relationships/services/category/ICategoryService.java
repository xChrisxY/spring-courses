package com.chris.springboot.relationships.services.category;

import com.chris.springboot.relationships.models.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    Category create(Category category);
    List<Category> findAll();
    Optional<Category> findById(Long categoryId);
    void delete(Long categoryId);

}
