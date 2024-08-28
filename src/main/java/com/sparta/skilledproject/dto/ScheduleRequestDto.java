package com.sparta.skilledproject.dto;

import com.sparta.skilledproject.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ScheduleRequestDto {

    private Long scheduleId;

    private User user;
    private String username;
    private String title;
    private String content;


    public ScheduleRequestDto(){

    }
}
