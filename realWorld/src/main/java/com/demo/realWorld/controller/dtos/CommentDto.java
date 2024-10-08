package com.demo.realWorld.controller.dtos;

import com.demo.realWorld.model.Comment.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class CommentDto {
    UUID id;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    String body;
    ProfileDto author;

    public CommentDto(Comment comment){
        this.id = comment.getId();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();
        this.body = comment.getContent();
        this.author = new ProfileDto(comment.getUser());
    }
}
