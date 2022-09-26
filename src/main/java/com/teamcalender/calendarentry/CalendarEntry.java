package com.teamcalender.calendarentry;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.teamcalender.appuser.AppUser;
import com.teamcalender.calendar.Calendar;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class CalendarEntry {

    @Id
    @SequenceGenerator(
            name = "entry_sequence",
            sequenceName = "entry_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "entry_sequence"
    )
    private long id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "calendar_id")
    private Calendar calendar;
}
