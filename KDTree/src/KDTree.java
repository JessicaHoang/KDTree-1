import java.util.*;
import java.awt.geom.Point2D;

public class KDTree extends Node{
	
	// Represents direction of the partition
	private static final boolean VERTICAL = true;
    private static final boolean HORIZOTAL = false;
	
	//private Node root;
	private int size;
	
	// default empty tree
	public KDTree() {
		root = null;
		size = 0;
	}
	
	// Insert 2D points into the tree
	 public void insert(Point2D p) {
	        if (p == null) 
	        		return;
	        root = insert(root, p);
	 }
	 
	 private Node insert(Node parent, Point2D p) {
		 // If parent is null
		 if (parent == null) {
			 Node node = new Node();
			 node.parent = p;
			 node.left = null;
			 node.right = null;
			 size++;
			 return node;
		 }
		 if (p.getX() < parent.parent.getX()) {
			 if(parent.left == null) {
				 parent.left = insert(parent.left, p);
				 return parent;
			 } 
			 parent.left = insert(parent.left, p);
		 } else {
				 if (parent.right == null) {
					 parent.right = insert(parent.right, p);
					 return parent;
				 }
				 parent.right = insert(parent.right, p);
			 }
		 
		 if (p.getY() > parent.parent.getY()) {
			 if(parent.left == null) {
				 parent.left = insert(parent.left, p);
				 return parent;
			 } 
			 parent.left = insert(parent.left, p);
		 } else {
				 if (parent.right == null) {
					 parent.right = insert(parent.right, p);
					 return parent;
				 }
				 parent.right = insert(parent.right, p);
			 }
		 

		 return parent;      
		 } 

	//search method to find coordinates
	public boolean search(Point2D point) 
	{
		return searchHelper(root, point, 1);
	}


	 public boolean searchHelper(Node node, Point2D p, int level){
		
		//if root is null return null
		if(node == null){
			System.out.println("The tree is empty!");
			return false;
		}
		
		if(root.parent.equals(p))
		{
			return true;
		}

			
	   if (level % 2  == 0 ) //find horizontal 
	   {
		if(node.parent.getY() < p.getY() ){
			searchHelper(node.right, p, level + 1);
		} else {
			searchHelper(node.left, p, level + 1 );
		}
		
	   }

	   else // find vertical
	   { 
		   if(node.parent.getX() < p.getX()) {
			   searchHelper(node.right, p, level + 1);
		   } else {
			   searchHelper(node.left, p, level+ 1);
		   }
	   }
	return false;
	
}
	// Empty Method
    public boolean isEmpty() {
    		return root == null;
    }
    
    // Number of nodes in the tree 
    public int size() {
        return size;
    }

}
