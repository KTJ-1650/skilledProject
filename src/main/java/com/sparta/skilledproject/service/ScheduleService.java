package com.sparta.skilledproject.service;

import com.sparta.skilledproject.dto.RequestDto;
import com.sparta.skilledproject.dto.ResponseDto;
import com.sparta.skilledproject.entity.Schedule;
import com.sparta.skilledproject.repository.CommentRepository;
import com.sparta.skilledproject.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    //저장
    public ResponseDto createSchedule(RequestDto requestDto) {
        Schedule schedule = new Schedule();
        schedule.setUsername(requestDto.getUsername());
        schedule.setTitle(requestDto.getTitle());
        schedule.setContent(requestDto.getContent());

        return new ResponseDto(scheduleRepository.save(schedule));
    }
    //조회
    public ResponseDto getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        return new ResponseDto(scheduleRepository.save(schedule));
    }

    public ResponseDto updateSchedule(Long id, RequestDto requestDto) {
    //수정
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        schedule.setUsername(requestDto.getUsername());
        schedule.setTitle(requestDto.getTitle());
        schedule.setContent(requestDto.getContent());
        return new ResponseDto(scheduleRepository.save(schedule));
    }

    // 페이지네이션 처리된 스케줄 조회
    public Page<ResponseDto> getSchedules(Pageable pageable) {
        return scheduleRepository.findByOrderByUpdatedAtDesc(pageable)
                .map(ResponseDto::new);

        }

    // 삭제
    public ResponseDto deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        scheduleRepository.delete(schedule);
        // 댓글도 삭제할 필요가 없으므로 단순히 일정을 삭제하면 댓글도 함께 삭제됨
        return new ResponseDto(schedule);
    }
}
