package com.binayak.family_management_system.controller;

import com.binayak.family_management_system.dto.Response.EventResponse;
import com.binayak.family_management_system.dto.request.EventRequest;
import com.binayak.family_management_system.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping
    private ResponseEntity<EventResponse> saveEvent(@RequestBody EventRequest request) {
        return ResponseEntity.ok(eventService.saveEvent(request));
    }

    @GetMapping
    private ResponseEntity<List<EventResponse>> getEventById(@RequestParam int userId) {
        return ResponseEntity.ok(eventService.getAllEvents(userId));
    }

    @GetMapping("/{eventId}")
    private ResponseEntity<EventResponse> getEventByIdPath(@PathVariable Long eventId) {
        return ResponseEntity.ok(eventService.getEventById(eventId));
    }

}
