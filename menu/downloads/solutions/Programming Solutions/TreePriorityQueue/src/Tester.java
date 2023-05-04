public class Tester
{
    public static void main(String[] args)
    {
        TreePriorityQueue queue = new TreePriorityQueue();

        queue.add(50);
        queue.add(20);
        queue.add(80);
        queue.add(10);
        queue.add(90);
        queue.add(35);
        queue.add(75);
        queue.add(10);
        queue.add(80);
        queue.add(35);
        queue.add(10);
        queue.add(90);

        System.out.println();
        System.out.println(queue);
        System.out.println();

        System.out.println();
        System.out.println("peekMin");
        System.out.println("-------");
        System.out.println("min = " + queue.peekMin());
        System.out.println();
    }
}