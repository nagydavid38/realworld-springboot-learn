package com.demo.realWorld.model.Comment;

import com.demo.realWorld.model.Article.Article;
import com.demo.realWorld.model.User.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "comments")
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String content;
    @ManyToOne
    private User user;
    @ManyToOne
    private Article article;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    private Comment(){}

    private Comment(CommentBuilder commentBuilder){
        this.id = commentBuilder.id;
        this.content = commentBuilder.content;
        this.user = commentBuilder.user;
        this.article = commentBuilder.article;
        this.createdAt = commentBuilder.createdAt;
        this.updatedAt = commentBuilder.updatedAt;
    }

    public static class CommentBuilder{
        UUID id;
        String content;
        User user;
        Article article;
        LocalDateTime createdAt;
        LocalDateTime updatedAt;

        public CommentBuilder() {
        }

        public CommentBuilder(UUID id, String content, User user, Article article, LocalDateTime createdAt, LocalDateTime updatedAt) {
            this.id = id;
            this.content = content;
            this.user = user;
            this.article = article;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public void setArticle(Article article) {
            this.article = article;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public void setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Comment build(){
            return new Comment(this);
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getProfile() {
        return user;
    }

    public void setProfile(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
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
}
