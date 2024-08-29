package com.sparta.skilledproject.service;

import com.sparta.skilledproject.dto.AssignRequestDto;
import com.sparta.skilledproject.dto.AssignResponseDto;
import com.sparta.skilledproject.entity.Assign;
import com.sparta.skilledproject.entity.Schedule;
import com.sparta.skilledproject.entity.User;
import com.sparta.skilledproject.repository.AssignRepository;
import com.sparta.skilledproject.repository.ScheduleRepository;
import com.sparta.skilledproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class AssignService {
    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;
    private final AssignRepository assignRepository;


    public AssignResponseDto assignUserToSchedule(AssignRequestDto assignRequestDto) {

       User userFound = userRepository.findById(assignRequestDto.getUserId())
                .orElseThrow(()->new RuntimeException("User not found"));

      Schedule scheduleFound = scheduleRepository.findById(assignRequestDto.getScheduleId())
               .orElseThrow(()-> new RuntimeException("Schedule not found"));

        Assign assign = new Assign(userFound,scheduleFound);

        return new AssignResponseDto(assignRepository.save(assign));

    }
}
