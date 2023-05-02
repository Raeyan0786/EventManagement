package com.example.EventManagement.service;


import com.example.EventManagement.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEventService  {
    void addEvent(Event event);
    void updateEvent(String date,Event newevent);
    List<Event> getAllEvent();
    Event getEventByDate(String date);
}
