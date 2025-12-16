package com.chris.springboot.relationships.models;

import jakarta.persistence.*;

@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;

    private Integer position;

    @ManyToOne
    @JoinColumn
    private Course course;

    public Lesson(){}

    public Lesson(String title, String videoUrl, Integer durationMinutes, Integer position) {
        this.title = title;
        this.videoUrl = videoUrl;
        this.durationMinutes = durationMinutes;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", durationMinutes=" + durationMinutes +
                ", position=" + position +
                '}';
    }
}
