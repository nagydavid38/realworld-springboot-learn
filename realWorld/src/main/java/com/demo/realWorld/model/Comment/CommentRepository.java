package com.demo.realWorld.model.Comment;

import com.demo.realWorld.model.Article.Article;
import com.demo.realWorld.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, String> {
    List<Comment> findAllCommentsByPost(Article article);
    List<Comment> findAllByUser(User user);
    List<Comment> findAllCommentsByComment(Comment comment);

}
