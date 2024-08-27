package com.sparta.skilledproject.controller;


import com.sparta.skilledproject.dto.RequestDto;
import com.sparta.skilledproject.dto.ResponseDto;
import com.sparta.skilledproject.entity.Schedule;
import com.sparta.skilledproject.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

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

    //페이지네이션 스케쥴 조회
    @GetMapping
    public Page<ResponseDto> getSchedules(Pageable pageable) {
        return scheduleService.getSchedules(pageable);
    }

    //일정삭제하면 댓글도 같이 삭제
    @DeleteMapping("/delete/{id}")
    public ResponseDto deleteSchedule(@PathVariable Long id) {
        return scheduleService.deleteSchedule(id);
    }
}