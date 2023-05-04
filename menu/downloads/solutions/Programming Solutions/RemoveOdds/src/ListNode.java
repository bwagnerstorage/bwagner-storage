public class ListNode
{
   // Instance Variables
   private Object value;
   private ListNode next;

   // Constructor
   public ListNode(Object initValue, ListNode initNext)
   {
      value = initValue;
      next = initNext;
   }

   // Accessor Methods
   public Object getValue()
   {
      return value;
   }

   public ListNode getNext()
   {
      return next;
   }

   // Mutator Methods
   public void setValue(Object theNewValue)
   {
      value = theNewValue;
   }

   public void setNext(ListNode theNewNext)
   {
      next = theNewNext;
   }
}