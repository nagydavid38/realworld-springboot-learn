package com.demo.realWorld.controller.dtos;

import java.util.List;

import lombok.Getter;

@Getter
public class MultipleArticleDto {
    List<ArticleDto> articles;

    int articlesCount;

    public MultipleArticleDto(List<ArticleDto> articles){
        this.articles = articles;
        this.articlesCount = articles.size();
    }
}
