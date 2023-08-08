package com.demo.realWorld.controller;

import com.demo.realWorld.controller.dtos.ProfileDto;
import com.demo.realWorld.controller.dtos.ProfileResponse;
import com.demo.realWorld.model.User.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProfileController {
    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profiles/{userName}")
    public ProfileResponse findProfileByUserName(@PathVariable String userName){
        ProfileDto profile = userService.getProfileByUserName(userName);
        return new ProfileResponse(profile);
    }
}
