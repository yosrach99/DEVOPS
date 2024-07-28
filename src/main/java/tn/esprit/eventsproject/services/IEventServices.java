package tn.esprit.eventsproject.services;

import tn.esprit.eventsproject.entities.Event;
import tn.esprit.eventsproject.entities.Logistics;
import tn.esprit.eventsproject.entities.Participant;

import java.time.LocalDate;
import java.util.List;

public interface IEventServices  {
    Event addEvent(Event event);
    Event updateEvent(Event event);
    void deleteEvent(int idEvent);
    List<Event> getAllEvents();
    Event getEventById(int idEvent);
}