package com.sparta.skilledproject.service;

import com.sparta.skilledproject.dto.RequestDto;
import com.sparta.skilledproject.dto.ResponseDto;
import com.sparta.skilledproject.entity.Schedule;
import com.sparta.skilledproject.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    //저장
    public ResponseDto createSchedule(RequestDto requestDto) {
        Schedule schedule = new Schedule();
        schedule.setUsername(requestDto.getUsername());
        schedule.setTitle(requestDto.getTitle());
        schedule.setContent(requestDto.getContent());

        scheduleRepository.save(schedule);

        ResponseDto responseDto = new ResponseDto();
        responseDto.setId(schedule.getId());
        responseDto.setUsername(schedule.getUsername());
        responseDto.setTitle(schedule.getTitle());
        responseDto.setContent(schedule.getContent());


        return responseDto;
    }
    //조회
    public ResponseDto getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        // 조회된 Schedule 엔티티를 ResponseDto로 변환하여 반환
        ResponseDto responseDto = new ResponseDto();
        responseDto.setId(schedule.getId());
        responseDto.setUsername(schedule.getUsername());
        responseDto.setTitle(schedule.getTitle());
        responseDto.setContent(schedule.getContent());
        responseDto.setCreatedAt(schedule.getCreatedAt());
        responseDto.setUpdatedAt(schedule.getUpdatedAt());

        return responseDto;
    }

    public ResponseDto updateSchedule(Long id, RequestDto requestDto) {
// ID로 기존 Schedule 엔티티를 조회
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        // RequestDto로부터 받은 새로운 데이터로 Schedule 엔티티를 업데이트
        schedule.setTitle(requestDto.getTitle());
        schedule.setContent(requestDto.getContent());
        schedule.setUpdatedAt(LocalDateTime.now());

        // 업데이트된 Schedule 엔티티를 데이터베이스에 저장
        scheduleRepository.save(schedule);

        // 업데이트된 데이터를 ResponseDto로 변환하여 반환
        ResponseDto responseDto = new ResponseDto();
        responseDto.setId(schedule.getId());
        responseDto.setUsername(schedule.getUsername());
        responseDto.setTitle(schedule.getTitle());
        responseDto.setContent(schedule.getContent());
        responseDto.setCreatedAt(schedule.getCreatedAt());
        responseDto.setUpdatedAt(schedule.getUpdatedAt());

        return responseDto;
    }
}
