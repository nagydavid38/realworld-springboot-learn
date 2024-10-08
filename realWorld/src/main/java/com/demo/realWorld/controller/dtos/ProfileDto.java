package com.demo.realWorld.controller.dtos;

import com.demo.realWorld.model.User.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProfileDto {
    String username;
    String bio;
    String image;
    Boolean following;

    public ProfileDto(User user) {
        this.username = user.getUserName();
        this.bio = user.getBio();
        this.image = user.getImage();
        this.following = false;
    }
}
