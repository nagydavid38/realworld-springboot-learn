package com.demo.realWorld.controller;

import com.demo.realWorld.controller.dtos.CommentDto;
import com.demo.realWorld.controller.dtos.CreateCommentRequestDto;
import com.demo.realWorld.controller.dtos.MultipleCommentDto;
import com.demo.realWorld.controller.dtos.SingleCommentDto;
import com.demo.realWorld.model.Comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/articles/{slug}/comments")
    public SingleCommentDto addCommentToArticle(@PathVariable String slug, @RequestBody CreateCommentRequestDto request){
        CommentDto commentDto = commentService.addCommentToArticle(slug, request);
        return new SingleCommentDto(commentDto);
    }
}
