package com.demo.realWorld.controller;

import com.demo.realWorld.controller.dtos.*;
import com.demo.realWorld.exception.ArticleNotFoundException;
import com.demo.realWorld.model.Article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/articles")
    public SingleArticleDto createArticle(@RequestBody CreateArticleDto article){
        ArticleDto createdArticle = articleService.createArticle(article);
        return new SingleArticleDto(createdArticle);
    }

    @PatchMapping("/articles/")
    public SingleArticleDto updateArticle(@RequestBody UpdateArticleRequest request, @PathVariable String slug){
        ArticleDto updatedArticle = articleService.updateArticle(request, slug);
        return new SingleArticleDto(updatedArticle);
    }

    @GetMapping("/articles/{slug}")
    public SingleArticleDto findArticleBySlug(@PathVariable String slug){
        ArticleDto article = articleService.getArticleBySlug(slug);
        return new SingleArticleDto(article);
    }

    @GetMapping("/articles")
    public MultipleArticleDto getAllArticles(){
        List<ArticleDto> articles = articleService.getAllArticles();
        return new MultipleArticleDto(articles);
    }
    @DeleteMapping("/articles/{slug}")
    public void deleteArticleBySlug(@PathVariable String slug){
        articleService.deleteArticleBySlug(slug);
    }
}
