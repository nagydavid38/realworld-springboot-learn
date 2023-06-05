package com.demo.realWorld.controller;

import com.demo.realWorld.controller.dtos.ArticleDto;
import com.demo.realWorld.model.Article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/articles")
    public ResponseEntity<?> createArticle(@RequestBody ArticleDto article){
        ArticleDto createdArticle = articleService.createArticle(article);
        return new ResponseEntity<>(createdArticle, HttpStatus.ACCEPTED);
    }

    @GetMapping("/articles/{slug}")
    public ResponseEntity<?> findArticleBySlug(@PathVariable String slug){
        ArticleDto article = articleService.getArticleBySlug(slug);
        return new ResponseEntity<>(article, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/articles/{slug}")
    public ResponseEntity<?> deleteArticleBySlug(@PathVariable String slug){
        Boolean articleDeleted = articleService.deleteArticleBySlug(slug);
        if (!articleDeleted)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
