package com.demo.realWorld.controller.dtos;

import java.util.List;

public class MultipleArticleDto {
    List<ArticleDto> articles;

    int articlesCount;

    public MultipleArticleDto(List<ArticleDto> articles){
        this.articles = articles;
        this.articlesCount = articles.size();
    }

    public List<ArticleDto> getArticles() {
        return articles;
    }

    public int getArticlesCount() {
        return articlesCount;
    }
}
