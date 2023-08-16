package com.demo.realWorld.controller.dtos;

import com.demo.realWorld.model.User.User;

public class ProfileDto {
    String username;
    String bio;
    String image;
    Boolean following;

    public ProfileDto(String username, String bio, String image, Boolean following) {
        this.username = username;
        this.bio = bio;
        this.image = image;
        this.following = following;
    }
    public ProfileDto(User user) {
        this.username = user.getUserName();
        this.bio = user.getBio();
        this.image = user.getImage();
        this.following = false;
    }

    public String getUsername() {
        return username;
    }

    public String getBio() {
        return bio;
    }

    public String getImage() {
        return image;
    }

    public Boolean getFollowing() {
        return following;
    }
}
