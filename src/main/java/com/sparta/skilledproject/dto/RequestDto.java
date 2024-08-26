package com.sparta.skilledproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestDto {

    private String username;
    private String title;
    private String content;

}
