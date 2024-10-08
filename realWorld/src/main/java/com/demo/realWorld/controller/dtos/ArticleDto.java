package com.demo.realWorld.controller.dtos;

import com.demo.realWorld.model.Article.Article;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ArticleDto {
    String title;
    String slug;
    String description;
    String body;
    List<String> tagList;
    ProfileDto author;

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
}
