public class Traversals
{
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();

        tree.add("D");
        tree.add("B");
        tree.add("A");
        tree.add("C");
        tree.add("F");
        tree.add("E");
        tree.add("G");

        System.out.println("Tree Structure");
        System.out.println("==============");
        System.out.println();
        System.out.println(tree);
        System.out.println();
        System.out.println("Preorder Traversal");
        System.out.println("==================");

        System.out.println(tree.preOrderTraversal());

        System.out.println();
        System.out.println("Inorder Traversal");
        System.out.println("=================");

        System.out.println(tree.inOrderTraversal());

        System.out.println();
        System.out.println("Postorder Traversal");
        System.out.println("===================");

        System.out.println(tree.postOrderTraversal());
    }
}