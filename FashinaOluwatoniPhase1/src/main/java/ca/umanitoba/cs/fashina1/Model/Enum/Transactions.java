package ca.umanitoba.cs.fashina1.Model.Enum;

/**
 * Represents the different types of transactions that can occur in the library system.
 * Each transaction type corresponds to a specific operation that can be performed
 * on library media items
 */
public enum Transactions {
    /** Media item was sold to a user for permanent ownership */
    Sold,

    /** Media item was borrowed by a user for temporary use */
    Borrowed,

    /** Media item was returned by a user after borrowing period */
    Returned,

    /** Media sale was refunded and item returned to library inventory */
    Refund,

    /** User was added to waitlist for unavailable media item */
    WaitlistAdd,

    /** User was removed from waitlist */
    WaitlistRemoved
}