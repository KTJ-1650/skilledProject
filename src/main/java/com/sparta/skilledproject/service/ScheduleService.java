package com.sparta.skilledproject.service;

import com.sparta.skilledproject.dto.ScheduleRequestDto;
import com.sparta.skilledproject.dto.ScheduleResponseDto;
import com.sparta.skilledproject.entity.Schedule;
import com.sparta.skilledproject.repository.CommentRepository;
import com.sparta.skilledproject.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    //저장
    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = new Schedule();
        schedule.setUser(scheduleRequestDto.getUser());

        schedule.setTitle(scheduleRequestDto.getTitle());
        schedule.setContent(scheduleRequestDto.getContent());

        return new ScheduleResponseDto(scheduleRepository.save(schedule));
    }
    //조회
    public ScheduleResponseDto getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        return new ScheduleResponseDto(scheduleRepository.save(schedule));
    }

    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto scheduleRequestDto) {
    //수정
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        schedule.setUser(scheduleRequestDto.getUser());

        schedule.setTitle(scheduleRequestDto.getTitle());
        schedule.setContent(scheduleRequestDto.getContent());
        return new ScheduleResponseDto(scheduleRepository.save(schedule));
    }

    // 페이지네이션 처리된 스케줄 조회
    public Page<ScheduleResponseDto> getSchedules(Pageable pageable) {
        return scheduleRepository.findByOrderByUpdatedAtDesc(pageable)
                .map(ScheduleResponseDto::new);

        }

    // 삭제
    public ScheduleResponseDto deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        scheduleRepository.delete(schedule);
        // 댓글도 삭제할 필요가 없으므로 단순히 일정을 삭제하면 댓글도 함께 삭제됨
        return new ScheduleResponseDto(schedule);
    }
}
