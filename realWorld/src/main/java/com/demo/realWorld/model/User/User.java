package com.demo.realWorld.model.User;

import com.demo.realWorld.model.Article.Article;
import com.demo.realWorld.model.Comment.Comment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public User(UserBuilder builder){
        this.bio = builder.bio;
        this.articles = builder.articles;
        this.image = builder.image;
        this.comments = builder.comments;
        this.following = builder.following;
        this.userName = builder.userName;
        this.password = builder.password;
    }
}
