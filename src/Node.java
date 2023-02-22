// File: Node.java from the package edu.colorado.nodes
// Complete documentation is available from the Node link in:
//   http://www.cs.colorado.edu/~main/docs

//package edu.colorado.nodes;

// Simplified from Main's Node.java class as the location above.

/******************************************************************************
 * A Node provides a generic node for a linked list. Each node
 * contains a piece of data (which is a reference to an E object) and a link
 * (which is a reference to the next node of the list). The reference stored
 * in a node can be null.
 *
 * @note
 *   Lists of nodes can be made of any length, limited only by the amount of
 *   free memory in the heap. But beyond Integer.MAX_VALUE (2,147,483,647),
 *   the answer from listLength is incorrect because of arithmetic
 *   overflow.
 * @see
 *   <A HREF="../../../../edu/colorado/nodes/Node.java">
 *   Java Source Code for this class
 *   (www.cs.colorado.edu/~main/edu/colorado/nodes/Node.java) </A>
 *
 * @author Michael Main
 *   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
 *
 * @version Feb 10, 2016

 ******************************************************************************/
public class Node<E>
{
    // Invariant of the Node class:
    //   1. Each node has one reference to an E Object, stored in the instance
    //      variable data.
    //   2. For the final node of a list, the link part is null.
    //      Otherwise, the  link part is a reference to the
    //      next node of the list.
    private E data;
    private Node<E> previous;
    private Node<E> next;

    /**
     * Initialize a node with a specified initial data and link to the next
     * node. Note that the initialLink may be the null reference,
     * which indicates that the new node has nothing after it.
     * @param initialData
     *   the initial data of this new node
     * @param next
     *   a reference to the node after this new node--this reference may be null
     *   to indicate that there is no node after this new node.
     * @postcondition
     *   This node contains the specified data and link to the next node.
     **/
    public Node(E initialData, Node<E> next, Node<E> previous)
    {
        data = initialData;
        this.next = next;
        this.previous = previous;
    }

    public Node(E initialData){
        this.data = (initialData);
        this.previous = null;
        this.next = null;

    }

    public Node<E> getNext(){
        return next;
    }

    public Node<E> getPrevious(){
        return previous;
    }



    /**
     * Modification method to add a new node after this node.
     * @param element
     *   the data to place in the new node
     * @postcondition
     *   A new node has been created and placed after this node.
     *   The data for the new node is element. Any other nodes
     *   that used to be after this node are now after the new node.
     * @exception OutOfMemoryError
     *   Indicates that there is insufficient memory for a new
     *   Node.
     **/
    //public void addNodeAfter(E element)
    //{
        //next = new Node<E>(element, next);
    //}


    /**
     * Accessor method to get the data from this node.
     * @return
     *   the data from this node
     **/
    public E getData( )
    {
        return data;
    }


    /**
     * Accessor method to get a reference to the next node after this node.
     * @return
     *   a reference to the node after this node (or the null reference if there
     *   is nothing after this node)
     **/
    public Node<E> getLink( )
    {
        return next;
    }


    /**
     * Compute the number of nodes in a linked list.
     * @param head
     *   the head reference for a linked list (which may be an empty list
     *   with a null head)
     * @param <E>
     *   type of an element in the list
     * @return
     *   the number of nodes in the list with the given head
     * @note
     *   A wrong answer occurs for lists longer than Int.MAX_VALUE.
     **/
    public static <E> int listLength(Node<E> head)
    {
        Node<E> cursor;
        int answer;

        answer = 0;
        for (cursor = head; cursor != null; cursor = cursor.next)
            answer++;

        return answer;
    }






    /**
     * Find a node at a specified position in a linked list.
     * @param head
     *   the head reference for a linked list (which may be an empty list in
     *   which case the head is null)
     * @param position
     *   a node number
     * @param <E>
     *   type of an element in the list
     * @precondition
     *   position &gt; 0.
     * @return
     *   The return value is a reference to the node at the specified position in
     *   the list. (The head node is position 1, the next node is position 2, and
     *   so on.) If there is no such position (because the list is too short),
     *   then the null reference is returned.
     * @exception IllegalArgumentException
     *   Indicates that position is zero.
     **/
    public static <E> Node<E> listPosition(Node<E> head, int position)
    {
        Node<E> cursor;
        int i;

        if (position == 0)
            throw new IllegalArgumentException("position is zero");

        cursor = head;
        for (i = 1; (i < position) && (cursor != null); i++)
            cursor = cursor.next;

        return cursor;
    }


    /**
     * Search for a particular piece of data in a linked list.
     * @param head
     *   the head reference for a linked list (which may be an empty list in
     *   which case the head is null)
     * @param target
     *   a target to search for
     * @param <E>
     *   type of an element in the list
     * @return
     *   The return value is a reference to the first node that contains the
     *   specified target. If the target is non-null, then the
     *   target.equals method is used to find such a node.
     *   The target may also be null, in which case the return value is a
     *   reference to the first node that contains a null reference for its
     *   data. If there is no node that contains the target, then the null
     *   reference is returned.
     **/
    public static <E> Node<E> listSearch(Node<E> head, E target)
    {
        Node<E> cursor;

        if (target == null)
        {  // Search for a node in which the data is the null reference.
            for (cursor = head; cursor != null; cursor = cursor.next)
                if (cursor.data == null)
                    return cursor;
        }
        else
        {  // Search for a node that contains the non-null target.
            for (cursor = head; cursor != null; cursor = cursor.next)
                if (target.equals(cursor.data))
                    return cursor;
        }

        return null;
    }


    /**
     * Modification method to remove the node after this node.
     * @precondition
     *   This node must not be the tail node of the list.
     * @postcondition
     *   The node after this node has been removed from the linked list.
     *   If there were further nodes after that one, they are still
     *   present on the list.
     * @exception NullPointerException
     *   Indicates that this was the tail node of the list, so there is nothing
     *   after it to remove.
     **/
    public void removeNodeAfter( )
    {
        next = next.next;
    }


    /**
     * Modification method to set the data in this node.
     * @param newData
     *   the new data to place in this node
     * @postcondition
     *   The data of this node has been set to newData.
     *   This data is allowed to be null.
     **/
    public void setData(E newData)
    {
        data = newData;
    }


    /**
     * Modification method to set the link to the next node after this node.
     * @param newNext
     *   a reference to the node that should appear after this node in the linked
     *   list (or the null reference if there is no node after this node)
     * @postcondition
     *   The link to the node after this node has been set to newLink.
     *   Any other node (that used to be in this link) is no longer connected to
     *   this node.
     **/
    public void setNext(Node <E> newNext){
        next = newNext;
    }

    public void setPrevious(Node<E> nextPrevious){
        previous = nextPrevious;
    }
}

