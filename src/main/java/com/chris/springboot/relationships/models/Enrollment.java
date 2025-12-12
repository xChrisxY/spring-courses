package com.chris.springboot.relationships.models;

import com.chris.springboot.relationships.enums.Status;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Table(name = "enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "enrolled_at")
    private LocalDateTime enrolledAt;

    private Integer progress;
    private Status status;

    @ManyToOne
    private User user;

    @ManyToOne
    private Course course;

    public Enrollment(){}

    public Enrollment(Integer progress, Status status) {
        this.progress = progress;
        this.status = status;
    }

    @PrePersist
    public void prePersist(){
        this.enrolledAt = LocalDateTime.now();
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getEnrolledAt() {
        return enrolledAt;
    }

    public void setEnrolledAt(LocalDateTime enrolledAt) {
        this.enrolledAt = enrolledAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
