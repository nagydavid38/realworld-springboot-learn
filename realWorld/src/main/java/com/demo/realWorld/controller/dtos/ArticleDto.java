package com.demo.realWorld.controller.dtos;

import com.demo.realWorld.model.Article.Article;

import java.util.List;

public class ArticleDto {
    String title;
    String slug;
    String description;
    String body;
    List<String> tagList;
    ProfileDto author;

    public ArticleDto(String title, String slug, String description, String body, List<String> tagList, ProfileDto author) {
        this.title = title;
        this.slug = slug;
        this.description = description;
        this.body = body;
        this.tagList = tagList;
        this.author = author;
    }

    public ArticleDto(Article article){
        this(
                article.getTitle(),
                article.getSlug(),
                article.getDescription(),
                article.getBody(),
                article.getTags(),
                new ProfileDto(article.getCreator())
        );
    }

    public String getTitle() {
        return title;
    }

    public String getSlug() {
        return slug;
    }

    public String getDescription() {
        return description;
    }

    public String getBody() {
        return body;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public ProfileDto getAuthor() {
        return author;
    }
}
