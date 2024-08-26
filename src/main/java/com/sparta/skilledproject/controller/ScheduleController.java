package com.sparta.skilledproject.controller;


import com.sparta.skilledproject.dto.RequestDto;
import com.sparta.skilledproject.dto.ResponseDto;
import com.sparta.skilledproject.entity.Schedule;
import com.sparta.skilledproject.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private ScheduleService scheduleService;

    //저장
    @PostMapping
    public ResponseDto createSchedule(@RequestBody RequestDto requestDto){

        return scheduleService.createSchedule(requestDto);
    }

    //단건 조회
    @GetMapping("/{id}")
    public ResponseDto getScheduleById(@PathVariable Long id){

        return scheduleService.getScheduleById(id);
    }

    //수정
    @PutMapping("/{id}")
    public ResponseDto updateSchedule(@PathVariable Long id ,@RequestBody RequestDto requestDto){

        return  scheduleService.updateSchedule(id,requestDto);
    }

    Schedule schedule = new Schedule()
}
