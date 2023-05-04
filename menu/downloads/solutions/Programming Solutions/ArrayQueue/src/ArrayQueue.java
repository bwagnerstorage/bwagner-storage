public class ArrayQueue<E> implements Queue<E>
{
    // constants
    public final int INITIAL_SIZE = 10;

    // instance variables
    private E[] array;
    private int size;       // logical size

    @SuppressWarnings({"unchecked"})
    public ArrayQueue()
    {
        array = (E[])new Object[INITIAL_SIZE];
        size = 0;
    }

    public void enqueue(E item)
    {

    }

    public E dequeue()
    {

    }

    public E front()
    {

    }

    public boolean isEmpty()
    {

    }

    public boolean isFull()
    {

    }

    public String toString()
    {

    }
}