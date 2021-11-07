package geometry;
/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect2D implements GeoShape{
	private Point2D p1,p2;
	public Rect2D(Point2D p1 , Point2D p2) { // p1 is the right up point
		if(p2.y()>p1.y())                   // p2 is the left down point
		{
		this.p1=new Point2D(p2);
		this.p2=new Point2D(p1);
		}
		else {
			this.p1=new Point2D(p1);
			this.p2=new Point2D(p2);
		}
	}
	public Rect2D( double x1 , double y1 , double x2, double y2) {
		x1=p1.x();
		x2=p2.x();
		y1=p1.y();
		y2=p2.y();
		
	}
	public Rect2D(Rect2D r) {
		this.p1 = new Point2D(r.p1);
		this.p2 = new Point2D(r.p2);
	}
	public Rect2D () {// empty contractor of Rectangle
		this.p1 =new Point2D(0,0);
		this.p2=new Point2D(1,1);
	}
	 
	
	public double gethalfWidth()//this function compute halfWidth of the Rectangle
	{
		double halfwidth=(p1.x()-p2.x())/2;
		return halfwidth;
	}
	public double gethalfHeight()//this function compute halfHeight of the Rectangle
	{
		double halfwidth=(p1.y()-p2.y())/2;
		return halfwidth;
	}

	public double getp1Y() {
		return p1.y();}
	public double getp1X() {
		return p1.x();}
	public double getp2Y() {
		return p2.y();}
	public double getp2X() {
		return p2.x();}

	@Override
	public boolean contains(Point2D ot) { //Computes if the point (ot) falls inside this (closed) shape.
		boolean insideX=((ot.x()<=p1.x())&&(ot.x()>=p2.x()));
		boolean insideY=((ot.y()<=p1.y())&&(ot.y()>=p2.y()));
        if(insideX&&insideY)
		return true;
        else return false;
	}
	@Override
	public Point2D centerOfMass() {
		double middX=(p1.x()+p2.x())/2;//middle of x points
		double middY=(p1.y()+p2.y())/2;//middle of y points
		Point2D po=new Point2D(middX,middY);
		return po ;	


	}
	@Override
	public double area() {
		 double  linex=Math.abs(p1.x()-p2.x());//check the width of rectangle
		 double liney=Math.abs(p1.y()-p2.y());//check the height of rectangle
		return linex*liney;
	}

	@Override
	public double perimeter() {
		 double  linex=Math.abs(p1.x()-p2.x());//check the width of rectangle
		 double liney=Math.abs(p1.y()-p2.y());//check the height of rectangle
		return (linex*2)+(liney*2);
	}

	@Override
	public void move(Point2D vec) {
		p1.move(vec);
		p2.move(vec);
	}
	@Override
	public GeoShape copy() {//create a new rectangle and copy the other triangle 
		Rect2D rect=new Rect2D(p1,p2);
		return rect;
	}

	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] =new Point2D(p2);
		ans[1] =new Point2D(p1);
		return ans;
	}
	
	@Override
	public String toString() {
		return p1.toString()+","+p2.toString();
	}


}
