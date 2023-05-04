public class QueueDemo
{
    public static void main(String[] args)
    {
        Queue<Integer> queue = new ArrayQueue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Test enqueue");
        System.out.println("------------");
        System.out.println(queue);

        System.out.println("\nTest dequeue");
        System.out.println("--------------");
        System.out.println(queue.dequeue());

        System.out.println("\nTest dequeue");
        System.out.println("--------------");
        System.out.println(queue.dequeue());

        System.out.println("\nTest dequeue");
        System.out.println("--------------");
        System.out.println(queue.dequeue());

        System.out.println("\nTest isEmpty");
        System.out.println("--------------");
        if(queue.isEmpty())
           System.out.println("queue is empty!");
        else
           System.out.println("queue is not empty!");

        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);

        System.out.println();
        System.out.println(queue);

        System.out.println("\nTest front");
        System.out.println("--------------");
        System.out.println(queue.front());

        System.out.println("\nTest isEmpty and dequeue");
        System.out.println("------------------------");

        while(!queue.isEmpty())
        {
            System.out.print(queue.dequeue()+" ");
        }

        System.out.println("\n\nTest isFull");
        System.out.println("------------");

        while(!((ArrayQueue)queue).isFull())      // need cast
        {
            queue.enqueue(70);
            if(((ArrayQueue)queue).isFull())
                    System.out.println("queue is full!\n");

        }
        System.out.println(queue);
    }
}