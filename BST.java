 public class BST <T>{

 private class Node{
       public Comparable data;
       public Node left;
       public Node right;

       Node(Comparable newdata) {
          data = newdata;
       }
   }


   private Node root;

   public BST(){
    root = null;
   }



   public void insert(Comparable elem) {
      root = insert(root, elem);
   }

   public boolean find(Comparable elem){
      return find(root,elem);
   }

   public void delete(Comparable elem){
      root = delete(root, elem);
   }


   public void print(){
      print(root);
   }

   public boolean find(Node tree, Comparable elem){
      if (tree == null)
         return false;
      if (elem.compareTo(tree.data) == 0) 
         return true;
      if (elem.compareTo(tree.data) < 0)
         return find(tree.left, elem);
      else
         return find(tree.right, elem);
   }

  public Comparable minimum(Node tree) {
      if (tree == null)
         return null;
      if (tree.left == null)
         return tree.data;
      else
         return minimum(tree.left);
   }

   public void print(Node tree){
      if (tree != null){
         print(tree.left);
         System.out.println(tree.data);
         print(tree.right);
      }
   }

   public Node insert(Node tree, Comparable elem){
      if (tree == null){
         return new Node(elem);
      }
      if (elem.compareTo(tree.data) < 0){
	  tree.left = insert(tree.left, elem);
	  return tree;
      } 
      else 
      {
	  tree.right = insert(tree.right, elem);
	  return tree;
      }
   }


  public Node delete(Node tree, Comparable elem){
     if (tree == null) 
        return null;
     if (tree.data.compareTo(elem) == 0){
        if (tree.left == null)
	   return tree.right;
        else if (tree.right == null)
	   return tree.left;
        else 
        {
	   if (tree.right.left == null){
             tree.data = tree.right.data;
             tree.right = tree.right.right;
             return tree;
           } 
           else 
           {         
             tree.data = removeSmallest(tree.right);
             return tree;
            }
         }
      } 
      else  if (elem.compareTo(tree.data) < 0){
         tree.left = delete(tree.left, elem);
         return tree;
      } 
      else 
      {
         tree.right = delete(tree.right, elem);
         return tree;
      }
   }  
 
   public Comparable removeSmallest(Node tree) {
      if (tree.left.left == null) {
         Comparable smallest = tree.left.data;
         tree.left = tree.left.right;
         return smallest;
      } 
      else 
      {
         return removeSmallest(tree.left);
      }
   }
 }