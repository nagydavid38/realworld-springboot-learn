package com.demo.realWorld.controller.dtos;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("comment")
public record CreateCommentRequestDto(String body){}