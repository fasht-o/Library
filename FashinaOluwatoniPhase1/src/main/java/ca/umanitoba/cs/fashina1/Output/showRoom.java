package ca.umanitoba.cs.fashina1.Output;

import ca.umanitoba.cs.fashina1.Model.classes.Room;

/**
 * Displays room information including type, description, capacity, and bookings.
 */
public record showRoom() implements showOutput<Room> {
    /**
     * Displays detailed information about a single room.
     *
     * @param room the room to display
     */
    @Override
    public void showOutput(Room room) {
        System.out.println("Name: " + room.getName());
        System.out.println("Type: " + room.getType());
        System.out.println("Description: " + room.getDescription());
        System.out.println("Max capacity: " + room.getCapacity());
        System.out.println("Bookings: " + room.getBookings().size());
        System.out.println("Reviews: " + room.getReviews().size());
        System.out.println("Available Media: " + room.getMedias().size());
    }
}
