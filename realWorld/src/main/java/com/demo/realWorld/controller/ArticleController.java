package com.demo.realWorld.controller;

import com.demo.realWorld.controller.dtos.ArticleDto;
import com.demo.realWorld.controller.dtos.CreateArticleDto;
import com.demo.realWorld.controller.dtos.MultipleArticleDto;
import com.demo.realWorld.controller.dtos.SingleArticleDto;
import com.demo.realWorld.model.Article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
