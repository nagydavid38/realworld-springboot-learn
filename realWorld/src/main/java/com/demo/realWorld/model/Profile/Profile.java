package com.demo.realWorld.model.Profile;

import com.demo.realWorld.model.Article.Article;
import com.demo.realWorld.model.Comment.Comment;
import jakarta.persistence.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Table(name = "profile")
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID iD;
    String userName;
    String bio;
    String image;
    @ManyToMany
    List<Profile> followers;
    @OneToMany(mappedBy = "creator")
    List<Article> articles;
    @OneToMany(mappedBy = "profile")
    List<Comment> comments;

    public UUID getiD() {
        return iD;
    }

    public void setiD(UUID iD) {
        this.iD = iD;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Profile> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Profile> followers) {
        this.followers = followers;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}
