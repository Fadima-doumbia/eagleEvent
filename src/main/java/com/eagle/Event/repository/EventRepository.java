package com.eagle.Event.repository;

import com.eagle.Event.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface EventRepository extends JpaRepository<Event, Long> {
//    List<Reservation> find
}
