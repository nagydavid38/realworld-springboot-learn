package com.demo.realWorld.model.Comment;

import com.demo.realWorld.controller.dtos.ArticleDto;
import com.demo.realWorld.controller.dtos.CommentDto;
import com.demo.realWorld.controller.dtos.ProfileDto;
import com.demo.realWorld.model.Article.Article;
import com.demo.realWorld.model.Article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private ArticleService articleService;
    @Autowired
    public CommentService(CommentRepository commentRepository, ArticleService articleService) {
        this.commentRepository = commentRepository;
        this.articleService = articleService;
    }


    public List<CommentDto> getCommentsForArticle(String slug){
        Article article = articleService.getArticleEntityBySlug(slug);
        if(article != null) //TODO write proper exception handling for not found articles
        {
            return commentRepository.findAllCommentsByArticle(article).stream().map(comment ->
                            new CommentDto(comment.getId(), comment.getCreatedAt(), comment.getUpdatedAt(), comment.getContent(), new ProfileDto(comment.getProfile())))
                    .toList();
        }
        else{
            throw new NullPointerException("Article not found");
        }

    }
}
