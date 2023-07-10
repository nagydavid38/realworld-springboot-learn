package com.demo.realWorld.controller.dtos;

public class SingleArticleDto {
    private ArticleDto article;

    public SingleArticleDto(ArticleDto article){
        this.article=article;
    }

    public ArticleDto getArticle() {
        return article;
    }
}
