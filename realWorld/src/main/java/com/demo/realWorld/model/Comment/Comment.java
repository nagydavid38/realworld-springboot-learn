package com.demo.realWorld.model.Comment;

import com.demo.realWorld.model.Article.Article;
import com.demo.realWorld.model.User.User;
import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "comments")
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String content;
    @ManyToOne
    User user;
    @ManyToOne
    Article article;

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
}
