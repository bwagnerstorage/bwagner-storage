public class BTreeUtilities
{
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(50);
        tree.add(25);
        tree.add(75);
        tree.add(32);
        tree.add(17);
        tree.add(88);
        tree.add(5);
        tree.add(62);
        tree.add(41);

        System.out.println("Tree Structure");
        System.out.println("==============");
        System.out.println();
        System.out.println(tree);

        System.out.println("Tree Utilities");
        System.out.println("==============");
        System.out.println();
        System.out.println("Values less than 90 = " + tree.valsLess(90));
        System.out.println("Values less than 65 = " + tree.valsLess(65));
        System.out.println("Min Value = " + tree.minValue());
        System.out.println("Tree Height = " + tree.treeHeight());
        System.out.println("Path has sum of 187 = " + tree.hasPathSum(187));
        System.out.println("Path has sum of 97  = " + tree.hasPathSum(97));
        System.out.println("Path has sum of 146  = " + tree.hasPathSum(146));

        tree.mirror();

        System.out.println();
        System.out.println();
        System.out.println("   Mirror");
        System.out.println("============");
        System.out.println();
        System.out.println(tree);
    }
}