package com.chris.springboot.relationships.dto.lesson;

import com.chris.springboot.relationships.dto.course.CourseDTO;

public class LessonResponseDTO {

    private String title;
    private String videoUrl;
    private Integer videoMinutes;
    private Integer position;
    private CourseDTO course;

    public LessonResponseDTO(){}

    public LessonResponseDTO(String title, String videoUrl, Integer videoMinutes, Integer position, CourseDTO course) {
        this.title = title;
        this.videoUrl = videoUrl;
        this.videoMinutes = videoMinutes;
        this.position = position;
        this.course = course;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getVideoMinutes() {
        return videoMinutes;
    }

    public void setVideoMinutes(Integer videoMinutes) {
        this.videoMinutes = videoMinutes;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }
}
