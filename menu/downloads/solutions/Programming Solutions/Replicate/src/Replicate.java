public class Replicate
{
    private ListNode head;

    public Replicate()
    {
        buildList();
        printList();
        replicate(2);
        printList();
        buildList();
        replicate(3);
        printList();
    }

    public void replicate(int n)
    {


    }

    public void buildList()
    {
        ListNode node2 = new ListNode("blue", null);
        ListNode node1 = new ListNode("white", node2);
        head = new ListNode("red", node1);
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
        Replicate app = new Replicate();
    }
}