package ca.umanitoba.cs.fashina1.Model.classes;
import java.util.*;

import com.google.common.base.Preconditions;

/**
 * Represents a library user with personal information, borrowing capabilities, and account status.
 * Users can borrow media, purchase items, and have account limits and balances.
 */
public class User {
    private final int BORROWLIMIT = 10;
    private final double BALANCE = 15;
    private final String name;
    private final String email;
    private final String phoneNum;
    private final TreeSet<Media> borrowedMedia;
    private final TreeSet<Media> purchasedMedia;
    private int borrowLimit;
    private double balance;

/**
 * Validates the user's state to ensure all fields meet business requirements.
 * Performs checks on user data*/
    private void checkUser() {
        Preconditions.checkNotNull(name, "name should never be null");
        Preconditions.checkState(name.length() > 0, "name should have at least one character");
        Preconditions.checkNotNull(email, "email should never be null");
        Preconditions.checkState(email.length() > 0, "emails hould have at least one character");
        Preconditions.checkState(phoneNum.length() == 10, "phoneNum should have 10 digits");
        Preconditions.checkNotNull(borrowedMedia, "borrowedMedia should never be null");
        for(Media m: borrowedMedia){
            Preconditions.checkNotNull(m, "media in borrowedMedia should not be null");
        }
        Preconditions.checkNotNull(purchasedMedia, "purchasedMedia should never be null");
        for(Media m: purchasedMedia){
            Preconditions.checkNotNull(m , "Media in purchasedMedia should not be null");
        }
        Preconditions.checkState(borrowLimit >= 0, "borrowLimit should never be negative");
        Preconditions.checkState(balance >= 0,"alance should never be negative");
    }
    /**
     * Creates a new user with the specified personal information.
     * Initializes user with default borrow limit (5 items) and starting balance ($10).
     * Validates the user state after construction to ensure proper initialization.
     *
     * @param name the user's full name, must not be null or empty
     * @param email the user's email address, must not be null or empty
     * @param phoneNum the user's phone number, must be exactly 10 digits
     */
    public User(String name, String email, String phoneNum){
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.borrowedMedia = new TreeSet<>();
        this.purchasedMedia = new TreeSet<>();
        this.borrowLimit = BORROWLIMIT;
        this.balance = BALANCE;
        checkUser();
    }
    /**Getters*/
    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public double getBalance() {
        return balance;
    }

    public int getBorrowLimit() {
        return borrowLimit;
    }

    public TreeSet<Media> getBorrowedMedia() {
        return borrowedMedia;
    }

    public TreeSet<Media> getPurchasedMedia() {
        return purchasedMedia;
    }
}
