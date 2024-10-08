package com.demo.realWorld.model.Article;

import com.demo.realWorld.model.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name= "article")
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID iD;

    String title;
    @Column(unique = true)
    String slug;
    String description;
    String body;
    List<String> tags;

    @JoinColumn(name = "CREATOR_ID")
    @ManyToOne
    User creator;
    LocalDateTime createdTime;

    LocalDateTime updatedTime;
    Integer favoritedCount;
}
