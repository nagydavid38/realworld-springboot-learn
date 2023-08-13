package com.demo.realWorld.controller.dtos;

import java.util.List;

public record MultipleCommentDto(List<CommentDto> commentDtoList) {
}
