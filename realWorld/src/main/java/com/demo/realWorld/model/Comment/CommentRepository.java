package com.demo.realWorld.model.Comment;

import com.demo.realWorld.model.Article.Article;
import com.demo.realWorld.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findAllCommentsByArticle(Article article);
    List<Comment> findAllByUser(User User);

}
