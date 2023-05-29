package com.demo.realWorld.model.Article;

import com.demo.realWorld.model.User.User;

import java.util.List;

public class Article {
    String iD;
    String title;
    String slug;
    String description;
    String body;
    List<String> tags;
    User creator;
    Integer favoritedCount;
}
