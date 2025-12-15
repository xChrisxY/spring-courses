package com.chris.springboot.relationships.dto.user;

public class UserProfileCreateDTO {

    private String firstName;
    private String lastName;
    private Integer age;
    private String bio;
    private String avatarUrl;

    public UserProfileCreateDTO(){}

    public UserProfileCreateDTO(String firstName, String lastName, Integer age, String bio, String avatarUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.bio = bio;
        this.avatarUrl = avatarUrl;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

}
