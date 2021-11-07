package geometry;
/**
 * This class represents a 2D Triangle in the plane.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Triangle2D implements GeoShape{
	private Point2D p1,p2,p3;
	
	public Triangle2D(Point2D p1 , Point2D p2 ,Point2D p3) {
		this.p1=new Point2D(p1);
		this.p2=new Point2D(p2);
		this.p3=new Point2D(p3);
	}
	public Triangle2D(Triangle2D trian) {
		this.p1 = new Point2D(trian.p1);
		this.p2 = new Point2D(trian.p2);
		this.p3=new Point2D(trian.p3);
	}
	public Triangle2D() { // empty contractor of Triangle
		this.p1 = new Point2D(0,0);
		this.p2 = new Point2D(0,0);
		this.p3=new Point2D(0,0);
	}
	public Point2D getP1() {
		return p1;
	}
	public void setP1(Point2D p1) {
		this.p1 = p1;
	}
	public Point2D getP2() {
		return p2;
	}
	public void setP2(Point2D p2) {
		this.p2 = p2;
	}
	public Point2D getP3() {
		return p3;
	}
	public void setP3(Point2D p3) {
		this.p3 = p3;
	}
	@Override
	public boolean contains(Point2D ot) {
		double EPS=0.0001;
		Triangle2D Triangle=new Triangle2D(p1,p2,p3);
		Triangle2D TR1=new Triangle2D(ot,p2,p3);//first triangle with the new point
		Triangle2D TR2=new Triangle2D(p1,ot,p3);
		Triangle2D TR3=new Triangle2D(p1,p2,ot);
		double area1=Math.abs(TR1.area()+TR2.area()+TR3.area())-Triangle.area();
		if(area1<EPS&&area1>-EPS) {//check if the area of three new triangle are equals to the original triangle
		return true;}
		else return false;
	}

	@Override
	public Point2D centerOfMass() {
		double xCenter=((p1.x()+p2.x()+p3.x())/3);//center of x's points
		double yCenter=((p1.y()+p2.y()+p3.y())/3);//center of y's points
		Point2D centerX=new Point2D(xCenter,yCenter);
		return centerX;
	}

	/**
	 * https://en.wikipedia.org/wiki/Heron%27s_formula
	 * d = peremiter/2;
	 * area = Math.sqrt((d-a)(d-b)(d-c)),  a,b,c are the edges length
	 */
	@Override
	public double area() {
		Segment2D seg1=new Segment2D(p1,p2);
		Segment2D seg2=new Segment2D(p1,p3);
		Segment2D seg3=new Segment2D(p2,p3);
		double d =(seg1.distance()+seg2.distance()+seg3.distance())/2;
		double area = Math.sqrt(d*(d-seg1.distance())*(d-seg2.distance())*(d-seg3.distance()));
	return Math.abs(area);
	}

	@Override
	public double perimeter() {
		Segment2D seg1=new Segment2D(p1,p2);
		Segment2D seg2=new Segment2D(p1,p3);
		Segment2D seg3=new Segment2D(p2,p3);
		return seg1.distance()+seg2.distance()+seg3.distance();//sum of three segments
	}

	@Override
	public void move(Point2D vec) {// move all the segments of the triangle
		p1.move(vec);
		p2.move(vec);
		p3.move(vec);
	}

	@Override
	public GeoShape copy() {//create a new triangle and copy the other triangle
		Triangle2D newTR=new Triangle2D(p1,p2,p3);
		return newTR;
	}

	@Override
	public Point2D[] getPoints() {//array of x and y points of the triangle
		Point2D[] ans = new Point2D[3];
		ans[0] =new Point2D(p1);
		ans[1] =new Point2D(p2);
		ans[2] =new Point2D(p3);
		return ans;
	}
	public double []  xgetPoints() {//simple array of x points of the triangle
		double [] Arr1 = new double[3];
		Arr1[0] = p1.x();
		Arr1[1] = p2.x();
		Arr1[2] = p3.x();
		return Arr1;
	}
	public double []  ygetPoints() {//simple array of y points of the triangle
		double [] Arr2 = new double[3];
		Arr2[0] = p1.y();
		Arr2[1] = p2.y();
		Arr2[2] = p3.y();
		return Arr2;
	}
	@Override
	public String toString() {
		return p1.toString()+","+p2.toString()+","+p3.toString();
	}
}
