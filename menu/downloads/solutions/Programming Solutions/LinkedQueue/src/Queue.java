public interface Queue<E>
{
    // adds an item to the back of the queue
    public void enqueue(E item);


    // removes an item from the front of the queue
    public E dequeue();


    // returns the front item in the queue without removing it
    public E front();


    // returns true if the queue is empty; otherwise returns false
    public boolean isEmpty();


    // returns a String representation of the queue
    public String toString();

}