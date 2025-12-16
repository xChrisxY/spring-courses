package com.chris.springboot.relationships.dto.lesson;

public class LessonDTO {

    private String title;
    private String videoUrl;
    private Integer videoMinutes;
    private Integer position;
    private Long course;

    public LessonDTO(){}

    public LessonDTO(String title, String videoUrl, Integer videoMinutes, Integer position, Long course) {
        this.title = title;
        this.videoUrl = videoUrl;
        this.videoMinutes = videoMinutes;
        this.position = position;
        this.course = course;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getVideoMinutes() {
        return videoMinutes;
    }

    public void setVideoMinutes(Integer videoMinutes) {
        this.videoMinutes = videoMinutes;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Long getCourse() {
        return course;
    }

    public void setCourse(Long course) {
        this.course = course;
    }
}
