package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import ex4.geometry.Circle2D;
import ex4.geometry.Point2D;

class Circle2DTest {
	Point2D p1=new Point2D(0.5,0.5);
	Point2D p2=new Point2D(-0.5,-0.5);
Circle2D co1=new Circle2D(p1,5);
Circle2D co2=new Circle2D(p2,5);
Circle2D co3=new Circle2D(new Point2D(8,8),0.1);

	@Test
	void testGet_center() {
		assertEquals(co1.get_center(),p1);
	}

	@Test
	void testSet_center() {
		co1.set_center(p2);
		assertEquals(p2,co1.get_center());
	}

	@Test
	void testGetRadius() {
		assertEquals(co1.getRadius(),5);
	}

	@Test
	void testContains() {
		assertTrue(co1.contains(new Point2D(-0.5,-0.5)));
		assertTrue(co1.contains(new Point2D(-0.9,-0.5)));
	}
	@Test
	void testCenterOfMass() {
		assertEquals(co3.centerOfMass(),new Point2D(8,8));
	}

	@Test
	void testArea() {
		assertEquals(co1.area(),Math.PI * 25);
		assertNotEquals(co1.area(),Math.PI * 25.001);
	}

	@Test
	void testPerimeter() {
		assertEquals(co1.perimeter(),Math.PI * 10);
		assertNotEquals(co1.perimeter(),Math.PI * 10.001);
	}

	@Test
	void testMove() {
		co3.move(p2);
		assertEquals(co3.get_center(),new Point2D(7.5,7.5));
		assertNotEquals(co3.get_center(),new Point2D(7.51,7.5));
	}

	@Test
	void testCopy() {
		co3=(Circle2D) co1.copy();
		assertEquals(co3.get_center(),co1.get_center());
		assertEquals(co3.getRadius(),co1.getRadius());
	}

	@Test
	void testGetPoints() {
		Circle2D co4=new Circle2D(new Point2D(8,8),0.1);
		Point2D [] circlePoints =co4.getPoints();
			assertEquals(circlePoints[0],new Point2D(8,8));
			assertEquals(circlePoints[1],new Point2D(8,8.1));
			
		}
	}

