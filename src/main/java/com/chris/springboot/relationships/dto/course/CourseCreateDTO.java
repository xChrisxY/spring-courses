package com.chris.springboot.relationships.dto.course;

import com.chris.springboot.relationships.enums.Level;

import java.math.BigDecimal;

public class CourseCreateDTO {

    private String name;
    private String description;
    private Level level;
    private BigDecimal price;
    private Long professorId;

    public CourseCreateDTO(String name, String description, Level level, BigDecimal price, Long professorId) {
        this.name = name;
        this.description = description;
        this.level = level;
        this.price = price;
        this.professorId = professorId;
    }

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

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professor) {
        this.professorId = professor;
    }
}
