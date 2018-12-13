import java.util.*;
import java.awt.geom.Point2D;

public class KDTree extends Node{
	
	// Represents direction of the partition
	private static final boolean VERTICAL = true;
    private static final boolean HORIZOTAL = false;
	
	private Node root;
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
			 node.p = p;
			 node.left = null;
			 node.right = null;
			 size++;
			 return node;
		 }
		 if (p.getX() < parent.p.getX()) {
			 if(parent.left != null) {
				 parent.left = insert(parent.left, p);
				 return parent;
			 } 
			 parent.left = insert(parent.left, p);
		 } else {
				 if (parent.right != null) {
					 parent.right = insert(parent.right, p);
					 return parent;
				 }
				 parent.right = insert(parent.right, p);
			 }
		 } else {
			 if (parent.right != null) {
				 parent.right = insert(parent.right, p);
				 return parent;
			 }
			 parent.right = insert(parent.right, p);
			 return parent;
		 }      

	//serach method to find if tree has specific point
	public boolean search(Node root, Point2D p){
		//if root is null return null
		if(root == null){
			System.out.println("The tree is empty!");
			return false;
		}
		
		if(root.parent.equals(p))
		{
			return true;
		}
		
		//if x coordinate of p is less then x coordinate of root compare second component and so on
		if(p.getX() < root.parent.getX()){
			if(p.getX() < root.left.parent.getX()){
				return search(root.left, p);
			}
			//return root.left;
		}
		
		//if x coordinate of p is greater then x coordinate of root compare second component and so on
		if(p.getX() > root.parent.getX()){
			if(p.getX() > root.right.parent.getX()){
				return search(root.right, p);
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
