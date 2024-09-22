package com.example.Web.service;

import com.example.Web.dto.EventDto;

public interface EventService {
    void createEvent(Long clubId, EventDto eventDto);

}
