package geometry;

/**
 * This class represents a 2D segment on the plane, 
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Segment2D implements GeoShape{
	private Point2D p1,p2;

	public Segment2D(Point2D p1 , Point2D p2) {
		this.p1=new Point2D(p1);
		this.p2=new Point2D(p2);
	}
		public Segment2D(Segment2D line) {
			this.p1 = new Point2D(line.p1);
			this.p2 = new Point2D(line.p2);
		} 
		public Segment2D() {// empty contractor of Segment
			this.p1 = new Point2D(0,0);
			this.p2 = new Point2D(0,0);
		}
		public Point2D getP1() { //return p1 Point
			return p1;}
		public void setP1(Point2D p1) {//set a new p1 Point
			this.p1 = p1;}
		public Point2D getP2() {//return p2 Point
			return p2;}
		public void setP2(Point2D p2) {//set a new p2 Point
			this.p2 = p2;}
		public double getp1Y() {//return the value of y of p1(point)
			return p1.y();}
		public double getp1X() {//return the value of x of p1(point)
			return p1.x();}
		public double getp2Y() {//return the value of y of p2(point)
			return p2.y();}
		public double getp2X() {//return the value of x of p2(point)
			return p2.x();}
	@Override
	public boolean contains(Point2D ot) {
		  double slope= ((p1.y()-p2.y())/(p1.x()-p2.x()));
		  double n=(p1.y()-(slope*p1.x())); 
		  double Yot=slope*ot.x()+n;
		  if((ot.y()==Yot)&&ot.x()==(Yot-n)/slope) {
			  return true;
		    }
		  else  
			  return false;
		 }

	@Override
	public Point2D centerOfMass() {
		double Xcenter=(p1.x()+p2.x())/2;//compute the center of x's points
		double Ycenter=(p1.y()+p2.y())/2;//compute the center of y's points
		Point2D center=new Point2D(Xcenter,Ycenter);
		return center;
	}

	/**
	 */
	@Override
	public double area() {
		return 0;
	}

	@Override
	public double perimeter() {
		double x=p1.x()-p2.x();
		double y=p1.y()-p2.y();
		return 2*Math.sqrt(x*x+y*y);
	}
	public double distance() {
		double x=p1.x()-p2.x();
		double y=p1.y()-p2.y();
		return Math.sqrt(x*x+y*y);
	}

	@Override
	public void move(Point2D vec) {//use in move function of Point2D
		p1.move(vec);
		p2.move(vec);
	}

	@Override
	public GeoShape copy() {//create a new segment and copy the other segment
		Segment2D segcopy=new Segment2D(p1,p2);
		return segcopy;
	}
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] =new Point2D(p1);
		ans[1] =new Point2D(p2);
		return ans;
	}
	@Override
	public String toString() {
		return p1.toString()+","+p2.toString();
	}
}