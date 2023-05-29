package com.demo.realWorld.model.Article;

import com.demo.realWorld.model.Profile.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ArticleRepository extends JpaRepository<Article, UUID> {
    Article findByTitle(String title);
    List<Article> findByCreator(Profile profile);
}
