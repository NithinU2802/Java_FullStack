package com.example.Web.controller;

import com.example.Web.dto.ClubDto;
import com.example.Web.dto.EventDto;
import com.example.Web.models.Event;
import com.example.Web.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EventController {
    private EventService eventService;

    @Autowired
    public EventController(EventService eventService){
        this.eventService=eventService;
    }

    @GetMapping("/events/{clubId}/new")
    public String createEventForm(@PathVariable("clubId") Long clubId, Model model){
        Event event=new Event();
        model.addAttribute("clubId",clubId);
        model.addAttribute("event",event);
        return "events-create";
    }

    @PostMapping("/events/{clubId}")
    public String createEvent(@PathVariable("clubId") Long clubId, @ModelAttribute("event") EventDto eventDto, Model model, BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("event",eventDto);
            return "clubs-create";
        }
        eventService.createEvent(clubId,eventDto);
        return "redirect:/clubs/"+clubId;
    }

    @GetMapping("/events")
    public String eventList(Model model){
        List<EventDto> events=eventService.findAllEvents();
        model.addAttribute("events",events);
        return "events-List";
    }

    @GetMapping("/events/{eventId}")
    public String viewEvent(@PathVariable("eventId") Long eventId,Model model){
        EventDto eventDto=eventService.findByEventId(eventId);
        model.addAttribute("event",eventDto);
        return "events-details";
    }

    @GetMapping("/events/{eventId}/edit")
    public String editEventForm(@PathVariable("eventId") Long eventId,Model model){
        EventDto event = eventService.findByEventId(eventId);
        model.addAttribute("event",event);
        return "events-edit";
    }

    @PostMapping("/events/{eventId}/edit")
    public String updateClub(@PathVariable("eventId") long eventId,
                             @Valid @ModelAttribute("club") EventDto event,
                             BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("event",event);
            return "events-edit";
        }
        EventDto eventDto=eventService.findByEventId(eventId);
        event.setId(eventId);
        event.setClub(eventDto.getClub());
        eventService.updateEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/events/{eventId}/delete")
    public String deleteEvent(@PathVariable("eventId") Long eventId){
        eventService.deleteEvent(eventId);
        return "redirect:/events";
    }

}
