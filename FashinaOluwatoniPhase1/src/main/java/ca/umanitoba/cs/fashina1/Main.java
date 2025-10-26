package ca.umanitoba.cs.fashina1;
import ca.umanitoba.cs.fashina1.Model.classes.Library;
import ca.umanitoba.cs.fashina1.Model.classes.LibrarySystem;
import ca.umanitoba.cs.fashina1.Model.Enum.LibraryType;
import ca.umanitoba.cs.fashina1.Model.classes.User;
import ca.umanitoba.cs.fashina1.Model.classes.Media;
import ca.umanitoba.cs.fashina1.Model.Enum.MediaType;
import ca.umanitoba.cs.fashina1.Model.classes.Room;
import ca.umanitoba.cs.fashina1.Model.Enum.RoomType;
import ca.umanitoba.cs.fashina1.Output.showReviewMedia;
import ca.umanitoba.cs.fashina1.Output.showReviewRoom;
import ca.umanitoba.cs.fashina1.Output.showMedia;
import ca.umanitoba.cs.fashina1.Output.showRoom;
import ca.umanitoba.cs.fashina1.Output.showUser;
import ca.umanitoba.cs.fashina1.Output.showLibrary;
import ca.umanitoba.cs.fashina1.Output.Map;


import java.util.Scanner;

/**
 * The main entry point for the Library System application.
 * This class provides a REPL interface for managing
 * libraries, members, media, rooms, and reviews within a library system.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static LibrarySystem librarySystem;
    private static Library library;
    /**
     * Main method that starts the Library System application.
     *
     */
    public static void main(String[] args){

        initialize();
        REPL();
    }
    /**
     * Initializes the library system by prompting the user for system name
     * and creating the initial library system structure.
     */
    private static void initialize(){

        System.out.println("Hello, Welcome to the library Simulator");
        System.out.println("What would you like to name it?");
        String systemName = scanner.nextLine().trim();
        System.out.println("Your library System can only have a capacity of one");
        int capacity = 1;
        librarySystem = new LibrarySystem(systemName, capacity);
        System.out.println("Your " + systemName + " library system has been created");
        addLibrary();

    }
    /**
     * Main REPL loop that continuously processes user commands until exit.
     * Provides interactive menu options for all library management operations.
     */
    private static void REPL(){
        boolean continueRunning = true;
        System.out.println("\nYour library has been added to your system");
        System.out.println("Here are some fun options you can try");
        while (continueRunning) {

            options();

            System.out.println("\nEnter your choice: ");
            String choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "add member":
                    addMember();
                    break;
                case "show member":
                    showMember();
                    break;
                case "remove member":
                    removeMember();
                    break;
                case "add library":
                    addLibrary();
                    break;
                case "show library":
                    showLibrary();
                    break;
                case "add media":
                    addMedia();
                    break;
                case "show media":
                    showMedia();
                    break;
                case "remove media":
                    removeMedia();
                    break;
                case "add room":
                    addRoom();
                    break;
                case "show room":
                    showRoom();
                    break;
                case "add review":
                    addReviewMenu();
                    break;
                case "show review":
                    showReviewMenu();
                    break;
                case "show map":
                    showMap();
                    break;
                case "exit":
                    continueRunning = false;
                    System.out.println("Thank you for using the Library System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            if (continueRunning && !choice.equals("exit")) {
                System.out.print("\nDo you want to return to main menu? (yes/no): ");
                String returnChoice = scanner.nextLine().trim().toLowerCase();
                if (returnChoice.equals("no") || returnChoice.equals("n")) {
                    continueRunning = false;
                    System.out.println("Thank you for using the Library System. Goodbye!");
                }
            }
        }
    }
    /**
     * Displays all available command options to the user.
     */
    private static void options(){
        System.out.println("Add Member");
        System.out.println("Show Member");
        System.out.println("Remove Member");
        System.out.println("Add Library");
        System.out.println("Show Library");
        System.out.println("Add Media");
        System.out.println("Show Media");
        System.out.println("Remove Media");
        System.out.println("Add Room");
        System.out.println("Show Room");
        System.out.println("Add Review");
        System.out.println("Show Review");
        System.out.println("Show Map");

    }
    /**
     * Provides menu for selecting review type (media or room) to add.
     */
    private static void addReviewMenu() {
        System.out.println("What type of review do you want to add?");
        System.out.println("1. Media Review");
        System.out.println("2. Room Review");
        System.out.println("Enter your choice (1 or 2): ");
        String reviewChoice = scanner.nextLine().trim();

        switch (reviewChoice) {
            case "1":
                addReviewMedia();
                break;
            case "2":
                addReviewRoom();
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
                break;
        }
    }
    /**
     * Provides menu for selecting review type (media or room) to display.
     */
    private static void showReviewMenu() {
        System.out.println("What type of review do you want to show?");
        System.out.println("1. Media Reviews");
        System.out.println("2. Room Reviews");
        System.out.println("Enter your choice (1 or 2): ");
        String reviewChoice = scanner.nextLine().trim();

        switch (reviewChoice) {
            case "1":
                showReviewMedia();
                break;
            case "2":
                showReviewRoom();
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
                break;
        }
    }
    /**
     * Adds a new member to the library system.
     * Prompts for user details and checks for existing members before adding.
     */
    private static void addMember(){
        try{
        System.out.println("What would you like to name the User");
        String name = scanner.nextLine().trim();

        System.out.println("What is the user email");
        String email = scanner.nextLine();

        System.out.println("What is the User Phone number(Excatly 10 digits)");
        String phone = scanner.nextLine();

        User user = new User(name, email, phone);
        if(library.findUser(name)){
            System.out.println("User already exists");
        }
        else{
            library.addUser(user);
            System.out.println("User " + name + " has been added");
        }}
        catch (IllegalArgumentException e) {
            System.out.println("Please type in the correct input " + e.getMessage());
        }
    }
