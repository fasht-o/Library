package ca.umanitoba.cs.fashina1.Model.records;

import ca.umanitoba.cs.fashina1.Model.classes.Media;
import ca.umanitoba.cs.fashina1.Model.classes.User;

/**
 * Represents a user review for a library media item.
 * the media item being reviewed, and the user who wrote the review.
 *
 * @param text the content of the review written by the user
 * @param numStars the star rating given to the media item  1-5
 * @param media the media item that is being reviewed
 * @param user the user who wrote the review
 */
public record ReviewMedia  (String text, int numStars, Media media, User user){

}