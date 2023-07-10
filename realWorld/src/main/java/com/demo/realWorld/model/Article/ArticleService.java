package com.demo.realWorld.model.Article;

import com.demo.realWorld.controller.dtos.ArticleDto;
import com.demo.realWorld.controller.dtos.DtoMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    DtoMapper mapper = new DtoMapper();

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
        Article newArticle = new Article.ArticleBuilder(articleDto.getTitle(),
                            articleDto.getDescription(), articleDto.getBody(), articleDto.getTags())
                            .setSlug(slug)
                            .setCreatedTime(createdDate).setFavoritedCount(0).build();
        Article createdArticle = articleRepository.save(newArticle);
        return  mapper.toArticleDto(createdArticle);

    }
    @Transactional
    public ArticleDto getArticleBySlug(String slug){
        ArticleDto dto = null;
        try{
            dto = new ArticleDto(articleRepository.findBySlug(slug));
            return dto;
        } catch (NullPointerException exception){
            exception.printStackTrace();
        }
        return dto;
    }

    @Transactional
    public List<ArticleDto> getAllArticles(){
        List<Article> articles = articleRepository.findAll();

        List<ArticleDto> articleList = articles.stream().map(
                article -> new ArticleDto(article.getTitle(),article.getSlug(),
                article.getDescription(),article.getBody(), article.getTags()))
                .collect(Collectors.toList());

        return articleList;
    }

    public Boolean deleteArticleBySlug(String slug){
        Article article = articleRepository.findBySlug(slug);
        if (article != null){
            articleRepository.delete(article);
            return true;
        }
        else{
            return false;
        }
    }

}