/**
 * Displays details of a specific member by name.
 *
 */
    private static void showMember() {
        try{
        System.out.println("What is the name of the member you are looking for?");
        String name = scanner.nextLine();

        if (library.findUser(name)) {
            User user = library.getUser(name);
            showUser userDisplay = new showUser();
            userDisplay.showOutput(user);
        }
        else{
                System.out.println("Member not found");

            }

        }
        catch (IllegalArgumentException e) {
            System.out.println("Please type in the correct input " + e.getMessage());
        }
    }
/**
 * Removes a member from the library system by name.
 * Searches for the member and removes them if found.
 *
 */
    private static void removeMember() {
        try {
            System.out.println("What is the name of the member you wish to remove");
            String name = scanner.nextLine();
            if (library.findUser(name)) {
                library.removeUser(name);
                System.out.println("User has been removed");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("Please type in the correct input " + e.getMessage());
        }


    }
/**
 * Adds a new library to the library system if capacity allows.
 * Prompts for library details including name, capacity, and type.
 * Ensures the library system capacity is not exceeded.
 */
   private static void addLibrary() {
        try{
        if(librarySystem.getLibraries().size() < librarySystem.getCapacity()){
       System.out.println("What would you like to name your library in your System");
       String libraryName = scanner.nextLine().trim();
       System.out.println("How many objects should your library contain");
       int libraryCapacity = Integer.parseInt(scanner.nextLine().trim());
       System.out.println("What type of Library do you want? (University/Public/Casual/Recreation)");
       String type = scanner.nextLine().trim();
       LibraryType libraryType = LibraryType.valueOf(type);
       library = new Library(libraryName, libraryCapacity, libraryType);
       librarySystem.addLibrary(library);
       System.out.println("Library " + libraryName + " created successfully");

   }
        else{
            System.out.println("Your Library System is full, no more libraries can be added");
        }}
        catch (IllegalArgumentException e) {
            System.out.println("Please type in the correct input " + e.getMessage());
        }

    }
/**
 * Displays details of a specific library by name.
 * Shows comprehensive library information including user counts and resources.
 * Uses the ShowLibrary display class to format and present the information.
 */
    private static void showLibrary() {
        try{
        System.out.println("Library name: ");
        String name = scanner.nextLine();

        if (librarySystem.findLibrary(name)){
            showLibrary libraryDisplay = new showLibrary();
            libraryDisplay.showOutput(library);
        }
        else{
            System.out.println("Library not found");
        }


        }
        catch (IllegalArgumentException e) {
            System.out.println("Please type in the correct input " + e.getMessage());
        }
       
    }
/**
 * Adds new media to the library collection.
 * Prompts for media details including name, copies, price, and type.
 * Creates and adds the media item to the library's collection.
 */
    private static void addMedia() {
        try{
        System.out.println("What is the name of the Media you want to add ");
        String name = scanner.nextLine();
        
        System.out.println("How many Copies of the Media do you want to add ");
        int total = Integer.parseInt(scanner.nextLine());

        System.out.println("What is the Price of the Media ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.println("What type is the Media, Choose one (Books/Journals/Digital/Discs/NewsPrints): ");
        String typeStr = scanner.nextLine();

        MediaType type = MediaType.valueOf(typeStr);
        Media mediaItem = new Media(name, total, price, type);

        library.addMedia(mediaItem);
        System.out.println("Media has been added");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Please type in the correct input " + e.getMessage());
        }

    }
    /**
     * Displays details of specific media by name.
     * Shows media information including price, availability, and review counts.
     * Uses the ShowMedia display class to format and present the information.
     *
     */
    private static void showMedia() {
        try{
        System.out.println("What is the name of the Media you want to find");
        String mediaName = scanner.nextLine();

        if (library.findMedia(mediaName)) {
            Media media = library.getMedia(mediaName);
            showMedia mediaDisplay = new showMedia();
            mediaDisplay.showOutput(media);
        }
        else{
            System.out.println("Media not found");
        }

        }
        catch (IllegalArgumentException e) {
            System.out.println("Please type in the correct input " + e.getMessage());
        }
    }
/**
 * Removes media from the library collection by name.
 * Searches for the media item and removes it if found.
 * Provides feedback on the operation's success or failure.
 */
    private static void removeMedia() {
        try{
        System.out.println("What is the name of the media you wish to remove ");
        String mediaName = scanner.nextLine();
        if (library.findMedia(mediaName)) {
            library.removeMedia(mediaName);
            System.out.println("Media has been removed");
        }
        else{
            System.out.println("Media not found");
        }
        }
        catch (IllegalArgumentException e) {
            System.out.println("Please type in the correct input " + e.getMessage());
        }

    }
    /**
     * Adds a new room to the library system.
     * Prompts for room details including name, description, type, and capacity.
     * Creates and adds the room to the library's available spaces.
     */
    private static void addRoom() {
        try {
            System.out.println("What is the name of the Room you want to add ");
            String name = scanner.nextLine();

            System.out.println("What description do you want to add ");
            String description = scanner.nextLine();

            System.out.println("What is the type of room Choose one (ShelvingArea/ReadingArea/ComputerRoom/RecreationArea): ");
            String typeStr = scanner.nextLine();
            RoomType type = RoomType.valueOf(typeStr);
            System.out.println("What is the capacity of Media in the room");
            int capacity = Integer.parseInt(scanner.nextLine());


            Room room = new Room(name, description, type, capacity);

            library.addRoom(room);
            System.out.println("Room has been added");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Please type in the correct input " + e.getMessage());
        }
        }

/**
 * Displays details of a specific room by name.
 * Shows room information including type, description, capacity, and booking counts.
 * Uses the ShowRoom display class to format and present the information.
 */
    private static void showRoom() {
        try {
            System.out.println("What is the name of the room you want to display");
            String roomName = scanner.nextLine();

            if (library.findRoom(roomName)) {
                Room room = library.getRoom(roomName);
                showRoom roomDisplay= new showRoom();
                roomDisplay.showOutput(room);
        }
            else{
                System.out.println("Room not found");
            }

        }
        catch (IllegalArgumentException e) {
            System.out.println("Please type in the correct input " + e.getMessage());
        }

    }
/**
 * Adds a review for specific media by a registered user.
 * Validates user and media existence before adding review with text and star rating.
 * Ensures only registered users can add reviews and media exists in the system.
 */
 private static void addReviewMedia(){
        try{
          System.out.println("What is your name");
          String memberName = scanner.nextLine();
          if(library.findUser(memberName)){
              System.out.println("What is the name of the media you want to review");
              String mediaName = scanner.nextLine();
              if(library.findMedia(mediaName)){
                  System.out.println("What would you like to put in your review ");
                  String text = scanner.nextLine();

                  System.out.println("How many stars would you like to give(Please choose a figure from 1-5) ");
                  int stars = Integer.parseInt(scanner.nextLine());
                  Media media = library.getMedia(mediaName);
                  User user = library.getUser(memberName);
                  media.addReview(text, stars, user);

              }else{
                  System.out.println("The media you are looking for does not exist. Please try a different name");
              }
          }
          else{
              System.out.println("You are not a registered user, please register before giving a review");
          }

      }
        catch (IllegalArgumentException e) {
            System.out.println("Please type in the correct input " + e.getMessage());
        }
  }
/**
 * Adds a review for specific room by a registered user.
 * Validates user and room existence before adding review with text and star rating.
 * Ensures only registered users can add reviews and room exists in the system.
 */
    private static void addReviewRoom(){
        try{
        System.out.println("What is your name");
        String memberName = scanner.nextLine();
        if(library.findUser(memberName)){
            System.out.println("What is the name of the Room you want to review");
            String roomName = scanner.nextLine();
            if(library.findRoom(roomName)){
                System.out.println("What would you like to put in your review ");
                String text = scanner.nextLine();

                System.out.println("How many stars would you like to give(Please choose a figure from 1-5) ");
                int stars = Integer.parseInt(scanner.nextLine());
                Room room = library.getRoom(roomName);
                User user = library.getUser(memberName);
                room.addReview(text, stars, user);

            }else{
                System.out.println("The room you are looking for does not exist. Please try a different name");
            }
        }
        else{
            System.out.println("You are not a registered user, please register before giving a review");
        }}
        catch (IllegalArgumentException e) {
            System.out.println("Please type in the correct input " + e.getMessage());
        }

    }




/**
 * Displays all reviews for specific media by name.
 * Shows formatted reviews including text, star ratings, and reviewer information.
 * Uses the ShowReviewMedia display class to present the reviews.
 */
    private static void showReviewMedia() {
        try {
            System.out.println("What is the name of the media that you want to display it's review");
            String mediaName = scanner.nextLine();
            if (library.findMedia(mediaName)) {
                Media media = library.getMedia(mediaName);
                showReviewMedia reviewDisplayer = new showReviewMedia();

                reviewDisplayer.showReviews(media.getReviews());

            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("Please type in the correct input " + e.getMessage());
        }

        }
/**
 * Displays all reviews for specific room by name.
 * Shows formatted reviews including text, star ratings, and reviewer information.
 * Uses the ShowReviewRoom display class to present the reviews.
 */
    private static void showReviewRoom() {
        try{
        System.out.println("What is the name of the room that you want to display it's review");
        String roomName = scanner.nextLine();
        if(library.findMedia(roomName)){
            Room room = library.getRoom(roomName);
            showReviewRoom reviewDisplayer = new showReviewRoom();

            reviewDisplayer.showReviews(room.getReviews());

        }}
        catch (IllegalArgumentException e) {
            System.out.println("Please type in the correct input " + e.getMessage());
        }

    }
/**
 * Displays the map for a specific library by name.
 * Shows library layout with departments and resource locations.
 * Uses the Map class to generate and display the visual representation.
 */
    private static void showMap() {
        try{
        System.out.println("What is the name of the library whose map you want to display");
        String libraryName = scanner.nextLine();
        if(librarySystem.findLibrary(libraryName)){
            Map map = new Map(library);
            map.showMap();
        }
        else{
            System.out.println("The library name you provided does not exist");
        }
    }
        catch (IllegalArgumentException e) {
            System.out.println("Please type in the correct input " + e.getMessage());
        }}

}
