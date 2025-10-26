package ca.umanitoba.cs.fashina1.Model.classes;

import ca.umanitoba.cs.fashina1.Model.Enum.LibraryType;
import com.google.common.base.Preconditions;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a library that can contain media items, users, and rooms.
 * Provides functionality to manage library resources and perform validation checks.
 */
public class Library {
    private final String name;
    private final int capacity;
    private final LibraryType libraryType;
    private final Set<Media> medias;
    private final HashSet<User> users;
    private final HashSet<Room> rooms;
/**
 * Validates the library's state to ensure all required fields are properly initialized.
 * Checks for null values, empty names, positive capacity, and valid collections
 * */

    private void checkLibrary(){
        Preconditions.checkNotNull(name, "Library name should not be null");
        Preconditions.checkState(name.length() > 0, "Library name should have at least a character");
        Preconditions.checkState(capacity > 0, "library capacity is at least one");
        Preconditions.checkNotNull(libraryType, "libraryType should not be null");
        Preconditions.checkNotNull(medias, "Medias should not be null");
        for(Media m : medias){
            Preconditions.checkNotNull(m, "m should not be null");
        }
        Preconditions.checkNotNull(users, "Users should not be null");
        for(User u: users){
            Preconditions.checkNotNull(u, "User in User should not be null");

        }
        Preconditions.checkNotNull(rooms, "rooms should not be null");
        for(Room r: rooms){
            Preconditions.checkNotNull(r, "Room in Rooms should not be null");
        }


    }
    /**
     * Constructs a new Library with the specified name, capacity, and type.
     * Initializes empty collections for media, users, and rooms.
     * Performs validation checks after initialization.
     *
     * @param name the name of the library
     * @param capacity the capacity of the library
     * @param libraryType the type of library
     */
    public Library(String name, int capacity, LibraryType libraryType) {
        this.name = name;
        this.capacity = capacity;
        this.libraryType = libraryType;
        this.medias = new HashSet<>();
        this.users = new HashSet<>();
        this.rooms = new HashSet<>();
        checkLibrary();
    }
    /**
     * Adds a user to the library's user collection.
     *
     * @param member the user to add to the library
     */
    public void addUser(User member) {
        checkLibrary();
        users.add(member);
        checkLibrary();

    }
    /**
     * Searches for a user in the library by name.
     *
     * @param name the name of the user to search for
     * @return true if a user with the specified name is found, false otherwise
     */
    public boolean findUser(String name){
        boolean found = false;
        checkLibrary();
        for(User u: users){
            if(name.equals(u.getName())){
                found = true;
            }
        }
        checkLibrary();
        return found;
    }
    /**
     * Removes a user from the library by name
     *
     * @param name the name of the user to remove
     */
    public void removeUser(String name) {
        checkLibrary();
        for (User u : users) {
            if (u.getName().equals(name)) {
                users.remove(u);



            }
        }
        checkLibrary();

    }
    /**
     * Retrieves a user from the library by name.
     *
     * @param name the name of the user to retrieve
     * @return the User object if found, null otherwise
     */
    public User getUser(String name){
        checkLibrary();
        User user = null;
        for(User u: users){
            if(name.equals(u.getName())){
                user =u;
            }
        }
        checkLibrary();
        return user;

    }
/**
 * Adds a media item to the library's media collection.
 * Checks if capacity is filled
 * @param media the media item to add to the library
 */
    public void addMedia(Media media){
        checkLibrary();
        if(medias.size() < capacity){
        medias.add(media);
        }
        checkLibrary();

    }
    /**
     * Searches for a media item in the library by name.
     *
     * @param name the name of the media item to search for
     * @return true if a media item with the specified name is found, false otherwise
     */
    public boolean findMedia(String name){
        boolean found = false;
        checkLibrary();
        for(Media m: medias){
            if(name.equals(m.getName())){
                found = true;
            }
        }
        checkLibrary();
        return found;
    }
    /**
     * Removes a media item from the library by name
     *
     * @param name the name of the media item to remove
     */
    public void removeMedia(String name){
        checkLibrary();

        for (Media m : medias) {
            if (m.getName().equalsIgnoreCase(name)) {
                medias.remove(m);

                // Exit the loop after removing the media

            }
        }
        checkLibrary();

    }
    /**
     * Retrieves a media item from the library by name.
     *
     * @param name the name of the media item to retrieve
     * @return the Media object if found, null otherwise
     */
    public Media getMedia(String name){
        checkLibrary();
        Media media = null;
        for(Media m: medias){
            if(name.equals(m.getName())){
                media = m;
            }
        }
        checkLibrary();
        return media;
    }
    /**
     * Adds a room to the library's room collection.
     *
     * @param room the room to add to the library
     */
    public void addRoom(Room room) {
        checkLibrary();
        rooms.add(room);
        checkLibrary();

    }

    /**
     * Searches for a room in the library by name.
     *
     * @param name the name of the room to search for
     * @return true if a room with the specified name is found, false otherwise
     */
    public boolean findRoom(String name){
        boolean found = false;
        checkLibrary();
        for(Room r: rooms){
            if(name.equals(r.getName())){
                found = true;
            }
        }
        checkLibrary();
        return found;
    }
    /**
     * Retrieves a room from the library by name.
     *
     * @param name the name of the room to retrieve
     * @return the Room object if found, null otherwise
     */
    public Room getRoom(String name){
        checkLibrary();
        Room room = null;
        for(Room r: rooms){
            if(name.equals(r.getName())){
                room = r;
            }
        }
        checkLibrary();
        return room;
    }
    /**
     * Removes a room from the library's room collection.
     *
     * @param room the room to remove from the library
     */
    public void removeRoom(Room room) {
        checkLibrary();
        rooms.remove(room);
        checkLibrary();

    }

/**Getters*/
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public LibraryType getLibraryType() {
        return libraryType;
    }

    public Set<Media> getMedias() {
        return medias;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public HashSet<User> getUsers() {
        return users;
    }
}
