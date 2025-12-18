package com.chris.springboot.relationships.dto.course;

import com.chris.springboot.relationships.dto.category.CategoryDTO;
import com.chris.springboot.relationships.enums.Level;

import java.math.BigDecimal;
import java.util.List;

public class CourseCategoryDTO {

    private String name;
    private String description;
    private Level level;
    private BigDecimal price;
    private List<CategoryDTO> categories;

    public CourseCategoryDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
}
