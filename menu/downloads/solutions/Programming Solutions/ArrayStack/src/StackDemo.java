public class StackDemo
{
    public static void main(String[] args)
    {
        @SuppressWarnings({"unchecked"})
        Stack<String> stack = new ArrayStack();

        // test push
        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println("Test push");
        System.out.println("---------");
        System.out.println(stack);

        System.out.println("\nTest pop");
        System.out.println("---------");
        System.out.println(stack.pop());

        System.out.println("\nTest pop");
        System.out.println("---------");
        System.out.println(stack.pop());

        System.out.println("\nTest pop");
        System.out.println("---------");
        System.out.println(stack.pop());

        System.out.println("\nTest isEmpty");
        System.out.println("------------");
        if(stack.isEmpty())
        {
            System.out.println("Stack is Empty!\n");
        }
        else
            System.out.println("Stack is not Empty!\n");

        stack.push("D");
        stack.push("E");
        stack.push("F");

        System.out.println("Test push");
        System.out.println("---------");
        System.out.println(stack);

        System.out.println("\nTest peek");
        System.out.println("---------");
        System.out.println(stack.peek());
        System.out.println();

        System.out.println("Test isEmpty and pop");
        System.out.println("--------------------");

        while(!stack.isEmpty())
        {
            System.out.print(stack.pop()+" ");
        }
        System.out.println("\n\nTest isFull");
        System.out.println("------------");

        while(!((ArrayStack)stack).isFull())      // need cast
        {
            stack.push("G");
            if(((ArrayStack)stack).isFull())
                    System.out.println("Stack is Full!\n");
        }
        System.out.println(stack);
    }
}