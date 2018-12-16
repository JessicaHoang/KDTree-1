
public class Main {

	public static void main(String[] args) {
		Rect r = new Rect();
		r.drawRect();
		
		/*create a KDTree*/
		KdTree kdTree = new KdTree();
		
		/*creating point coordinate 1*/
		double x1 = 50;
		double y1 = 80;
		Point2D p = new Point2D(x1,y1);
		KdTree.insert(p);
		
		/*Testing Search Method*/

	}

}
