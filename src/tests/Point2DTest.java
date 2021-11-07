package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Circle2D;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;

class Point2DTest {
	static final double EPS = 0.0001;
	@Test
	void testAdd() {
			Point2D po1=new Point2D(1,1);
			Point2D po2=new Point2D(2.5,-2.5);
			Point2D add=new Point2D(1.5,-3.5);
			assertEquals(po1.add(add).x(),po2.x());
			assertEquals(po1.add(add).y(),po2.y());
		
	}

	@Test
	void testDistance() {
		Point2D po1=new Point2D(-7.9,3.2);
		assertEquals(po1.distance(),8.523496935,EPS);
		Point2D po2=new Point2D(0.00001,-0.11);
		assertEquals(po2.distance(),0.1100000005,EPS);
	}

	@Test
	void testDistancePoint2D() {
		Point2D po1=new Point2D(10,-5);
		Point2D po2=new Point2D(3.9,7.1);
		assertEquals(po1.distance(po2),13.55064574,EPS);
		
	}

	@Test
	void testEqualsObject() {
		Point2D po1=new Point2D(4,4);
		Point2D po2=new Point2D(4,4);
		Point2D po3=new Point2D(7,6);
		assertTrue(po1.equals(po2));
		assertFalse(po1.equals(po3));
	}
	@Test
	void testClose2equalsPoint2DDouble() {
		Point2D po1=new Point2D(4,4);
		Point2D po2=new Point2D(4.000000000001,4.000000001);
		assertTrue(po1.close2equals(po2));
		assertTrue(po1.close2equals(po2,EPS));
	}


	@Test
	void testVector() {
		Point2D po1=new Point2D(4,4);
		Point2D target=new Point2D(10,10);
		assertEquals(po1.vector(target),new Point2D(6,6));
	}


	@Test
	void testMove() {
		Point2D po1=new Point2D(4,4);
		Point2D po2=new Point2D(-5.1,7.9);
		Point2D po3=new Point2D(-1.1,11.9);
		po1.move(po2);
		assertEquals(po1.x(),po3.x(),EPS);
		assertEquals(po1.y(),po3.y(),EPS);
	}

	@Test
	void testCopy() {
		Point2D po1=new Point2D(5,4);
		Point2D po2= (Point2D) po1.copy();
		assertEquals(po2,po1);
	}

	@Test
	void testGetPoints() {
		Point2D center1=new Point2D(5,5);
		Point2D center2=new Point2D(5,5);
	    Point2D [] points1 =center1.getPoints();
	    Point2D [] points2 =center2.getPoints();
		assertArrayEquals(points1,points2);
		Point2D center3=new Point2D(5.1,5);
		Point2D [] points3 =center3.getPoints();
		assertArrayNotEquals(points3,points2);
	}

	private void assertArrayNotEquals(Point2D[] points3, Point2D[] points2) {
		// TODO Auto-generated method stub
		
	}

}
