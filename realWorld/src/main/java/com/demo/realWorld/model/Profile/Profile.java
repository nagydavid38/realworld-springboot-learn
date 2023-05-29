package com.demo.realWorld.model.Profile;

import com.demo.realWorld.model.Article.Article;
import com.demo.realWorld.model.User.User;

import java.util.List;
import java.util.Map;

public class Profile {
    String iD;
    String userName;
    String bio;
    String image;
    List<User> followers;
    List<Article> articles;
}
