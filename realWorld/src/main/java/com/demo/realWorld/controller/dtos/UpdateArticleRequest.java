package com.demo.realWorld.controller.dtos;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("article")
public class UpdateArticleRequest {
    String title;
    String description;
    String body;

    public UpdateArticleRequest(String title, String description, String body) {
        this.title = title != null ? title : "";
        this.description = description != null ? description : "";
        this.body = body != null ? body : "";
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getBody() {
        return body;
    }
}
