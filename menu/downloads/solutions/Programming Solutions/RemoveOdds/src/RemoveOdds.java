public class RemoveOdds
{
    private ListNode head;

    public RemoveOdds()
    {
        buildList();
        printList();
        remove();
        printList();
    }

    public void remove()
    {


    }

    public void buildList()
    {
        head = new ListNode((int)(Math.random() * 20), null);
        for(int i = 0; i < 19; i++)
        {
            head = new ListNode((int)(Math.random() * 20), head);
        }
    }

    public void printList()
    {
        ListNode cur = head;
        while(cur != null)
        {
            System.out.print(cur.getValue() + " ");
            cur = cur.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        RemoveOdds app = new RemoveOdds();
    }
}