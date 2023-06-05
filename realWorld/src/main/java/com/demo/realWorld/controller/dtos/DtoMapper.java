package com.demo.realWorld.controller.dtos;

import com.demo.realWorld.model.Article.Article;

public class DtoMapper {
    public DtoMapper() {
    }

    public ArticleDto toArticleDto(Article article){
        return new ArticleDto(article.getTitle(),
                              article.getSlug(),
                              article.getDescription(),
                              article.getBody(),
                              article.getTags());
    }

    public Article toArticle(ArticleDto dto){
        return new Article.ArticleBuilder().setTitle(dto.getTitle())
                .setSlug(dto.getSlug()).setDescription(dto.getDescription())
                .setBody(dto.getBody()).setTags(dto.getTags()).build();
    }
}
