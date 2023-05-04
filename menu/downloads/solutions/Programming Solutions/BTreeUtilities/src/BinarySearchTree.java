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


    // returns true if root is null or if all values stored in
    // tree represented by root as less than key;
    // otherwise returns false
    public boolean valsLess(int key)
    {
       return valsLess(root, key);
    }

    private boolean valsLess(TreeNode node, int key)
    {
        if(node == null)
           return true;

        int value = (Integer)node.getValue();
        return value < key && valsLess(node.getLeft(), key) && valsLess(node.getRight(), key);
    }

    // part(a)
    // returns the minimum data value found in tree
    // non-recursive
    public Object minValue()
    {


    }

    public int treeHeight()
    {
        return treeHeight(root);
    }

    // part(b)
    // returns the number of nodes along the longest
    //   path from the root node down to the farthest
    //   leaf node
    private int treeHeight(TreeNode node)
    {


    }

    public boolean hasPathSum(int sum)
    {
        return hasPathSum(root, sum);
    }

    // part(c)
    // given a tree and a sum,
    // returns true if there is a path from the root
    //   down to a leaf, such that adding up all the
    //   values along the path equals the given sum
    private boolean hasPathSum(TreeNode node, int sum)
    {


    }

    public void mirror()
    {
       mirror(root);
    }

    // part(d)
    // changes a tree so that the roles of the left
    //   and right pointers are swapped at every node
    private void mirror(TreeNode node)
    {


    }

   /***********************************/
   /*            toString             */
   /***********************************/

   // prints tree vertically so that tree structure
   // can be easily identified - uses reverse inorder
   // traversal: right-root-left
   public String toString()
   {
      return toString(root, 0);
   }

   private String toString(TreeNode tree, int level)
   {
        String str = "";
        if(tree != null)
        {
            str += toString(tree.getRight(), level + 1);
            for(int i = 1; i <= level; i++)
            {
                str = str + "  ";
            }
            str += tree.getValue().toString() + "\n";
            str += toString(tree.getLeft(), level + 1);
        }

      return str;
   }
}