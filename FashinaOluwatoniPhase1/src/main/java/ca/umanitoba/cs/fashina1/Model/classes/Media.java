package ca.umanitoba.cs.fashina1.Model.classes;

import ca.umanitoba.cs.fashina1.Model.Enum.MediaType;
import ca.umanitoba.cs.fashina1.Model.Enum.Transactions;
import ca.umanitoba.cs.fashina1.Model.records.ReviewMedia;
import com.google.common.base.Preconditions;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

/**
 * Represents a media item in the library system with inventory management and user interactions.
 * Media items can be borrowed, purchased, reviewed, and waitlisted by users.
 */
public class Media {
    private final String name;
    private final int totalMedia;
    private final int availableMedia;
    private final double price;
    private  boolean isForSale;
    private  boolean isBorrowable;
    private final MediaType type;
    private final List<ReviewMedia> reviews;
    private final List<Transactions> availableTransactions;
    private final Set<User> waitlist;

/**
 * Validates the media item's state to ensure all fields meet requirements.
 * Performs checks on media data.
 */
 private void CheckMedia() {
        Preconditions.checkNotNull(name, "Media name should not be null");
        Preconditions.checkState(name.length() > 0, "media name should have at least one character");
        Preconditions.checkState(totalMedia > 0, "There should be at least one copy of the media existing");
        Preconditions.checkState(availableMedia > 0, "There should not be less than 0 available media");
        Preconditions.checkState(price > 0, "price can never be negative");
        Preconditions.checkNotNull(type, "Type should not be null");
        Preconditions.checkNotNull(reviews, "Reviews should not be null");
        for(ReviewMedia r : reviews){
            Preconditions.checkNotNull(r, "Review in Reviews should not be null");

        }
        Preconditions.checkNotNull(availableTransactions, "availableTransactions should not be null");
        for(Transactions t: availableTransactions){
            Preconditions.checkNotNull(t, "Transactions in availableTransactions should not b.e null");

        }
        Preconditions.checkNotNull(waitlist, "Waitlist should not be null");
        for(User u: waitlist){
            Preconditions.checkNotNull(u, "User in Waitlist should not be null");
        }



}
    /**
     * Creates a new media item with the specified attributes.
     * Initializes with all copies available, enabled for sale and borrowing,
     * and empty collections for reviews, transactions, and waitlist.
     *
     * @param name the media item's name, must not be null or empty
     * @param totalMedia the total number of copies, must be greater than 0
     * @param price the price of the media item, must be greater than 0
     * @param type the type of media, must not be null
     */
    public Media(String name, int totalMedia, double price, MediaType type){
        this.name = name;
        this.type = type;
        this.totalMedia = totalMedia;
        this.availableMedia = totalMedia;
        this.price = price;
        this.isForSale = true;
        this.isBorrowable = true;
        this.reviews = new ArrayList<>();
        this.availableTransactions = new ArrayList<>();
        this.waitlist = new LinkedHashSet<>();

    }
    /**
     * Adds a review for this media item from a specific user.
     * Creates a new ReviewMedia object and adds it to the media's review collection.
     *
     * @param text the review text content
     * @param numStars the star rating 1-5
     * @param reviewer the user who wrote the review
     */
    public void addReview(String text, int numStars, User reviewer) {

        CheckMedia();
        ReviewMedia review = new ReviewMedia(text, numStars, this, reviewer);
        reviews.add(review);
        CheckMedia();

    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getTotalMedia() {
        return totalMedia;
    }

    public int getAvailableMedia() {
        return availableMedia;
    }

    public List<ReviewMedia> getReviews() {
        return reviews;
    }

    public MediaType getType() {
        return type;
    }

    public boolean isBorrowable() {
        return isBorrowable;
    }

    public boolean isForSale() {
        return isForSale;
    }

    public List<Transactions> getAvailableTransactions() {
        return availableTransactions;
    }


    public Set<User> getWaitlist() {
        return waitlist;
    }
}
