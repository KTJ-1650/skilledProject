package com.sparta.skilledproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Assign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "assign_id")
    private Long assignId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // 담당 유저

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule; // 담당 스케줄
//유저와 담당은 일대 다 ,  담당하고 스케쥴은 다대 일 관계

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;


    public Assign(User user, Schedule schedule) {
        this.user = user;
        this.schedule = schedule;
    }
}
