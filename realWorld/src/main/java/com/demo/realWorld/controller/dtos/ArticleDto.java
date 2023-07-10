package com.demo.realWorld.controller.dtos;

import com.demo.realWorld.model.Article.Article;

import java.util.List;

public class ArticleDto {
    String title;
    String slug;
    String description;
    String body;
    List<String> tags;

    public ArticleDto(String title, String slug, String description, String body, List<String> tags) {
        this.title = title;
        this.slug = slug;
        this.description = description;
        this.body = body;
        this.tags = tags;
    }

    public ArticleDto(Article article){
        this(
                article.getTitle(),
                article.getSlug(),
                article.getDescription(),
                article.getBody(),
                article.getTags()
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

    public List<String> getTags() {
        return tags;
    }
}
