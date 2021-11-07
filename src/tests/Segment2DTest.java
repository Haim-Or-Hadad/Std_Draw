package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Segment2D;

class Segment2DTest {
	static final double EPS = 0.0001;
	@Test
	void testcontains() {
		Point2D p1=new Point2D(3,2);
		Point2D p2=new Point2D(1,1);
		Segment2D seg1=new Segment2D(p1,p2);
		Point2D p3=new Point2D(2,1.5);
	   assertTrue(seg1.contains(p3));
	   
	}
	@Test
	void centerOfMasstest(){
		Point2D p1=new Point2D(2,5);
		Point2D p2=new Point2D(1,2);
		Segment2D seg1=new Segment2D(p1,p2);
		Point2D center=new Point2D(1.5,3.5);
		assertEquals(seg1.centerOfMass(),center);
		Point2D notcenter=new Point2D(1.499,3.5);
		assertNotEquals(seg1.centerOfMass(),notcenter);

	}
	@Test
	void perimitertest() {
		Point2D p1=new Point2D(1,1);
		Point2D p2=new Point2D(0,0);
		Segment2D seg1=new Segment2D(p1,p2);
		assertEquals(seg1.perimeter(), 2*Math.sqrt(2),EPS);
		assertNotEquals(seg1.perimeter(),2);
	}
	@Test
	void movetest() {
		Point2D vec=new Point2D(3,3);
		Point2D p1=new Point2D(1,1);
		Point2D p2=new Point2D(0,0);
		Segment2D seg=new Segment2D(p1,p2);
		seg.move(vec);
			assertEquals(seg.getp1Y(),4);
			assertEquals(seg.getp2Y(),3);
			assertEquals(seg.getp1X(),4);
			assertEquals(seg.getp2X(),3);
	}
	@Test
	void  distance() {
		Point2D p1=new Point2D(0,2);
		Point2D p2=new Point2D(0,-2);
		Segment2D seg1=new Segment2D(p1,p2);
		assertEquals(seg1.distance(),4 ,EPS);
	}
	@Test
	void getpoints() {
		Point2D p1=new Point2D(3,6);
		Point2D p2=new Point2D(2,2);
		Segment2D seg1=new Segment2D(p1,p2);
		Point2D [] point12 =seg1.getPoints();
			assertEquals(point12[0].x(),3);
			assertEquals(point12[1].x(),2);
			assertEquals(point12[0].y(),6);
			assertEquals(point12[1].y(),2);
		}
	}

	
	


