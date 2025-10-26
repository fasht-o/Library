---
title: Library System
author: Oluwatoni Fashina(7953351)
date: October 8th 2025
---

# Overview

Library Simulator is an implementation of a library System which consists of several libraries differentiated by their media but have the same core functionalities for their users:

- Each library consists of media and spaces/rooms that can be interacted by a collection of users simultaneously

- Users are able to purchase or borrow the media for a period of time

- Users are able to book rooms for a limited period of time.

- Users are able to view a map in order to know the location of the library resources

- Each Room can be differentiated by department with each one serving a specific purpose.

- Each User has differing level of access to the library System depending on their status.

- Users can observe each room or media and determine whether to acesss it depending on reviews provided by other users.



```mermaid

classDiagram

    class LibrarySystem{
        -String name
        -int capacity
        -List~Library~ Libraries
        +addLibrary()
        +removeLibrary()
        +findLibrary(String name) boolean
        +getName() String
        +getCapacity() int
        +getLibraries() Library

    }
    note for LibrarySystem "Invariant Properties:

<ul>
<li> name!= null
<li> name.length() > 0
<li> capacity >= 1
<li> Libraries!= null
<li> loop: no Library are null in Libraries
</ul>"

    class Library{
        -String name
        -int capacity
        -Type Librarytype
        -List~Media~ Medias
        -List ~User~ Users
        -List ~Room~ Room

        +addUser() void
        +removeUser() void
        +findUser() boolean
        +addMedia() void
        +removeMedia()void
        +findUser(String name) boolean
        +findMedia(String name) boolean
        +findRoom(String name) boolean 
        +addRoom() void
        +removeRoom() void
        +getMedia(String name) Media
        +getRoom(String name) Room
        +getUser(String name) User
        +getName() String
        +getCapacity() int
        +getType() Librarytype

    }
    note for Library "Invariant Properties:

<ul>
<li> name!= null
<li> name.length() > 0
<li> Librarytype != null
<li> Medias != null
<li> loop: no Media is null in Medias
<li> Users!= null
<li> loop: no User is null in Users
<li> Rooms != null
<li> loop: no Room is null in Rooms
</ul>"

    class LibraryType{
        <<Enumeration>>
        University
        Public
        Casual
        Recreation

    }

    class Media{
        -String name
        -Mediatype Type
        -List~Review~ Reviews
        -List~Transactions~ availableTransactions
        -List~User~ Waitlist
        -int totalMedia
        -int availableMedia
        -double price
        -boolean isForSale
        -boolean isBorrowable

        +addToStock(int number) void
        +removeFromStock(int number) void
        +addReview(String text, int numStar) boolean
        +getName() int
        +getPrice() double
        +getQuantity() int
        +getTotalMedia() int
        +getAvailableTransactions() Transactions
        +isForSale() boolean
        +isBorrowable() boolean
        +checkWaitlistPosition() int
        +getWaitlist() Waitlist
        +getReviews() ReviewMedia

    }
    note for Media "Invariant Properties:

<ul>
<li> name != null
<li> name.length() > 0
<li> Type!=null
<li> Reviews !=null
<li> loop: no Review is null in Reviews
<li> availableTransactions != null
<li> loop: no Transaction is null in availableTransactions
<li> Waitlist != null
<li> loop: No User is null in Waitlist
<li> totalMedia >0
<li> availableMedia >= 0
<li> price >= 0
</ul>

"
    class Watlist{
        <<Record>>
       -Media media
       -User user
       -Date startTime



    }
    note for Watlist "Invariant Properties

<ul>
<li> Media != null
<li> User != null
<li> startTime > ?
</ul>
"
    class Room{
        -String name
        -String description
        -Department department
        -RoomType type
        -int maxCapacity
        -List~Media~ Medias
        -List~Review~ reviews
        -List~Booking~ Bookings

        +addMedia(Media media) void
        +removeMedia(Media media) void
        +getCapacity() void
        +getDepartment() Departmentd
        +getName() String
        +addReview() void
        +getReviews() ReviewRoom
        +getDescripion() String
        +getType() RoomType
      

    }
    note for Room "Invariant Properties

<li> name != null
<li> name.length() > 0
<li> description != null
<li> description.length() > 0
<li> department != null
<li> type != null
<li> maxCapacity > 0
<li> Medias != null
<li> loop: no Media in Medias is null
<li> Reviews != null
<li> loop: no Review in Reviews is null
<li> Bookings != null
<li> no Booking in Bookings is null
"
   
    class MediaType{
        <<Enumeration>>
        Books
        Journals
        Video Discs
        NewsPrint

    }
    note for MediaType "Invariant Properties"
    class Department{
        <<Enumeration>>
        Science
        Art
        Recreation
        Journalism
        Business
        Hospitality

    }

    class Map{
        -Library library
        +showMap();

    }

    class User{
        -String name
        String email
        int phoneNum
        -List~Media~ borrowedMedia
        -List~Media~ purchasedMedia
        -int borrowLimit
        -double balance

        +name() String
        +OwnMedia(Media media) Media
        +borrowMedia(Media media)
        +purchaseMedia(Media media)
        +getLimit() int
        +changeName(String name) void
        +getBorrowedMedia() List~Media~
        +getPurchasedMedia() List~Media~
        +getBorrowLimit() int
        +getBalance() double
        +addToBalance(double amount) void
        +removeFromBalance(double amount) void

    }
    note for User "Invariant Properties

<ul>
<li> name != null
<li> name.length() > 0
<li> email != null
<li> email.length() > 0?
<li> phoneNum == 10?
<li> Status != null
<li> borrowedMedia != null
<li> loop: No Media in borrowedMedia is null
<li> purchasedMedia != null
<li> loop: No Media in purchasedMedia is null
<li> borrowLimit >= 0
<li> balance >= 0
</ul>
"
   

    
    class Transactions{
        <<Enumeration>>
        Sold
        Borrowed
        Returned
        Refund
        WaitlistAdd
        WaitlistRemoved

    }
    note for Transactions "Invariant Properties"
    class Booking{
        <<Record>>
        -Room room
        -Date startTime
        -Date EndTime

        

    }
    note for Booking "Invariant Properties

<ul>
<li> Room != null
<li> startTime < EndTime
</ul>
"
   

    class ReviewRoom{
        <<Record>>
        String text
        int numStars
        Room room
    }
    note for ReviewRoom "Invariant Properties

<ul>
<li> text != null
<li> text.length() > 0
<li> numStars >= 0
<li> room != null
</ul>
"

    class ReviewMedia{
        <<Record>>
        String text
        int numStars
        Media media
    }
    note for ReviewMedia "Invariant Properties

<ul>
<li> text != null
<li> text.length() > 0
<li> numStars >= 0
<li> media != null
</ul>"
  class showOutput{
      <<Interface>>
      +showOutput()
  }
  class showMedia{
      <<Record>>
      +showOutput()
  }
    class showRoom{
        <<Record>>
        +showOutput()
    }
    class showLibrary{
        <<Record>>
        +showOutput()
    }
    class showUser{
        <<Record>>
        +showOutput()
    }
    class showReview{
        <<Interface>>
        +showReviews()
    }
    class showReviewMedia{
        <<Record>>
        +showReviews()
    }
    class showReviewRoom{
        <<Record>>
        +showReviews()
    }
    LibrarySystem --* Library
    Library --* LibraryType
    Library --* Media
    Library --* Room
    Room --* ReviewRoom
    Media --* ReviewMedia
    Library --*  User
    Library --*  Map
    Library --o Department
    Waitlist --o Media
    Waitlist --o User
    Media --o Transactions
    Booking --o Room
    Media --* Room
    showLibrary --o Library
    showReviewMedia --o ReviewMedia
    showReviewRoom --o ReviewRoom
    showRoom --o Room
    showUser --o User
    showMedia --o Media
    showReviewMedia ..|> showReview
    showReviewRoom ..|> showReview
    showRoom ..|> showOutput
    showUser ..|> showOutput
    showMedia ..|> showOutput
    showLibrary ..|> showOutput
    
    

```

```

```
