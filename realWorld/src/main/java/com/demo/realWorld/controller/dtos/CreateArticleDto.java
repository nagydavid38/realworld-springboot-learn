package com.demo.realWorld.controller.dtos;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName("article")
public record CreateArticleDto(String title, String description, String body, List<String> tagList) {
}
