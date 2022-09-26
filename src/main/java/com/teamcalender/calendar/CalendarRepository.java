package com.teamcalender.calendar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {

    @Query("SELECT i FROM Calendar i WHERE i.owner= ?1")
    Optional<Calendar> findCalendarByOwner(Long owner);

}
