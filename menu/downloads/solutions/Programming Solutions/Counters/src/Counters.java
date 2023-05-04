public class Counters
{
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();

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
        System.out.println("Number of nodes = " + tree.numNodes());
        System.out.println("Number of leaves = " + tree.numLeaves());
        System.out.println("Number of parents = " + tree.numParents());
        System.out.println();

        BinarySearchTree tree2 = new BinarySearchTree();

        tree2.add("M");
        tree2.add("R");
        tree2.add("E");
        tree2.add("P");
        tree2.add("W");
        tree2.add("C");
        tree2.add("Y");
        tree2.add("Q");
        tree2.add("H");
        tree2.add("A");

        System.out.println("Tree Structure");
        System.out.println("==============");
        System.out.println();
        System.out.println(tree2);

        System.out.println();
        System.out.println("Number of nodes = " + tree2.numNodes());
        System.out.println("Number of leaves = " + tree2.numLeaves());
        System.out.println("Number of parents = " + tree2.numParents());
        System.out.println();
    }
}