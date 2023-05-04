import java.util.*;

public class LinkedDuplicates
{
    private ListNode head;
    private int[] list1 = {1,3,2,6,4,1,5,2,2,4,8,1,9,9};
    private int[] list2 = {1,2,3,4,5,6,7,8,9,9};
    private int[] list3 = {1,2,3,4,5,6,7,8,9};
    private int[] list4 = {1,1,2,3,4,4,4,5,6,7,8,8,9};

    public LinkedDuplicates()
    {
       // Test hasDuplicates Method
       System.out.println("Test hasDuplicates");
       System.out.println("==================");

       head = buildList(list1);
       printList(head);

       if(hasDuplicates(head)==true)
          System.out.println("List1 contains duplicates");
       else
          System.out.println("List1 does not contain duplicates");
       System.out.println();

       head = buildList(list2);
       printList(head);

       if(hasDuplicates(head)==true)
          System.out.println("List2 contains duplicates");
       else
          System.out.println("List2 does not contain duplicates");
       System.out.println();

       head = buildList(list3);
       printList(head);

       if(hasDuplicates(head)==true)
          System.out.println("List3 contains duplicates");
       else
          System.out.println("List3 does not contain duplicates");
       System.out.println();

       // Test removeDuplicates Method
       System.out.println("Test removeDuplicates");
       System.out.println("==================");

       head = buildList(list1);
       printList(head);
       removeDuplicates(head);
       printList(head);
       System.out.println();

       head = buildList(list2);
       printList(head);
       removeDuplicates(head);
       printList(head);
       System.out.println();

       head = buildList(list4);
       printList(head);
       removeDuplicates(head);
       printList(head);
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
    // Postcondition: returns true if and only if list has duplicates
    public boolean hasDuplicates(ListNode cur)
    {

    }

    // Precondition:  cur points to the beginning of a list
    // Postcondition: removes all duplicate items from the list pointed to by cur
    public void removeDuplicates(ListNode cur)
    {

    }

    public static void main(String[] args)
    {
        LinkedDuplicates app = new LinkedDuplicates();
    }
 }