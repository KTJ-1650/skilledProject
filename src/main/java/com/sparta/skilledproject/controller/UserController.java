package com.sparta.skilledproject.controller;

import com.sparta.skilledproject.dto.UserRequestDto;
import com.sparta.skilledproject.dto.UserResponseDto;
import com.sparta.skilledproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
//저장
    @PostMapping("/post")
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }
//id 단건 조회
    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
//전체 조회
    @GetMapping("/get")
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }
//삭제
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}