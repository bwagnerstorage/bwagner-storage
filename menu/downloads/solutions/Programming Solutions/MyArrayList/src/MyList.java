public interface MyList<E>
{
    // appends an item to the end of a list
    public void add(E item);

    // inserts an item into a list at position index
    public void add(int index, E item);

    // removes an item from a list at position index
    public void remove(int index);

    // retrieves an item from a list at position index
    public E get(int index);

    // updates an item in a list at position index
    public void set(int index, E item);

    // returns the logical size of a list
    public int size();
}