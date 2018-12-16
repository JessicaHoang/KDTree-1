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

	//insert method
	 public void insert(Point2D p) {
	        if (p == null) 
	  
	        //new double[] {x_min, y_min, x_max, y_max}
	        root = insert(root, p, true, new double[] {0,0,1,1});
	 }
	
	  private Node insert(Node curNode, Point2D p, boolean evenComponent, double[] coordP) 
	 {
		 //if the parent node is null, insert and increment size in the tree
		 if(curNode == null) 
		 {
			 size++;
			 return new Node(p, coordP);
		 }
		 
		 double comp = comparePts(p,curNode,evenComponent);
		 
		 //Only deals with x-max coordinate comparisons and specifically left insertions
		 if(comp < 0 && evenComponent) 
		 {
			 coordP[2] = curNode.parent.getX();
			 curNode.left = insert(curNode.left, p, !evenComponent, coordP);
		 }
		 
		 //y-max coordinate comparisons and odd level (horizontal line)
		 else if(comp < 0 && !evenComponent) 
		 {
			 coordP[3] = curNode.parent.getY();
			 curNode.left = insert(curNode.left, p, !evenComponent, coordP);
		 }
		 
		 // x-min coordinate comparisons and even level (vertical line)
		 else if (comp > 0 && evenComponent) 
		 {
			 coordP[0] = curNode.parent.getX();
			 curNode.right = insert(curNode.right, p, !evenComponent, coordP);
		 }
		 
		 // y-min coordinate comparisons and even level (vertical line)
		 else if (comp > 0 && evenComponent) 
		 {
			 coordP[1] = curNode.parent.getY();
			 curNode.right = insert(curNode.right, p, !evenComponent, coordP);
		 }
		 
		 //handles ties by placing them in the right subtree
		 else if(!curNode.parent.equals(p)) 
		 {
			 curNode.right = insert(curNode.right, p, !evenComponent, coordP);
		 }
		return curNode;
	 }
	// 	 private Node insert(Node parent, Point2D p) {
// 		 // If parent is null
// 		 if (parent == null) {
// 			 Node node = new Node();
// 			 node.parent = p;
// 			 node.left = null;
// 			 node.right = null;
// 			 size++;
// 			 return node;
// 		 }
// 		 if (p.getX() < parent.parent.getX()) {
// 			 if(parent.left != null) {
// 				 parent.left = insert(parent.left, p);
// 				 return parent;
// 			 } 
// 			 parent.left = insert(parent.left, p);
// 		 } else {
// 				 if (parent.right != null) {
// 					 parent.right = insert(parent.right, p);
// 					 return parent;
// 				 }
// 				 parent.right = insert(parent.right, p);
// 			 }

// 		 return parent;      
// 		 } 
		// Insert 2D points into the tree
	
	 /*comparePts determines whether the current level is even. 
	  * If it's even, the Node's partition line is vertical
	  * If it is odd, the Node's partition line is horizontal*/
	 
	 private double comparePts(Point2D p, Node curNode, boolean evenLvl) 
	 {
		 if(evenLvl) 
		 {
			 return p.getX()-curNode.parent.getX();
		 }
		 else 
		 {
			 return p.getY()-curNode.parent.getX();
		 }
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
