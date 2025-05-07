package com.binayak.family_management_system.dto.Response;

import com.binayak.family_management_system.entity.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventResponse {
    private Long id;
    private String eventName;
    private String eventDescription;
    private LocalDate eventDate;

    public EventResponse(Event event) {
        this.id = event.getId();
        this.eventName = event.getEventName();
//        this.eventDescription = event.getEventDescription();
        this.eventDate = event.getEventDate();
    }
}
