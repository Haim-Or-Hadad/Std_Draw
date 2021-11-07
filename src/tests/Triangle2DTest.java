package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Triangle2D;

class Triangle2DTest {
	static final double EPS = 0.0001;
	
	@Test
	void containstest() {
		Point2D p1=new Point2D(-1,3);
		Point2D p2=new Point2D(-3,-2);
		Point2D p3=new Point2D(2,-4);
		Triangle2D TR=new Triangle2D(p1,p2,p3);
		Point2D ot=new Point2D(-1.73,-1.59);
		assertTrue(TR.contains(ot));
		ot=new Point2D(-1.999,0.525);
		assertFalse(TR.contains(ot));
	}

	@Test
	void perimetertest() {
		Point2D p1=new Point2D(3,5);
		Point2D p2=new Point2D(4,1);
		Point2D p3=new Point2D(1,0);
		Triangle2D TR=new Triangle2D(p1,p2,p3);
		assertEquals(TR.perimeter(),12.670548 , EPS);
	}
	@Test
	void copytest() {
		Point2D p1=new Point2D(3,5);
		Point2D p2=new Point2D(4,1);
		Point2D p3=new Point2D(1,0);
		Triangle2D TR=new Triangle2D(p1,p2,p3);
		Triangle2D TRCOPY=(Triangle2D) TR.copy();
		Point2D [] TRarr =TR.getPoints();
		Point2D [] TRCOPYarr =TRCOPY.getPoints();
		assertArrayEquals(TRarr,TRCOPYarr);
	}@Test
	void centerOfmasstest() {
		Point2D p1=new Point2D(3,5);
		Point2D p2=new Point2D(4,1);
		Point2D p3=new Point2D(1,0);
		Triangle2D tri1=new Triangle2D(p1,p2,p3);
		assertEquals(tri1.centerOfMass().y(),2.0 , EPS);
		assertEquals(tri1.centerOfMass().x(),2.666666 ,EPS);
	}
	@Test
	void movetest() {
		Point2D p1=new Point2D(0,0);
		Point2D p2=new Point2D(2,0);
		Point2D p3=new Point2D(2,2);
		Triangle2D tri1=new Triangle2D(p1,p2,p3);
		Point2D vector=new Point2D(1,1);
		tri1.move(vector);
		Point2D[] arrT1=tri1.getPoints();
		Point2D z1=new Point2D(1,1);
		Point2D z2=new Point2D(3,1);
		Point2D z3=new Point2D(3,3);
		Triangle2D tri2=new Triangle2D(z1,z2,z3);
		Point2D[] arrT2=tri2.getPoints();
		assertArrayEquals(arrT1,arrT2);
	}
	@Test
	void areatest()
	{
		Point2D p1=new Point2D(7,-16);
		Point2D p2=new Point2D(5,24);
		Point2D p3=new Point2D(1,6.6);
		Triangle2D TRarea=new Triangle2D(p1,p2,p3);
		assertEquals(TRarea.area(),97.4,EPS);
	}
	@Test
	void getPointstest() {
		Point2D p1=new Point2D(7,-16);
		Point2D p2=new Point2D(5,24);
		Point2D p3=new Point2D(1,6.6);
		Triangle2D TRarea=new Triangle2D(p1,p2,p3);
		Triangle2D TRarea2=new Triangle2D(p1,p2,p3);
		Point2D [] point12 =TRarea.getPoints();
		assertEquals(point12[0].x(),7);
		assertEquals(point12[1].x(),5);
		assertEquals(point12[0].y(),-16);
		assertEquals(point12[1].y(),24);
		assertEquals(point12[2].x(),1);
		assertEquals(point12[2].y(),6.6);
	}
}
