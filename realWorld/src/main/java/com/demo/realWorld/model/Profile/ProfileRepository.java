package com.demo.realWorld.model.Profile;

import com.demo.realWorld.model.Article.Article;
import com.demo.realWorld.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, String> {
    List<Article> getAllArticlesByProfile(Profile profile);
    List<User> getAllFollowers(Profile profile);
}