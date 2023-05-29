package com.demo.realWorld.model.Comment;

import com.demo.realWorld.model.Article.Article;
import com.demo.realWorld.model.User.User;

import java.util.List;

public class Comment {
    String iD;
    String content;
    User commentBy;
    List<Comment> comments;
    Article articleCommentedOn;
}
