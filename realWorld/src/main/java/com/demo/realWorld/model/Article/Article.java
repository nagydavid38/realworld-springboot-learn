package com.demo.realWorld.model.Article;

import com.demo.realWorld.model.User.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Table(name= "article")
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID iD;

    String title;
    String slug;
    String description;
    String body;
    List<String> tags;

    @JoinColumn(name = "CREATOR_ID")
    @ManyToOne
    User creator;
    LocalDateTime createdTime;
    Integer favoritedCount;

    private Article() {}
    private Article(ArticleBuilder builder) {
        this.title = builder.title;
        this.slug = builder.slug;
        this.description = builder.description;
        this.body = builder.body;
        this.tags = builder.tags;
        this.creator = builder.creator;
        this.favoritedCount = builder.favoritedCount;
    }

    public static class ArticleBuilder{
        String title;
        String slug;
        String description;
        String body;
        List<String> tags;
        User creator;
        LocalDateTime createdTime;
        Integer favoritedCount;

        public ArticleBuilder(String title, String slug, String description, String body, List<String> tags, User creator, Integer favoritedCount) {
            this.title = title;
            this.slug = slug;
            this.description = description;
            this.body = body;
            this.tags = tags;
            this.creator = creator;
            this.favoritedCount = favoritedCount;
        }
        public ArticleBuilder (String title, String description, String body, List<String> tagList){
            this.title = title;
            this.description = description;
            this.body = body;
            this.tags = tagList;
        }
        public ArticleBuilder(){}

        public ArticleBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public ArticleBuilder setSlug(String slug) {
            this.slug = slug;
            return this;
        }

        public ArticleBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ArticleBuilder setBody(String body) {
            this.body = body;
            return this;
        }

        public ArticleBuilder setTags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public ArticleBuilder setCreator(User creator) {
            this.creator = creator;
            return this;
        }

        public ArticleBuilder setCreatedTime(LocalDateTime createdTime) {
            this.createdTime = createdTime;
            return this;
        }

        public ArticleBuilder setFavoritedCount(Integer favoritedCount) {
            this.favoritedCount = favoritedCount;
            return this;
        }

        public Article build(){
            return new Article(this);
        }
    }

    public UUID getiD() {
        return iD;
    }

    public String getTitle() {
        return title;
    }

    public String getSlug() {
        return slug;
    }

    public String getDescription() {
        return description;
    }

    public String getBody() {
        return body;
    }

    public List<String> getTags() {
        return tags;
    }

    public User getCreator() {
        return creator;
    }

    public Integer getFavoritedCount() {
        return favoritedCount;
    }

}
