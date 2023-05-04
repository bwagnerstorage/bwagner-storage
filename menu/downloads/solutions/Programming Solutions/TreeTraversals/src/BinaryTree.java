import java.util.*;

public class BinaryTree
{
   private TreeNode root;

   public BinaryTree()
   {
      root = null;
   }

   // adds a new node to the tree using the ordering property
   // items less than the root go down left subtree and items greater
   // than or equal to the root go down the right subtree
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
          tree.setRight(add(tree.getRight(), item)); // link as you go right

       return tree;                                  // return the tree's root
   }

    // preorder traversal : root-left-right
    public List<Object> preOrderTraversal()
    {
       List<Object> list = new ArrayList();
       preOrderTraversal(root, list);
       return list;
    }

    private void preOrderTraversal(TreeNode tree, List<Object> list)
    {
       if( tree!= null)
       {
          list.add(tree.getValue());
          preOrderTraversal(tree.getLeft(), list);
          preOrderTraversal(tree.getRight(), list);
       }
    }

    // preorder traversal : left-root-right
    public List<Object> inOrderTraversal()
    {


    }

    private void inOrderTraversal(TreeNode tree, List<Object> list)
    {

    }

    // preorder traversal : left-right-root
    public List<Object> postOrderTraversal()
    {

    }

    private void postOrderTraversal(TreeNode tree, List<Object> list)
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