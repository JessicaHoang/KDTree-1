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
	
	public void search(){
		if(root != null){
			
		}
		
	}
	
	public <T> void contains(T value){
		if(value == null || root == null)
		return;
		
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
