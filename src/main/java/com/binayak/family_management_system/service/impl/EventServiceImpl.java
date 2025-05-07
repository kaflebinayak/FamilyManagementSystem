package com.binayak.family_management_system.service.impl;

import com.binayak.family_management_system.dto.Response.EventResponse;
import com.binayak.family_management_system.dto.request.EventRequest;
import com.binayak.family_management_system.entity.Event;
import com.binayak.family_management_system.entity.Users;
import com.binayak.family_management_system.repo.EventRepo;
import com.binayak.family_management_system.repo.UserRepo;
import com.binayak.family_management_system.service.EventService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService {
    private final EventRepo eventRepo;
    private final UserRepo userRepo;

    @Override
    public EventResponse saveEvent(EventRequest request) {
        Users users = userRepo.findById(request.getUserId())
                .orElseThrow(()-> new RuntimeException("User not found"));
        Event event = new Event();
        event.setEventName(request.getEventName());
//        event.setEventDescription(request.getEventDescription());
        event.setEventDate(request.getEventDate());
        event.setUser(users);
        return new EventResponse(eventRepo.save(event));
    }

    @Override
    public List<EventResponse> getAllEvents(int userId) {
        Users users = userRepo.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found"));
        List<Event> events = eventRepo.findAllByUser(users);
        return events.stream().map(EventResponse::new).toList();
    }

    @Override
    public EventResponse getEventById(Long eventId) {
        Event event = eventRepo.findById(eventId)
                .orElseThrow(()-> new RuntimeException("Event not found"));
        return new EventResponse(event);
    }
}
