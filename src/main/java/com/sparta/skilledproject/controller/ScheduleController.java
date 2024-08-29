package com.sparta.skilledproject.controller;


import com.sparta.skilledproject.dto.ScheduleRequestDto;
import com.sparta.skilledproject.dto.ScheduleResponseDto;
import com.sparta.skilledproject.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    //저장
    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto){

        return scheduleService.createSchedule(scheduleRequestDto);
    }

    //단건 조회
    @GetMapping("/{id}")
    public ScheduleResponseDto getScheduleById(@PathVariable Long id){

        return scheduleService.getScheduleById(id);
    }

    //수정
    @PutMapping("/{id}")
    public ScheduleResponseDto updateSchedule(@PathVariable Long id , @RequestBody ScheduleRequestDto scheduleRequestDto){

        return  scheduleService.updateSchedule(id, scheduleRequestDto);
    }


    //페이지네이션 스케쥴 조회
//    @GetMapping
//    public Page<ScheduleResponseDto> getSchedules(Pageable pageable) {
//        return scheduleService.getSchedules(pageable);
//    }

    //일정삭제하면 댓글도 같이 삭제
    @DeleteMapping("/delete/{id}")
    public ScheduleResponseDto deleteSchedule(@PathVariable Long id) {
        return scheduleService.deleteSchedule(id);
    }
}