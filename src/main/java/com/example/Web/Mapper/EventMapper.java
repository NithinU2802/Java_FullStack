package com.example.Web.Mapper;

import com.example.Web.dto.EventDto;
import com.example.Web.models.Event;

public class EventMapper {

    public static Event mapToEvent(EventDto eventDto){
        return Event.builder()
                .id(eventDto.getId())
                .name(eventDto.getName())
                .startTime(eventDto.getStartTime())
                .endTime(eventDto.getEndTime())
                .type(eventDto.getType())
                .creationOn(eventDto.getCreationOn())
                .photoUrl(eventDto.getPhotoUrl())
                .updatedOn(eventDto.getUpdatedOn())
                .build();
    }

    public static EventDto mapToEventDto(Event event){
        return EventDto.builder()
                .id(event.getId())
                .name(event.getName())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .type(event.getType())
                .creationOn(event.getCreationOn())
                .photoUrl(event.getPhotoUrl())
                .updatedOn(event.getUpdatedOn())
                .build();
    }

}
