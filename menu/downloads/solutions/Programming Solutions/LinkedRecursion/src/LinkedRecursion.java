import java.util.*;

public class LinkedRecursion
{
    private ListNode head;
    private int[] list1 = {10,7,26,5,31,55,64,19,89,42,75,8};
    private int[] list2 = {1,2,3,2,3,4,3,4,2,1,1,2,5,4,3,2,2,5};
    private Scanner keyboard;

    public LinkedRecursion()
    {
       keyboard = new Scanner(System.in);
       // Test Search Method
       System.out.println("Test RecursiveSearch");
       System.out.println("====================");
       String ans = "y";
       int key = 0;
       while(ans.equalsIgnoreCase("y"))
       {
          head = buildList(list1);
          printList(head);
          System.out.print("Enter search key -->");
          key = keyboard.nextInt();
          if(recursiveSearch(head, key) == true)
          {
             System.out.println("Search key " + key + " found!");
          }
          else
          {
             System.out.println("Search key " + key + " not found!");
          }
          System.out.println();
          System.out.print("Search Again(Y/N)? ");
          ans = keyboard.next();
       }

       // Test numOccurrences
       System.out.println();
       System.out.println();
       System.out.println("Test numOccurrences");
       System.out.println("===================");
       head = buildList(list2);
       printList(head);
       System.out.println();

       int count = numOccurrences(head, 1);
       System.out.println("Number of 1s = " + count);
       count = numOccurrences(head, 2);
       System.out.println("Number of 2s = " + count);
       count = numOccurrences(head, 3);
       System.out.println("Number of 3s = " + count);
       count = numOccurrences(head, 4);
       System.out.println("Number of 4s = " + count);
       count = numOccurrences(head, 5);
       System.out.println("Number of 5s = " + count);
       System.out.println();
    }

    public ListNode buildList(int[] list)
    {
        ListNode start = new ListNode(list[0], null);
        ListNode cur = start;
        for(int i = 1; i < list.length; i++)
        {
           ListNode newNode = new ListNode(list[i],null);
           cur.setNext(newNode);
           cur = newNode;
        }
        return start;
    }

    public void printList(ListNode cur)
    {
        if(cur != null)
        {
            System.out.print(cur.getValue()+ " ");
            printList(cur.getNext());  // recursive call
        }
        else
            System.out.println();
    }

    // Precondition:  cur points to the beginning of a list
    // Postcondition: method returns true if key value is found
    //                in the list; otherwise returns false
    public boolean recursiveSearch(ListNode cur, int key)
    {


    }

    // Precondition:  cur points to the beginning of a list
    // Postcondition: method returns a count of the number of
    //                times the key value occurs in the list
    public int numOccurrences(ListNode cur, int key)
    {


    }

    public static void main(String[] args)
    {
        LinkedRecursion app = new LinkedRecursion();
    }
}