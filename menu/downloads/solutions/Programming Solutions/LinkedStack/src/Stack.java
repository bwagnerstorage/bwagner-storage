public interface Stack<E>
{
    // adds an item to the top of the stack
    public void push(E item);

    // removes an item from the top of the stack
    public E pop();

    // returns the top item in the stack without removing it
    public E peek();

    // returns true if the stack is empty; otherwise returns false
    public boolean isEmpty();

    // returns a String representation of the stack
    public String toString();
}