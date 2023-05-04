public class ArrayStack<E> implements Stack<E>
{
    // constants
    public final int INITIAL_SIZE = 10;

    // instance variables
    private E[] array;
    private int size;       // logical size

    @SuppressWarnings({"unchecked"})
    public ArrayStack()
    {
        array = (E[])new Object[INITIAL_SIZE];
        size = 0;
    }

    public void push(E item)
    {

    }

    public E pop()
    {

    }

    public E peek()
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