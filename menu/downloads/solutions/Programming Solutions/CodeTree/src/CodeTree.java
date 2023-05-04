class CodeTree 
{ 
   private TreeNode root;
 
   public void setRoot(TreeNode node)
   {
      root = node;
   }  
   
   // Part(a)
   // precondition: code is a string of 0's and 1's representing 
   //   a valid encoded word
   // postcondition: returns decoded word for code 
   public String bitsToWord(String code)
   {


   } 

   // precondition: each character in word is in a leaf 
   //   of the codetree
   // postcondition: returns the code for word 
   public String wordToBits(String word)
   {
        String bits="";
        for(int k = 0; k < word.length(); k++)
        {
            bits += charToBitsHelper(word.charAt(k), root, "");
        }
        return bits;
   }
   
   // Part(b)
   // postcondition: if ch is in subtree T, returns code for ch 
   private String charToBitsHelper(char ch, TreeNode t, String pathSoFar)
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