package ca.umanitoba.cs.fashina1.Output;


import ca.umanitoba.cs.fashina1.Model.classes.Media;

/**
 * Displays media information including price, copies, and reviews.
 */
public record showMedia() implements showOutput<Media> {
    /**
     * Displays detailed information about a single media item.
     *
     * @param mediaItem the media item to display
     */
    @Override
    public void showOutput(Media mediaItem) {
        System.out.println("The name of the media is " + mediaItem.getName());
        System.out.println("The type of the Media is " + mediaItem.getType());
        System.out.println("The price of the Media is " + mediaItem.getPrice());
        System.out.println("The total copies of the media is " + mediaItem.getTotalMedia());
        System.out.println("The available copies of the media is " + mediaItem.getAvailableMedia());
        System.out.println("The number of reviews in the media is: " + mediaItem.getReviews().size());
    }
}
