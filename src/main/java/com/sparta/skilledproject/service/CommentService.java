package com.sparta.skilledproject.service;

import com.sparta.skilledproject.dto.CommentRequestDto;
import com.sparta.skilledproject.dto.CommentResponseDto;
import com.sparta.skilledproject.entity.Comment;
import com.sparta.skilledproject.entity.Schedule;
import com.sparta.skilledproject.repository.CommentRepository;
import com.sparta.skilledproject.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;
    // 댓글 저장
    public CommentResponseDto createComment(Long scheduleId, CommentRequestDto commentRequestDto) {

        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        Comment comment = new Comment();

       comment.setAuthor(commentRequestDto.getAuthor());


        comment.setContent(commentRequestDto.getContent());
        comment.setSchedule(schedule);

        return new CommentResponseDto(commentRepository.save(comment));
    }

    // 단건 조회
    public CommentResponseDto getCommentById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        return new CommentResponseDto(comment);
    }

    // 전체 조회
    public List<CommentResponseDto> getCommentsByScheduleId(Long scheduleId) {
        Schedule foundScheudle = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        List<Comment> comments = commentRepository.findBySchedule(foundScheudle);
        return comments.stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }

    // 수정
    public CommentResponseDto updateComment(Long id, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));


        comment.setAuthor(commentRequestDto.getAuthor());

        comment.setContent(commentRequestDto.getContent());

        return new CommentResponseDto(commentRepository.save(comment));
    }

    // 삭제
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}