package com.eagle.Event.ServiceTest;

import com.eagle.Event.dto.EventDto;
import com.eagle.Event.model.Event;
import com.eagle.Event.service.EventService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EventServiceTest {
    @Autowired
    private EventService eventService;
    Event event = new Event();
    public void seteventNew() {
        event.setAddress("ert");
        event.setDescription("zazert");
        event.setAddress("azerty");
        event.setPlaces(12);
        event.setPrix(15.35);
        event.setHeureDebut(LocalTime.of(12, 45));
        event.setHeureFin(LocalTime.of(15, 45));
        eventService.saveEvent(event);
    }
    @After
    public void destroyTestEnvironment() {
        // cette méthode est exécutée après chaque test
        event.setAddress("ert");
        event.setDescription("zazert");
        event.setAddress("azerty");
        event.setPlaces(12);
        event.setPrix(15.35);
        event.setHeureDebut(LocalTime.of(12, 45));
        event.setHeureFin(LocalTime.of(15, 45));
        eventService.saveEvent(event);
    }
    @Before
    public void set_up() {
        seteventNew();
    }

    @BeforeClass
    public void destTestEnvironment() {
        // cette méthode est exécutée avant chaque test
        Event event = new Event();
        event.setAddress("ert");
        event.setDescription("zazert");
        event.setAddress("azerty");
        event.setPlaces(12);
        event.setPrix(15.35);
        event.setHeureDebut(LocalTime.of(12, 45));
        event.setHeureFin(LocalTime.of(15, 45));
        eventService.saveEvent(event);
        System.out.println(event);
    }
    @Test
    @Order(1)
    void postEvents(){
        Event newEvent = new Event();
        newEvent.setDescription("zazert");
        newEvent.setAddress("azerty");
        newEvent.setPlaces(12);
        newEvent.setPrix(15.35);
        newEvent.setHeureDebut(LocalTime.of(12, 45));
        newEvent.setHeureFin(LocalTime.of(15, 45));
        newEvent.setName("ert");
        eventService.saveEvent(newEvent);
        Assert.assertEquals(newEvent.getName(), "ert");
    }

    @Test
    @Order(2)
    void getAllEvents(){
        Event newEvent = new Event();
        newEvent.setDescription("zazert");
        newEvent.setAddress("azerty");
        newEvent.setPlaces(12);
        newEvent.setPrix(15.35);
        newEvent.setHeureDebut(LocalTime.of(12, 45));
        newEvent.setHeureFin(LocalTime.of(15, 45));
        newEvent.setName("ert");
        eventService.saveEvent(event);
        List<Event> events = eventService.getAllEvents();
        int size = 1;
        Assert.assertEquals(events.size(), size);
    }

        @Test
    @Order(3)
    void getEvent(){
            Event newEvent = new Event();
            newEvent.setDescription("zazert");
            newEvent.setAddress("azerty");
            newEvent.setPlaces(12);
            newEvent.setPrix(15.35);
            newEvent.setHeureDebut(LocalTime.of(12, 45));
            newEvent.setHeureFin(LocalTime.of(15, 45));
            newEvent.setName("ert");
        eventService.saveEvent(event);
        Optional<Event> eventt = eventService.getEvent(5l);
//            List<Event> a = eventService.getAllEvents();
//            System.out.println(a);
        Assert.assertEquals(event.getId(), eventt.get().getId());
    }


    @Test
    @Order(4)
    void putEvent(){
        EventDto eventDto = new EventDto();
        eventDto.setDescription("zazert");
//        eventDto.setAddress("az");
        eventDto.setPlaces(12);
        eventDto.setPrix(15.35);
        eventDto.setHeureDebut(LocalTime.of(12, 45));
        eventDto.setHeureFin(LocalTime.of(15, 45));
        eventDto.setAddress("ert");
        eventService.updateEvent(eventDto);
        eventDto.setAddress("azerty");
        eventService.updateEvent(eventDto);
        System.out.println(eventDto);
        Assert.assertEquals(eventDto.getAddress(), "azerty");
    }

    @Test
    @Order(5)
    void supprimerEvents(){
        eventService.deleteEvent(1l);
        List<Event> events = eventService.getAllEvents();
        int size = 0;
        Assert.assertEquals(events.size(), size);
    }
}
