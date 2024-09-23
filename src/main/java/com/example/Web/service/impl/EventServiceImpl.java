package com.example.Web.service.impl;

import com.example.Web.Mapper.EventMapper;
import com.example.Web.dto.EventDto;
import com.example.Web.models.Club;
import com.example.Web.models.Event;
import com.example.Web.repository.ClubRepository;
import com.example.Web.repository.EventRepository;
import com.example.Web.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.Web.Mapper.EventMapper.mapToEvent;
import static com.example.Web.Mapper.EventMapper.mapToEventDto;

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

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> events=eventRepository.findAll();
        return events.stream().map(EventMapper::mapToEventDto).collect(Collectors.toList());
    }

}
