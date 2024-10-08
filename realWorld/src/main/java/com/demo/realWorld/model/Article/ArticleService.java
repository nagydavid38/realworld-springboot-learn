package com.demo.realWorld.model.Article;

import com.demo.realWorld.controller.dtos.ArticleDto;
import com.demo.realWorld.controller.dtos.CreateArticleDto;
import com.demo.realWorld.controller.dtos.ProfileDto;
import com.demo.realWorld.controller.dtos.UpdateArticleRequest;
import com.demo.realWorld.exception.ArticleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Transactional
    public ArticleDto createArticle(CreateArticleDto articleDto){
        LocalDateTime createdDate = LocalDateTime.now();
        String slug = articleDto.title().toLowerCase().trim()
                .replaceAll("\\s+", "-");
        Article newArticle = Article.builder().
                title(articleDto.title())
                .description(articleDto.description())
                .body(articleDto.body())
                .tags(articleDto.tagList())
                .slug(slug)
                .createdTime(createdDate)
                .updatedTime(createdDate)
                .favoritedCount(0)
                .build();
        Article createdArticle = articleRepository.save(newArticle);
        return  new ArticleDto(createdArticle);
    }

    @Transactional
    public ArticleDto updateArticle(UpdateArticleRequest request, String slug){
        Article article = getArticleEntityBySlug(slug);
        if(!request.getBody().equals(""))
            article.setBody(request.getBody());
        if(!request.getDescription().equals(""))
            article.setDescription(request.getDescription());
        if(!request.getTitle().equals(""))
            article.setTitle(request.getTitle());
        articleRepository.save(article); //save method is not necessary here, because of transactional TODO - write test method for it
        return new ArticleDto(article);
    }
    @Transactional
    public ArticleDto getArticleBySlug(String slug){
        Article article = getArticleEntityBySlug(slug);

        return new ArticleDto(article);
    }

    public Article getArticleEntityBySlug(String slug){
        return articleRepository.findBySlug(slug).orElseThrow(() -> new ArticleNotFoundException("Article not found"));
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
                new ArticleNotFoundException("Article not found"));
/*
        if (!article.getCreator().equals(user))
            throw new IllegalArgumentException("You can not delete articles written by other authors.");
        else
*/
        articleRepository.delete(article);
    }

}

