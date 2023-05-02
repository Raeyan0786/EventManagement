package com.example.EventManagement.service;

import com.example.EventManagement.model.Event;
import com.example.EventManagement.repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventService implements IEventService {
    @Autowired
    IEventRepository iEventRepository;

    @Override
    public void addEvent(Event event){
        iEventRepository.save(event);
    }

    @Override
    public void updateEvent(String date,Event newevent){
        Event event=getEventByDate(date);
        event.setEventName(newevent.getEventName());
        event.setEventId(newevent.getEventId());
        event.setLocationOfEvent(newevent.getLocationOfEvent());
        event.setEventDate(newevent.getEventDate());
        event.setStartTime(newevent.getStartTime());
        event.setEndTime(newevent.getEndTime());
        iEventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvent(){
        return iEventRepository.findAll();
    }

    @Override
    public Event getEventByDate(String date){
        List<Event> list=iEventRepository.findAll();
        for(Event event:list){
            if(event.getEventDate().equals(date)){
                return event;
            }
        }
        return null;
    }
}
