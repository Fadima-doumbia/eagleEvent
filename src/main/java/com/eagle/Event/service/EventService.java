package com.eagle.Event.service;

import com.eagle.Event.dto.EventDto;
import com.eagle.Event.model.Event;
import com.eagle.Event.repository.EventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@EnableScheduling
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    private final ModelMapper modelMapper = new ModelMapper();


    public Event saveEvent(Event event){
        return eventRepository.save(event);
    }

    public Iterable<Event> getAllEvent() {
        return eventRepository.findAll();
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEvent(final Long id) {
        return eventRepository.findById(id);
    }

    public Event updateEvent(EventDto eventDto){
        Event event = modelMapper.map(eventDto, Event.class);
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id){
        eventRepository.deleteById(id);
    }

//    @Scheduled(fixedDelay = 100000)
    public void deleteEventAfterExpiration(){
        List<Event> eventList = eventRepository.findAll();
        eventList.forEach(event -> {
            LocalDate dateEvent = event.getDate();
            LocalDate dateExpiration = dateEvent.plusDays(2);
            LocalDate currentDate = LocalDate.now();
            if(currentDate.equals(dateExpiration)||currentDate.isAfter(dateExpiration)){
                eventRepository.delete(event);
            }
        });
    }

}
