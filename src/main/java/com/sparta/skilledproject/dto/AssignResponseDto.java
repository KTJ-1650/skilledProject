package com.sparta.skilledproject.dto;

import com.sparta.skilledproject.entity.Assign;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AssignResponseDto {
    private Long assignId;
    private Long userId;
    private Long scheduleId;

    public AssignResponseDto(Assign assign) {
        this.assignId = assign.getAssignId();
        this.userId = assign.getUser().getUserId();
        this.scheduleId = assign.getSchedule().getScheduleId();
    }
}
