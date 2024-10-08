package com.demo.realWorld.model.Comment;

import com.demo.realWorld.controller.dtos.CommentDto;
import com.demo.realWorld.controller.dtos.CreateCommentRequestDto;
import com.demo.realWorld.controller.dtos.ProfileDto;
import com.demo.realWorld.model.Article.Article;
import com.demo.realWorld.model.Article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ArticleService articleService;
    @Autowired
    public CommentService(CommentRepository commentRepository, ArticleService articleService) {
        this.commentRepository = commentRepository;
        this.articleService = articleService;
    }


    @Transactional
    public List<CommentDto> getCommentsForArticle(String slug){
        Article article = articleService.getArticleEntityBySlug(slug);

        return commentRepository.findAllCommentsByArticle(article).
                stream().map(comment ->
                         new CommentDto(
                                 comment.getId(),
                                 comment.getCreatedAt(),
                                 comment.getUpdatedAt(),
                                 comment.getContent(),
                                 new ProfileDto(comment.getUser())))
                                 .toList();

    }

    @Transactional
    public CommentDto addCommentToArticle(String slug, CreateCommentRequestDto request){
        Article article = articleService.getArticleEntityBySlug(slug);
        Comment comment = Comment.builder().content(request.body()).article(article).build();

        return new CommentDto(comment);
    }
}
