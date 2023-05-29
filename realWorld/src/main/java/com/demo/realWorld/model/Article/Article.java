package com.demo.realWorld.model.Article;

import com.demo.realWorld.model.Profile.Profile;
import jakarta.persistence.*;

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

    @ManyToOne
    Profile creator;
    Integer favoritedCount;

    public UUID getiD() {
        return iD;
    }

    public void setiD(UUID iD) {
        this.iD = iD;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Profile getCreator() {
        return creator;
    }

    public void setCreator(Profile creator) {
        this.creator = creator;
    }

    public Integer getFavoritedCount() {
        return favoritedCount;
    }

    public void setFavoritedCount(Integer favoritedCount) {
        this.favoritedCount = favoritedCount;
    }
}
