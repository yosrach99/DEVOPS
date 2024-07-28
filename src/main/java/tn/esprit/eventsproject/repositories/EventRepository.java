package tn.esprit.eventsproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.eventsproject.entities.Event;
import tn.esprit.eventsproject.entities.Tache;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {

}