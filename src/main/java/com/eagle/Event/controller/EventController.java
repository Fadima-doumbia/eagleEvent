package com.eagle.Event.controller;

import com.eagle.Event.dto.EventDto;
import com.eagle.Event.model.Event;
import com.eagle.Event.service.EventService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Data
@RestController
@RequestMapping("api/events")
public class EventController {
    @Autowired
    EventService eventService;
//    @Autowired
//    ReservationService reservationService;
    private final ModelMapper modelMapper = new ModelMapper();


    @PostMapping("/final")
    public Event saveEventFinal(@RequestBody Event event){
        return eventService.saveEvent(event);
    }

    @PostMapping()
    public Event saveEvent(@RequestBody Event event){
        return eventService.saveEvent(event);
    }

    @GetMapping("/{eventId}")
    public Optional<Event> getEvent(@PathVariable("eventId") final Long personId){
        return eventService.getEvent(personId);
    }
    @GetMapping()
    public Iterable<Event> getAllEvent(){
        return eventService.getAllEvent();
    }

    @GetMapping("/final")
    public Iterable<Event> getAllEventFinal(){
        return eventService.getAllEvent();
    }

//    @DeleteMapping("/{eventId}")
//    public void eventDelete (@PathVariable("eventId") final Long eventId){
//        eventService.deleteEvent(eventId);
//    }

    @PutMapping("/{eventId}")
    public Event updateEvent(@RequestBody EventDto eventDto){
        return eventService.updateEvent(eventDto);
    }

    @PutMapping("/final/{id}")
    public Event updateEventFinal(@RequestBody EventDto eventDto, @PathVariable("id") final Long id){
        return eventService.updateEvent(eventDto);
    }

    @DeleteMapping("/{id}")
    public void eventDeleteFinale (@PathVariable("id") final Long id){
        eventService.deleteEvent(id);
    }

    @DeleteMapping("/expiration")
    public void eventDeleteAll (){
        eventService.deleteEventAfterExpiration();
    }

}
