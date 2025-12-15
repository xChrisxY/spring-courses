package com.chris.springboot.relationships.dto.course;

import com.chris.springboot.relationships.dto.user.UserResponseDTO;
import com.chris.springboot.relationships.enums.Level;

import java.math.BigDecimal;

public class CourseDTO {

    private String name;
    private String description;
    private Level level;
    private BigDecimal price;
    private UserResponseDTO professor;

    public CourseDTO(){}

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

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public UserResponseDTO getProfessor() {
        return professor;
    }

    public void setProfessor(UserResponseDTO professor) {
        this.professor = professor;
    }
}
