package com.sparta.skilledproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class RequestDto {
    private Long id;
    private String username;
    private String title;
    private String content;
    private LocalDateTime createdAt;  // 생성일 포함
    private LocalDateTime updatedAt;

    public RequestDto(){

    }
}
