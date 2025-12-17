package com.chris.springboot.relationships.mappers;

import com.chris.springboot.relationships.dto.category.CategoryDTO;
import com.chris.springboot.relationships.models.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category categoryDTOToCategory(CategoryDTO dto);
    CategoryDTO categoryToCategoryDTO(Category category);

}
