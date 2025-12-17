package com.chris.springboot.relationships.controllers;

import com.chris.springboot.relationships.dto.ApiResponse;
import com.chris.springboot.relationships.dto.category.CategoryDTO;
import com.chris.springboot.relationships.mappers.CategoryMapper;
import com.chris.springboot.relationships.models.Category;
import com.chris.springboot.relationships.services.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @PostMapping("/")
    public ResponseEntity<ApiResponse<CategoryDTO>> create(@RequestBody CategoryDTO dto){

        Category category = categoryMapper.categoryDTOToCategory(dto);

        Category newCategory = categoryService.create(category);

        ApiResponse<CategoryDTO> response = new ApiResponse<>(
                true,
                "Categoria creada correctamente",
                200,
                dto
        );

        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<CategoryDTO>>> list(){

        List<Category> categories = categoryService.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();

        categories.forEach(category -> {
            CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);
            categoryDTOS.add(categoryDTO);
        });

        ApiResponse<List<CategoryDTO>> response = new ApiResponse<>(
                true,
                "Lista de categorias obtenidas correctamente",
                200,
                categoryDTOS
        );

        return ResponseEntity.status(HttpStatus.OK.value()).body(response);

    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<ApiResponse<CategoryDTO>> findById(@PathVariable Long categoryId){

        Optional<Category> optionalCategory = categoryService.findById(categoryId);
        ApiResponse<CategoryDTO> response = new ApiResponse<>();

        if (optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

            response.setSuccess(true);
            response.setMessage("Categoria obtenida correctamente");
            response.setStatus(200);
            response.setData(categoryDTO);

            return ResponseEntity.status(HttpStatus.OK.value()).body(response);
        }

        response.setSuccess(false);
        response.setMessage("No se pudo obtener la categoria");
        response.setStatus(404);

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(response);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> delete(@PathVariable Long categoryId){

        categoryService.delete(categoryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).build();
    }

}
