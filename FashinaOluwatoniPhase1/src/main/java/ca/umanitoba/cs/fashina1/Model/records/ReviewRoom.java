package ca.umanitoba.cs.fashina1.Model.records;

import ca.umanitoba.cs.fashina1.Model.classes.Room;
import ca.umanitoba.cs.fashina1.Model.classes.User;

/**
 * Represents a user review for a library room.
 * the room being reviewed, and the user who wrote the review.
 *
 * @param text the content of the review written by the user
 * @param numStars the star rating given to the room 1-5
 * @param room the room that is being reviewed
 * @param user the user who wrote the review
 */
public record ReviewRoom (String text, int numStars, Room room, User user) {

}
