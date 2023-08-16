package com.demo.realWorld.model.Article;

import com.demo.realWorld.controller.dtos.ArticleDto;
import com.demo.realWorld.controller.dtos.ProfileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Transactional
    public ArticleDto createArticle (ArticleDto articleDto){
        LocalDateTime createdDate = LocalDateTime.now();
        String slug = articleDto.getTitle().toLowerCase().trim()
                .replaceAll("\\s+", "-");
        Article newArticle = new Article
                .ArticleBuilder(
                        articleDto.getTitle(),
                        articleDto.getDescription(),
                        articleDto.getBody(),
                        articleDto.getTags())
                        .setSlug(slug)
                        .setCreatedTime(createdDate).setFavoritedCount(0).build();
        Article createdArticle = articleRepository.save(newArticle);
        return  new ArticleDto(createdArticle);

    }
    @Transactional
    public ArticleDto getArticleBySlug(String slug){
        Article article = getArticleEntityBySlug(slug);

        return new ArticleDto(article);
    }

    public Article getArticleEntityBySlug(String slug){
        return articleRepository.findBySlug(slug).orElseThrow(() -> new NoSuchElementException("Article not found"));
    }

    @Transactional
    public List<ArticleDto> getAllArticles(){
        List<Article> articles = articleRepository.findAll();

        List<ArticleDto> articleList = articles.stream().map(
                article -> new ArticleDto(article.getTitle(),article.getSlug(),
                article.getDescription(),article.getBody(), article.getTags(), new ProfileDto(article.getCreator())))
                .collect(Collectors.toList());

        return articleList;
    }

    @Transactional
    public void deleteArticleBySlug(String slug){
        Article article = articleRepository.findBySlug(slug).orElseThrow(() ->
                new NoSuchElementException("Article not found"));
/*
        if (!article.getCreator().equals(user))
            throw new IllegalArgumentException("You can not delete articles written by other authors.");
        else
*/
        articleRepository.delete(article);
    }

}

