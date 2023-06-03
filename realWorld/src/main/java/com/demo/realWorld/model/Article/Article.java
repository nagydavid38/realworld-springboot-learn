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

    private Article(ArticleBuilder builder) {
        this.iD = builder.iD;
        this.title = builder.title;
        this.slug = builder.slug;
        this.description = builder.description;
        this.body = builder.body;
        this.tags = builder.tags;
        this.creator = builder.creator;
        this.favoritedCount = builder.favoritedCount;
    }

    public static class ArticleBuilder{
        UUID iD;
        String title;
        String slug;
        String description;
        String body;
        List<String> tags;
        Profile creator;
        Integer favoritedCount;

        public ArticleBuilder(UUID iD, String title, String slug, String description, String body, List<String> tags, Profile creator, Integer favoritedCount) {
            this.iD = iD;
            this.title = title;
            this.slug = slug;
            this.description = description;
            this.body = body;
            this.tags = tags;
            this.creator = creator;
            this.favoritedCount = favoritedCount;
        }

        public ArticleBuilder setiD(UUID iD) {
            this.iD = iD;
            return this;
        }

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

        public ArticleBuilder setCreator(Profile creator) {
            this.creator = creator;
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

    public Profile getCreator() {
        return creator;
    }

    public Integer getFavoritedCount() {
        return favoritedCount;
    }

    @Override
    public String toString() {
        return "Article{" +
                "iD=" + iD +
                ", title='" + title + '\'' +
                ", slug='" + slug + '\'' +
                ", description='" + description + '\'' +
                ", body='" + body + '\'' +
                ", tags=" + tags +
                ", creator=" + creator +
                ", favoritedCount=" + favoritedCount +
                '}';
    }
}
