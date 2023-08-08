package com.demo.realWorld.model.User;

import com.demo.realWorld.controller.dtos.ProfileDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public ProfileDto getProfileByUserName(String userName){
        ProfileDto profileDto = null;
        try{
            profileDto = new ProfileDto(userRepository.getUserByUserName(userName));
            return profileDto;
        } catch (NullPointerException exception){
            exception.getMessage();
            exception.printStackTrace();
        }
        return profileDto;
    }
}
