package com.demo.realWorld.model.Comment;

import com.demo.realWorld.model.Article.Article;
import com.demo.realWorld.model.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "comments")
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String content;
    @JoinColumn(name = "USER_ID")
    @ManyToOne
    private User user;
    @JoinColumn(name = "ARTICLE_ID")
    @ManyToOne
    private Article article;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
