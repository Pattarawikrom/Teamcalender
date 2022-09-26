package com.teamcalender.calendar;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.teamcalender.appuser.AppUser;
import com.teamcalender.calendarentry.CalendarEntry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Calendar {

    @Id
    @SequenceGenerator(
            name = "calendar_sequence",
            sequenceName = "calendar_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "calendar_sequence"
    )
    private long id;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private AppUser owner;

    @JsonBackReference
    @OneToMany
    @JoinColumn(name = "entry_id")
    private List<CalendarEntry> entries;

}
