package com.binayak.family_management_system.service;

import com.binayak.family_management_system.dto.Response.EventResponse;
import com.binayak.family_management_system.dto.request.EventRequest;

import java.util.List;

public interface EventService {
    EventResponse saveEvent(EventRequest request);

    List<EventResponse> getAllEvents(int userId);

    EventResponse getEventById(Long eventId);
}
