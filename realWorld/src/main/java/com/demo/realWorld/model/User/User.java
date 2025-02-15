package com.demo.realWorld.model.User;

import com.demo.realWorld.model.Article.Article;
import com.demo.realWorld.model.Comment.Comment;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Table(name = "`user`")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID iD;

    String password;
    @Column(unique = true)
    String userName;
    String bio;
    String image;
    @ManyToMany
    List<User> following;
    @OneToMany(mappedBy = "creator")
    List<Article> articles;
    @OneToMany(mappedBy = "user")
    List<Comment> comments;

    private User() {
    }

    public static class UserBuilder {
        String password;
        String userName;
        String bio;
        String image;
        List<User> following;
        List<Article> articles;
        List<Comment> comments;

        public UserBuilder(){}

        public UserBuilder(String password, String userName, String bio, String image, List<User> following, List<Article> articles, List<Comment> comments) {
            this.password = password;
            this.userName = userName;
            this.bio = bio;
            this.image = image;
            this.following = following;
            this.articles = articles;
            this.comments = comments;
        }
        public void setPassword(String password) {
            this.password = password;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public void setFollowing(List<User> following) {
            this.following = following;
        }

        public void setArticles(List<Article> articles) {
            this.articles = articles;
        }

        public void setComments(List<Comment> comments) {
            this.comments = comments;
        }

        public User build () {
            return new User(this);
        }
    }

    public User(UserBuilder builder){
        this.bio = builder.bio;
        this.articles = builder.articles;
        this.image = builder.image;
        this.comments = builder.comments;
        this.following = builder.following;
        this.userName = builder.userName;
        this.password = builder.password;
    }

    public UUID getiD() {
        return iD;
    }

    public void setiD(UUID iD) {
        this.iD = iD;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
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
