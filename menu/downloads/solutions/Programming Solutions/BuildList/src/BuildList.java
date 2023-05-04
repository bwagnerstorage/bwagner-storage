public class BuildList
{
    // Build1 and Build2 variables
    private ListNode node1;
    private ListNode node2;
    private ListNode node3;
    private ListNode node4;
    private ListNode node5;

    // Build3 variables
    private ListNode head;
    private ListNode cur;
    private ListNode newNode;

    public BuildList()
    {
        build1();
        printList(node1);

        build2();
        printList(node1);

        build3();
        printList(head);
    }

    public void build1()
    {


    }

    public void build2()
    {


    }

    public void build3()
    {


    }

    public void printList(ListNode head)
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
        BuildList app = new BuildList();
    }
}