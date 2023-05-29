package com.demo.realWorld.model.Article;

import com.demo.realWorld.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, String> {
    Article findByTitle(String title);
    List<Article> findByCreator(User user);
}
