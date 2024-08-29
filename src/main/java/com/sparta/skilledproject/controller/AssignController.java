package com.sparta.skilledproject.controller;

import com.sparta.skilledproject.dto.AssignRequestDto;
import com.sparta.skilledproject.dto.AssignResponseDto;
import com.sparta.skilledproject.service.AssignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assingn")
@RequiredArgsConstructor
public class AssignController {

    private final AssignService assignService;

    //
    @PostMapping
    public AssignResponseDto assignUserToSchedule(@RequestBody AssignRequestDto assignRequestDto) {
        return assignService.assignUserToSchedule(assignRequestDto);
    }
}
