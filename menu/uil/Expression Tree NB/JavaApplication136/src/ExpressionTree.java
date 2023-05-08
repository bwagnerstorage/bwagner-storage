import java.util.*;

public class ExpressionTree 
{
    private TreeNode root;
    private Stack<TreeNode> stack;
    
    public ExpressionTree(String type, String expression)
    {
        stack = new Stack<>();
        if(type.equalsIgnoreCase("postfix"))
            createPostfixExpressionTree(expression);
        
        stack = new Stack<>();
        if(type.equalsIgnoreCase("prefix"))
            createPrefixExpressionTree(expression);
        
    }
    
    public void createPostfixExpressionTree(String expression)
    {
        Scanner scan = new Scanner(expression);
        
        while(scan.hasNext())
        {
            String value = scan.next();
             
            if (isOperator(value)) 
            {
               TreeNode rightNode = stack.pop();
               TreeNode leftNode = stack.pop();
               TreeNode operatorSubtree = new TreeNode(value, leftNode, rightNode);
               stack.push(operatorSubtree);
            } 
            else  // add operand node to stack
            {
                stack.add(new TreeNode(value, null, null));
            }
        }
        root = stack.pop();   
    }
    
    public void createPrefixExpressionTree(String expression)
    {
        String exp = "";
        for(int i = expression.length() - 1; i >= 0; i--)
        {
            exp += expression.substring(i, i+1);
        }
        
        Scanner scan = new Scanner(exp);
        
        while(scan.hasNext())
        {
            String value = scan.next();

            if (isOperator(value)) 
            {
               TreeNode rightNode = stack.pop();
               TreeNode leftNode = stack.pop();
               TreeNode operatorSubtree = new TreeNode(value, leftNode, rightNode);
               stack.push(operatorSubtree);
            } 
            else  // add operand node to stack
            {
                stack.add(new TreeNode(value, null, null));
            }
        }
        root = stack.pop();   
    }
    
    public boolean isOperator(String value)
    {
        if(value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/"))
            return true;
        else
            return false;
    }

    
    public void preFix()
    {
        preFixHelper(root);
        System.out.println();
    }
    
    public void preFixHelper(TreeNode root)
    {
        if(root != null)
        {
            System.out.print(root.getValue()+ " ");
            preFixHelper(root.getLeft());
            preFixHelper(root.getRight());
        }
    }
    
    public void inFix()
    {
        inFixHelper(root);
        System.out.println();
    }
    
    public void inFixHelper(TreeNode root)
    {
        if(root != null)
        {
            inFixHelper(root.getLeft());
            System.out.print(root.getValue()+ " ");
            inFixHelper(root.getRight());
        }
    }
    
    public void postFix()
    {
        postFixHelper(root);
        System.out.println();
    }
    
    public void postFixHelper(TreeNode root)
    {
        if(root != null)
        {
            postFixHelper(root.getLeft());
            postFixHelper(root.getRight());
            System.out.print(root.getValue()+ " ");
        }
    }

}
