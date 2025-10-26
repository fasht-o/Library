package ca.umanitoba.cs.fashina1.Model.classes;

import ca.umanitoba.cs.fashina1.Model.records.Booking;
import ca.umanitoba.cs.fashina1.Model.Enum.RoomType;
import ca.umanitoba.cs.fashina1.Model.records.ReviewRoom;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

/**
 * Represents a room in the library system with specific functionality and capacity.
 * Rooms can be of various types and contain media,
 * accept bookings, and collect user reviews.
 */
public class Room {
    private final String name;
    private final String description;
    private final RoomType type;
    private final int capacity;
    private final Set<Media> medias;
    private final List<ReviewRoom> reviews;
    private final List<Booking> bookings;

    /**
     * Validates the room's state to ensure all fields meet business requirements.
     * Performs comprehensive checks on room data including name, description, type,
     * capacity, and collections to maintain data integrity and prevent invalid states.
     *
     */
    private void checkRoom() {
        Preconditions.checkNotNull(name, "Name should not be null");
        Preconditions.checkState(name.length()>0, "name should at least have a character");
        Preconditions.checkNotNull(description, "description should not be null");
        Preconditions.checkState(description.length() > 0, "description should have at least a character");
        Preconditions.checkNotNull(type, "type should never be null");
        Preconditions.checkState(capacity > 0, "maxCapaciy should at least be one");
        Preconditions.checkNotNull(medias, "Medias should not be null");
        for(Media m: medias){
            Preconditions.checkNotNull(m, "Media in Medias should not be null");
        }
        Preconditions.checkNotNull(reviews, "Review in Reviews should not be null");
        for(ReviewRoom r: reviews){
            Preconditions.checkNotNull(r, "Review in Reviews should not be null");
        }
        Preconditions.checkNotNull(bookings, "Bookings should never be null");
        for(Booking b : bookings){
            Preconditions.checkNotNull(b, "Booking in Bookings should not be null");
        }
    }

    /**
     * Creates a new room with the specified attributes.
     * Initializes empty collections for media, reviews, and bookings.
     * Validates the room state after construction to ensure proper initialization.
     *
     * @param name the room's name
     * @param description the room's description
     * @param type the type of room
     * @param capacity the maximum capacity of the room0
     */
    public Room(String name, String description, RoomType type, int capacity) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.capacity = capacity;
        this.medias = new HashSet<>();
        this.reviews = new ArrayList<>();
        this.bookings = new ArrayList<>();
        checkRoom();
    }
    /**
     * Adds a review for this room from a specific user.
     * Creates a new ReviewRoom object and adds it to the room's review collection.
     * Validates room state before and after adding the review to maintain integrity.
     *
     * @param text the review text content,
     * @param numStars the star rating 1-5
     * @param reviewer the user who wrote the review
     */
    public void addReview(String text, int numStars, User reviewer) {

        checkRoom();
        ReviewRoom review = new ReviewRoom(text, numStars, this, reviewer);
        reviews.add(review);
        checkRoom();

    }
    /**Getters*/
    public String getName() {
        return name;
    }


    public int getCapacity() {
        return capacity;
    }

    public RoomType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public Set<Media> getMedias() {
        return medias;
    }

    public List<ReviewRoom> getReviews() {
        return reviews;
    }
}
