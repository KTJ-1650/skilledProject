package com.sparta.skilledproject.repository;

import com.sparta.skilledproject.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
    Page<Schedule> findByOrderByUpdatedAtDesc(Pageable pageable);
}
