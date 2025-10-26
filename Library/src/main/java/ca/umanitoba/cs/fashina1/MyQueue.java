package ca.umanitoba.cs.fashina1;

public class MyQueue {
    private Node front;
    private Node back;

    private static class Node{
        Book book;
        Node link;

        Node(Book book){
            this.book = book;
            this.link = null;
        }
    }
    public MyQueue() {
        this.front = null;
        this.back = null;
    }
    public boolean isEmpty(){
        return front == null;
    }
    public void enQueue(Book book){
        Node newNode = new Node(book);
        if(isEmpty()){
            front = newNode;
            back= newNode;
        }
        else{
            back.link = newNode;
            back = newNode;
        }
    }
    public Book deQueue(){

        Book book = front.book;
        front = front.link;


        return book;
    }
}
