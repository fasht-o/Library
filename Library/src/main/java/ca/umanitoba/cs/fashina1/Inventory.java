package ca.umanitoba.cs.fashina1;



public class Inventory {
    private Node head;
    private int size;
    private static class Node{
        Book book;
        Node link;

        Node(Book book){
            this.book = book;
            this.link = null;
        }
        Node() {
            this.book = null;
            this.link = this;
        }
    }
    public Inventory() {
        head = new Node();
        size = 0;


    }
    public boolean search(long ISBN){
        boolean found = false;
        Node curr = head.link;
        while(curr != head){
            if(curr.book.getISBN() == ISBN){
                found = true;

            }
            curr = curr.link;
        }
        return true;

    }

    public void add(Book otherBook){
        if(search(otherBook.getISBN())){
            System.out.println("Book already added");

        }
        else {
            Node prev = head;
            Node curr = head.link;
            while (curr != head && curr.book.compareTo(otherBook) < 0) {
                prev = curr;
                curr = curr.link;
            }

            Node newNode = new Node(otherBook);
            prev.link = newNode;
            newNode.link = curr;
            size++;

        }


    }

    public void remove(Book otherBook){
        if(search(otherBook.getISBN())){
            Node prev = head;
            Node curr = head.link;
            while(prev != head){
                if(curr.book.getISBN() == otherBook.getISBN()){
                    prev.link = curr.link;
                    size--;


                }
                prev = curr;
                curr = curr.link;
            }
        }
    }
    public Inventory copy(){
        Inventory newInventory = new Inventory();
        Node origin = head.link;
        Node copy = head;
        while(origin != head){
            Book originBook = origin.book;
            Book copyBook =  new Book(originBook.getTitle(), originBook.getAuthor(), originBook.getISBN());
            Node newNode = new Node(copyBook);
            copy.link = newNode;
            copy=newNode;
            origin=origin.link;

        }
        copy.link = newInventory.head;
        return newInventory;
    }

    public Inventory combineWith(Inventory second){
        Inventory combined = new Inventory();
        Node newTop = combined.head;

        Node firstCurr = this.head.link;
        Node secondCurr = second.head.link;
        while(firstCurr != this.head && secondCurr != second.head){
            int compare = firstCurr.book.compareTo(secondCurr.book);

            if(compare == -1){
                newTop.link = new Node(new Book(firstCurr.book.getTitle(), firstCurr.book.getAuthor(), firstCurr.book.getISBN()));
                newTop = newTop.link;
                firstCurr = firstCurr.link;

            }
            else if(compare == 1){
                newTop.link = new Node(new Book(secondCurr.book.getTitle(), secondCurr.book.getAuthor(), secondCurr.book.getISBN()));
                newTop = newTop.link;
                secondCurr = secondCurr.link;

            }
            else{
                newTop.link = new Node(new Book(firstCurr.book.getTitle(), firstCurr.book.getAuthor(), firstCurr.book.getISBN()));
                newTop = newTop.link;
                firstCurr = firstCurr.link;
                secondCurr = secondCurr.link;

            }



        }

        while (firstCurr != this.head){
            newTop.link = new Node(new Book(firstCurr.book.getTitle(), firstCurr.book.getAuthor(), firstCurr.book.getISBN()));
            newTop = newTop.link;
            firstCurr = firstCurr.link;

        }
        while (secondCurr != second.head){
            newTop.link = new Node(new Book(secondCurr.book.getTitle(), secondCurr.book.getAuthor(), secondCurr.book.getISBN()));
            newTop = newTop.link;
            secondCurr = secondCurr.link;
        }
        return combined;
    }

    public void addAll(Inventory second){
        Node secondCurr = second.head.link;

        while(secondCurr != second.head){
            // For each book in second inventory, use the regular add method
            // This ensures no duplicates and maintains sorted order
            this.add(new Book(secondCurr.book.getTitle(),
                    secondCurr.book.getAuthor(),
                    secondCurr.book.getISBN()));
            secondCurr = secondCurr.link;
        }
    }

    public void removeAll(Inventory second){
        Node firstPrev = head;
        Node firstCurr = head.link;
        Node secondCurr = second.head.link;

        while(firstCurr != head && secondCurr != second.head){
            int compare = firstCurr.book.compareTo(secondCurr.book);
            if(compare == -1){
                firstPrev = firstCurr;
                firstCurr = firstCurr.link;
            }
            else if(compare == 1){
                secondCurr = secondCurr.link;
            }
            else {
                firstPrev.link = firstCurr.link;
                firstCurr = firstCurr.link;
                secondCurr = secondCurr.link;
            }

        }

    }

    public Inventory inCommon(Inventory second) {
        Inventory common = new Inventory();
        Node commonHead = common.head;
        Node firstCurr = this.head.link;
        Node secondCurr = second.head.link;
        while(firstCurr != this.head && secondCurr != second.head){
            int compare = firstCurr.book.compareTo(secondCurr.book);

            if(compare == -1){
                firstCurr = firstCurr.link;
            }
            else if(compare == 1){
                secondCurr = secondCurr.link;
            }
            else{
                commonHead.link = new Node(new Book(firstCurr.book.getTitle(), firstCurr.book.getAuthor(), firstCurr.book.getISBN()));
                commonHead = commonHead.link;
                firstCurr = firstCurr.link;
                secondCurr = secondCurr.link;

            }
        }

        commonHead.link = common.head;
        return common;

    }

    public Inventory missingFrom(Inventory second){
        Inventory common = new Inventory();
        Node commonHead = common.head;
        Node firstCurr = this.head.link;
        Node secondCurr = second.head.link;
        while(firstCurr != this.head && secondCurr != second.head){
            int compare = firstCurr.book.compareTo(secondCurr.book);

            if(compare < 0){
                commonHead.link = new Node(new Book(firstCurr.book.getTitle(), firstCurr.book.getAuthor(), firstCurr.book.getISBN()));
                commonHead = commonHead.link;
                firstCurr = firstCurr.link;
            }
            else if(compare > 0){
                secondCurr = secondCurr.link;
            }
            else {
                firstCurr = firstCurr.link;
                secondCurr = secondCurr.link;
            }


        }

        while (firstCurr != this.head){
            commonHead.link = new Node(new Book(firstCurr.book.getTitle(), firstCurr.book.getAuthor(), firstCurr.book.getISBN()));
            commonHead = commonHead.link;
            firstCurr = firstCurr.link;
        }
        commonHead.link = common.head;
        return common;

    }

    public void printAll() {
        System.out.println("There are " + size + " books in the inventory. They are:");
        Node curr = head.link;
        while (curr != head){
            Book book = curr.book;
            System.out.println(book.getAuthor() + ", ''" + book.getTitle() + "'', ISBN " + book.getISBN());
            curr = curr.link;
        }
        }
    // Print books by specific author using MyQueue
    public void printByAuthor(String author) {
        MyQueue queue = new MyQueue();
        int count = 0;

        // First pass: find all books by the given author and add to queue
        Node current = head.link;
        while (current != head) {
            if (current.book.getAuthor().equals(author)) {
                queue.enQueue(current.book);
                count++;
            }
            current = current.link;
        }

        // Second pass: remove books from queue and print them
        if (count == 0) {
            System.out.println("There are no books in the inventory by " + author + ".");
        } else {
            System.out.println("There are " + count + " books in the inventory by " + author + ". They are:");
            while (!queue.isEmpty()) {
                Book book = queue.deQueue();
                System.out.println("''" + book.getTitle() + "'', ISBN " + book.getISBN());
            }
        }
    }






}
