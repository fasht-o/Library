package ca.umanitoba.cs.fashina1.Output;
import ca.umanitoba.cs.fashina1.Model.records.ReviewRoom;

import java.util.List;

/**
 * Displays room reviews in a formatted output.
 * This record implements the showReview interface and
 * presents room review information to users
 */
public record showReviewRoom() implements showReview<ReviewRoom> {

    /**
     * Displays a list of room reviews
     * Iterates through all provided reviews and formats each one with room name,
     * review text, star rating, and reviewer name
     *
     * @param reviewRooms the list of ReviewRoom objects to display
     */
    public void showReviews(List<ReviewRoom> reviewRooms) {
        // Process each review in the list and format it for display
        // This loop ensures all reviews are presented consistently
        for(ReviewRoom r: reviewRooms){
            System.out.println("The review for " + r.room().getName() + " is " + r.text() + " with " + r.numStars() + " stars from " + r.user().getName());
        }
    }
}