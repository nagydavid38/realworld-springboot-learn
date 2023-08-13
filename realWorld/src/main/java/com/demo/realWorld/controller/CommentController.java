package com.demo.realWorld.controller;

import com.demo.realWorld.controller.dtos.CommentDto;
import com.demo.realWorld.controller.dtos.MultipleCommentDto;
import com.demo.realWorld.model.Comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/articles/{slug}/comments")
    public MultipleCommentDto getCommentsForArticle(@PathVariable String slug){
        List<CommentDto> commentDtos = commentService.getCommentsForArticle(slug);
        return new MultipleCommentDto(commentDtos);
    }
}
