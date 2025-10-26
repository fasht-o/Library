package ca.umanitoba.cs.fashina1.Model.records;

import ca.umanitoba.cs.fashina1.Model.classes.Room;
import com.google.common.base.Preconditions;

import java.util.Date;
/**
 * Represents a room booking with a specific time period.
 * @param startTime the date and time when the booking period begins
 * @param endTime the date and time when the booking period ends
 * @param room the room being reserved for the booking
 */
public record Booking( Date startTime,
                       Date endTime,
                       Room room) {

    private void checkBooking(){
        Preconditions.checkNotNull(room, "Room should not be null");
        Preconditions.checkNotNull(startTime, "Start time should not be null");
        Preconditions.checkNotNull(endTime, "End time should not be null");
        Preconditions.checkState(startTime.before(endTime), "Start time must be before end time");
    }
}


