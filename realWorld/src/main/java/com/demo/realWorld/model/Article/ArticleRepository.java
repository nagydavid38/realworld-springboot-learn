package com.demo.realWorld.model.Article;

import com.demo.realWorld.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ArticleRepository extends JpaRepository<Article, UUID> {
    Article findByTitle(String title);
    List<Article> findByCreator(User user);

    Optional<Article> findBySlug(String slug);
}
