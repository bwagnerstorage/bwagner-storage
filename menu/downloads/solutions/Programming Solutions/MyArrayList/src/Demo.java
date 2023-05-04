public class Demo
{
    private MyList<Integer> list;

    public Demo()
    {
        list = new MyArrayList<>();

        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(25);

        printList();

        list.add(2, 100);

        printList();

        list.add(0, 200);

        printList();

        list.add(7, 300);

        printList();

        list.remove(3);

        printList();

        list.remove(0);

        printList();

        list.remove(5);

        printList();

        for(int i=0; i < 20; i++)
        {
                list.add(500);
        }

        System.out.println();
        printList();
    }

    public void printList()
    {
        for(int i = 0; i < list.size(); i++)
        {
                System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Demo app = new Demo();
    }
}