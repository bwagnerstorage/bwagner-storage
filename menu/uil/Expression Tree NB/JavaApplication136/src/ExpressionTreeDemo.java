
public class ExpressionTreeDemo 
{
    public static void main(String[] args)
    {
        ExpressionTree tree = new ExpressionTree("postFix", "6 5 * 3 2 * +");        
        ExpressionTree tree2 = new ExpressionTree("preFix",   "+ * 2 3 * 5 6");
        
        tree.preFix();
        tree.inFix();
        tree.postFix();
        
        System.out.println();
        
        tree2.preFix();
        tree2.inFix();
        tree2.postFix();
        
    }
}