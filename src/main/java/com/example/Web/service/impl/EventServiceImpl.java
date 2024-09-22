package com.example.Web.service.impl;

import com.example.Web.dto.EventDto;
import com.example.Web.models.Club;
import com.example.Web.models.Event;
import com.example.Web.repository.ClubRepository;
import com.example.Web.repository.EventRepository;
import com.example.Web.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    @Autowired
    public  EventServiceImpl(EventRepository eventRepository,ClubRepository clubRepository){
        this.eventRepository=eventRepository;
        this.clubRepository=clubRepository;
    }

    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Club club=clubRepository.findById(clubId).get();
        Event event=mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }

    private Event mapToEvent(EventDto eventDto){
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

}
