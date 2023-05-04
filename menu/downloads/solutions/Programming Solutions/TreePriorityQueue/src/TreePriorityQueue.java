
public class TreePriorityQueue 
{ 
   private TreeNode root; 

   public TreePriorityQueue() 
   { 
      root = null; 
   } 

   //postcondition: returns true if the priority queue is empty; 
   // otherwise, returns false
   public boolean isEmpty() 
   { 
      return root == null;
   }

   // postcondition: obj has been added to the priority queue 
   public void add(Object obj) 
   { 
      root = addHelper((Comparable)obj, root); 
   } 

   // Part(b)
   // postcondition: obj has been added to the subtree rooted at t; 
   // the updated subtree is returned
   private TreeNode addHelper(Comparable obj, TreeNode t) 
   { 


   }

   // Part(a)
   // precondition: the priority queue is not empty 
   // postcondition: a data value of smallest priority is returned; 
   // the priority queue is unchanged
   public Object peekMin() 
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
                str = str + "    ";
            }
            str += tree.getValue().toString() + "\n";
            str += toString(tree.getLeft(), level + 1);
        }

        return str;
   }  
}