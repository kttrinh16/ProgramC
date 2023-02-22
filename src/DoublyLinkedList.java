import java.util.*;

// From softwaretestinghelp.com, used under academic Fair Use guidelines
public class DoublyLinkedList<E> {

    //Initially, heade and tail is set to null
    private Node<E> head;
    private Node<E> tail;
    private int length;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public DoublyLinkedList( E item ) {
        Node<E> n = new Node<E>(item,null,null);
        head = n;
        tail = n;
    }

    //add a node to the list
    public void addNode(E item) {
        //Create a new node
        Node<E> newNode = new Node<E>(item,null,null);

        //if list is empty, head and tail points to newNode
        if(head == null) {
            head = tail = newNode;
            //newNode's previous and next are already null.

        }
        else {
            //add newNode to the end of list. tail->next set to newNode
            tail.setNext(newNode);
            //newNode->previous set to tail
            newNode.setPrevious(tail);
            //newNode becomes new tail
            tail = newNode;
            //tail's next point to null
            tail.setNext(null);
        }
    }

//    public boolean isEmpty(){
//        head == null;
//        tail == null;
//        return;
//    }

//    public void sortedInsert(Node<E> head, Node<E> data){
//        Node<E> newNode = new Node<E>(data);
//        if (head == null){
//            return newNode;
//        }
//
//        Node<E> current = head;
//        Node<E> previous = null;
//
//        if(data < current.getData()){
//            newNode.getNext() = current;
//            newNode.getPrevious() = null;
//            current.getPrevious() = newNode;
//        }
//
//        while (current != null && data > current.data){
//            previous = current;
//            current = current.next;
//        }
//
//        if(current == null){
//            newNode.prev = previous;
//            newNode.next = null;
//            previous.next = newNode;
//            return head;
//        }
//
//        newNode.prev = previous;
//        newNode.next = previous.next;
//        previous.next = newNode;
//        newNode.next.prev = newNode;
//
//    }

    //print all the nodes of doubly linked list
    public void printNodes() {
        //Node current will point to head
        Node<E> current = head;
        if(head == null) {
            System.out.println("Doubly linked list is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while(current != null) {
            //Print each node and then go to next.
            System.out.println(current.getData() + " ");
            current = current.getLink();
        }
    }

    public Node<E> getHead(){
        return head;
    }

    public Node<E> getTail(){
        return tail;
    }

    public int getLength(){
        return length;
    }

    public void insertFront(int data){
        Node newNode = new Node(data, null, head);

        if(head != null){
            tail = newNode;
        }
        length++;
    }

    public void insertEnd(int data){
        Node newNode = new Node(data, tail, null);
        newNode.setNext(null);

        if(tail !=null){
            tail.setNext(newNode);

        }
        tail = newNode;
        if(head == null){
            head = newNode;
        }

        length++;
    }

    public void isEmpty(){
        if (length == 0){
            throw new NoSuchElementException("Removing from an empty List");
        }
    }

}


