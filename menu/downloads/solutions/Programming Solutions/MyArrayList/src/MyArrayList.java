public class MyArrayList<E> implements MyList<E>
{
    public int INITIAL_SIZE = 5;

    private E[] array;
    private int size;

    @SuppressWarnings({"unchecked"})
    public MyArrayList()
    {
        array = (E[])new Object[INITIAL_SIZE];
        size = 0;
    }
    public void add(E item)
    {

    }
    public void add(int index, E item)
    {

    }
    public void remove(int index)
    {

    }
    public E get(int index)
    {

    }
    public void set(int index, E item)
    {

    }
    public int size()
    {

    }

    public void resize()
    {
        E[] array2 = (E[])new Object[array.length + 5];  // increase length by 5

        for(int i = 0; i < array.length; i++)
        {
                array2[i] = array[i];
        }

        array = array2; // replace original array with new array

    }
}