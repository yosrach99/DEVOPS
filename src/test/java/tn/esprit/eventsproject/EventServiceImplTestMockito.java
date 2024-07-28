package tn.esprit.eventsproject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.eventsproject.entities.Event;
import tn.esprit.eventsproject.repositories.EventRepository;
import tn.esprit.eventsproject.services.EventServiceImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EventServiceImplTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventServiceImpl eventService;

    private Event event;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        event = new Event(1, "Test Event", LocalDate.now(), LocalDate.now().plusDays(1), 100.0f);
    }

    @Test
    void testAddEvent() {
        when(eventRepository.save(event)).thenReturn(event);
        Event createdEvent = eventService.addEvent(event);
        assertNotNull(createdEvent);
        assertEquals(event.getDescription(), createdEvent.getDescription());
    }

    @Test
    void testUpdateEvent() {
        when(eventRepository.save(event)).thenReturn(event);
        Event updatedEvent = eventService.updateEvent(event);
        assertNotNull(updatedEvent);
        assertEquals(event.getDescription(), updatedEvent.getDescription());
    }

    @Test
    void testDeleteEvent() {
        doNothing().when(eventRepository).deleteById(event.getIdEvent());
        eventService.deleteEvent(event.getIdEvent());
        verify(eventRepository, times(1)).deleteById(event.getIdEvent());
    }

    @Test
    void testGetAllEvents() {
        List<Event> events = Arrays.asList(event);
        when(eventRepository.findAll()).thenReturn(events);
        List<Event> retrievedEvents = eventService.getAllEvents();
        assertNotNull(retrievedEvents);
        assertEquals(1, retrievedEvents.size());
    }

    @Test
    void testGetEventById() {
        when(eventRepository.findById(event.getIdEvent())).thenReturn(Optional.of(event));
        Event retrievedEvent = eventService.getEventById(event.getIdEvent());
        assertNotNull(retrievedEvent);
        assertEquals(event.getDescription(), retrievedEvent.getDescription());
    }
}
