package com.binayak.family_management_system.repo;

import com.binayak.family_management_system.entity.Event;
import com.binayak.family_management_system.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepo extends JpaRepository<Event, Long> {
    List<Event> findAllByUser(Users users);
}
