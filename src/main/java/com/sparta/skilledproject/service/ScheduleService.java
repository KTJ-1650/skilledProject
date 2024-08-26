package com.sparta.skilledproject.service;

import com.sparta.skilledproject.dto.RequestDto;
import com.sparta.skilledproject.dto.ResponseDto;
import com.sparta.skilledproject.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    private ScheduleRepository scheduleRepository;
    //저장
    public ResponseDto createSchedule(RequestDto requestDto) {
    }
    //조회
    public ResponseDto getScheduleById(Long id) {
    }

    public ResponseDto updateSchedule(Long id, RequestDto requestDto) {
    }
}
