package ca.umanitoba.cs.fashina1.Output;

import java.util.List;

/**
 * Interface for displaying reviews of library entities.
 * Provides a common contract for showing reviews of different types of library components.
 *
 * @param <T> the type of review this interface can display
 */
public interface showReview<T> {

    /**
     * Displays a collection of reviews
     *
     * @param reviews the list of review objects to display, must not be null
     */
    void showReviews(List<T> reviews);
}