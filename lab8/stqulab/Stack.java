package stqulab;

/**
 * Stack.java
 *
 * Interface for the stack ADT.
 *
 * @author Thomas VanDrunen
 * CSCI 245, Wheaton College, Spring 2009
 * In-class example
 * Mar 4, 2009
 */

public interface Stack<T> {

    /**
     * Add an item to the stack
     * @param x The item to be pushed
     */
    void push(T x);
    
    /**
     * Retrieve the top element of the stack
     * @return The top element
     */
    T top();
    
    /**
     * Retrieve and remove the top element of the stack 
     * @return The top element
     */
    T pop();
    
    /**
     * Test if there are any more elements in the stack
     * @return True if the stack is empty, false otherwise
     */
    boolean empty();
    
    /**
     * Test if there is room for any more elements in the
     * stack
     * @return
     */
    boolean full();
}
