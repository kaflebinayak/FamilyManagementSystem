package com.binayak.family_management_system.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
    private int userId;
    private String eventName;
//    private String eventDescription;
    private LocalDate eventDate;
}
