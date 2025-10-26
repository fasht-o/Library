package ca.umanitoba.cs.fashina1.Output;

import ca.umanitoba.cs.fashina1.Model.classes.User;

/**
 * Displays user information including contact details and account status.
 */
public record showUser() implements showOutput<User> {
    /**
     * Displays detailed information about a single user.
     *
     * @param user the user to display
     */
    @Override
    public void showOutput(User user) {
        System.out.println("Their name is " + user.getName());
        System.out.println("Their email is: " + user.getEmail());
        System.out.println("Their Phone is: " + user.getPhoneNum());
        System.out.println("Borrowed Media: " + user.getBorrowedMedia().size());
        System.out.println("Purchased Media: " + user.getPurchasedMedia().size());
        System.out.println("Borrow Limit: " + user.getBorrowLimit());
        System.out.println("Balance: $" + user.getBalance());
    }
}
