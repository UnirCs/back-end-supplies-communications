package com.unir.supplies.communications.events.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventHeader {
    private String eventId;
    private String version;
    private String eventType;
    private LocalDateTime timestamp;
}
