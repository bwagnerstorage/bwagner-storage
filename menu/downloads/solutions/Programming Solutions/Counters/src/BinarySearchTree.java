import java.util.*;

public class BinarySearchTree
{
   private TreeNode root;

   public BinarySearchTree()
   {
      root = null;
   }

   public void add(Comparable item)
   {
       root = add(root, item);
   }

   private TreeNode add(TreeNode tree, Comparable item)
   {
        if(tree == null)                              // reached correct position
           return new TreeNode(item, null, null);     // add the new node here
        else if(item.compareTo(tree.getValue()) < 0)  // go left or right?
           tree.setLeft(add(tree.getLeft(), item));   // link nodes as you go left
        else
           tree.setRight(add(tree.getRight(), item)); // link nodes as you go right

        return tree;                                  // return the tree's root
   }

   // counts and returns the number of nodes in tree
   public int numNodes()
   {
      return numNodes(root);
   }

   public int numNodes(TreeNode node)
   {
        if(node == null)
        {
            return 0;
        }
        else
        {
            return 1 + numNodes(node.getLeft()) + numNodes(node.getRight());
        }
   }

   public int numLeaves()
   {
       return numLeaves(root);
   }

   // part(a)
   // counts and returns the number of leaf nodes
   public int numLeaves(TreeNode root)
   {


   }

   public int numParents()
   {
       return numParents(root);
   }

   // part(b)
   // counts and returns the number of parent nodes
   public int numParents(TreeNode root)
   {


   }

   // prints tree vertically so that tree structure
   // can be easily identified - uses reverse inorder
   // traversal: right-root-left
   public String toString()
   {
      return toString(root, 0);
   }

   // return string representation of tree's structure
   private String toString(TreeNode root, int level)
   {
        String str = "";
        if(root != null)
        {
            str += toString(root.getRight(), level + 1);
            for(int i = 1; i <= level; i++)
            {
                str = str + "  ";
            }
            str += root.getValue().toString() + "\n";
            str += toString(root.getLeft(), level + 1);
        }

        return str;
   }
}