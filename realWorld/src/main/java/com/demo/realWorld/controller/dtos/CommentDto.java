package com.demo.realWorld.controller.dtos;

import com.demo.realWorld.model.Comment.Comment;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

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
        this.author = new ProfileDto(comment.getProfile());
    }
    public CommentDto(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String body, ProfileDto author) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.body = body;
        this.author = author;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ProfileDto getAuthor() {
        return author;
    }

    public void setAuthor(ProfileDto author) {
        this.author = author;
    }
}
