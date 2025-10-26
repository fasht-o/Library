package ca.umanitoba.cs.fashina1.Output;
import ca.umanitoba.cs.fashina1.Model.records.ReviewMedia;

import java.util.List;

/**
 * Displays media reviewsi
 * This record implements the showReview interface
 * of presenting media review information to users, including review text, star ratings,
 * and reviewer details
 */
public record showReviewMedia() implements showReview<ReviewMedia> {

    /**
     * Displays a list of media reviews in a user-friendly format.
     * Iterates through all provided reviews and formats each one with media name,
     * review text, star rating, and reviewer name for clear presentation.
     * This method ensures consistent display of media reviews across the application.
     *
     * @param reviewMedias the list of ReviewMedia objects to display, must not be null
     */
    public void showReviews(List<ReviewMedia> reviewMedias) {
        // Process each media review in the list and format it for display
        // This consistent formatting helps users easily read and compare reviews
        for(ReviewMedia r: reviewMedias){
            System.out.println("The review for " + r.media().getName() + " is " + r.text() + " with " + r.numStars() + " stars from " + r.user().getName());
        }
    }
}