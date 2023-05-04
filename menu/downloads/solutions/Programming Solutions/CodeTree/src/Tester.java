public class Tester
{
    public static void main(String[] args)
    {
        CodeTree tree = new CodeTree();

        TreeNode root = new TreeNode('*', null, null);
        TreeNode p1 = new TreeNode('*', null, null);
        root.setLeft(p1);
        TreeNode s = new TreeNode('s', null, null);
        p1.setLeft(s);
        TreeNode p2 = new TreeNode('*', null, null);
        p1.setRight(p2);
        TreeNode u = new TreeNode('u', null, null);
        p2.setLeft(u);
        TreeNode y = new TreeNode('y', null, null);
        p2.setRight(y);

        TreeNode p3 = new TreeNode('*', null, null);
        root.setRight(p3);
        TreeNode n = new TreeNode('n', null, null);
        p3.setLeft(n);
        TreeNode l = new TreeNode('l', null, null);
        p3.setRight(l);

        tree.setRoot(root);  // root

        System.out.println();
        System.out.println(tree);
        System.out.println();

        System.out.println("bitsToWord");
        System.out.println("----------");
        System.out.println(tree.bitsToWord("000101010011"));
        System.out.println(tree.bitsToWord("100101111"));
        System.out.println();


        System.out.println("wordToBits");
        System.out.println("----------");
        System.out.println(tree.wordToBits("sunny"));
        System.out.println(tree.wordToBits("null"));
    }
}