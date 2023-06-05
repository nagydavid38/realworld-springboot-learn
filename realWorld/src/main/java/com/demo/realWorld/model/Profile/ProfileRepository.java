package com.demo.realWorld.model.Profile;

import com.demo.realWorld.model.Article.Article;
import com.demo.realWorld.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProfileRepository extends JpaRepository<Profile, UUID> {

    List<Profile> getAllFollowersByUserName(String userName);
}
