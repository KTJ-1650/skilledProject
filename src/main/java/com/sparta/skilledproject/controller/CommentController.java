package com.sparta.skilledproject.controller;

import com.sparta.skilledproject.dto.CommentRequestDto;
import com.sparta.skilledproject.dto.CommentResponseDto;
import com.sparta.skilledproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 저장
    @PostMapping("/{scheduleId}")
    public CommentResponseDto createComment(@PathVariable Long scheduleId, @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.createComment(scheduleId, commentRequestDto);
    }

    // 단건 조회
    @GetMapping("/get/{id}")
    public CommentResponseDto getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    // 전체 조회 (특정 일정의 모든 댓글)
    @GetMapping("/full/{scheduleId}")
    public List<CommentResponseDto> getCommentsByScheduleId(@PathVariable Long scheduleId) {
        return commentService.getCommentsByScheduleId(scheduleId);
    }

    // 수정
    @PutMapping("/put/{id}")
    public CommentResponseDto updateComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.updateComment(id, commentRequestDto);
    }

    // 삭제
    @DeleteMapping("/delete/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}