package com.sparta.skilledproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommentRequestDto {

    private Long commentId;
    private String author;
    private String content;
}
