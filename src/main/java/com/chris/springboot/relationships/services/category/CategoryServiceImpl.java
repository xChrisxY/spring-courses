package com.chris.springboot.relationships.services.category;

import com.chris.springboot.relationships.exceptions.category.CategoryNotFoundException;
import com.chris.springboot.relationships.models.Category;
import com.chris.springboot.relationships.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public Category create(Category category){

        return categoryRepository.save(category);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll(){

        return (List<Category>) categoryRepository.findAll();

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Category> findById(Long categoryId){

        return categoryRepository.findById(categoryId);

    }

    @Override
    @Transactional
    public void delete(Long categoryId){

        Category category = findById(categoryId).
                orElseThrow(() -> new CategoryNotFoundException("Categoria no encontrada: "+ categoryId));

        categoryRepository.delete(category);

    }
}
