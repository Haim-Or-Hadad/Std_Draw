package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;

class Rect2D_tests {

	@Test
	void containstest() {
		Point2D p1=new Point2D(9.899,5.88);
		Point2D p2=new Point2D(-2,-20);
		Rect2D Rect1=new Rect2D(p1,p2);
		Point2D ifinside=new Point2D (9.89,-19.99);
		assertTrue(Rect1.contains(ifinside));
		Point2D outside=new Point2D (10,-21);
		assertFalse(Rect1.contains(outside));
	}
	@Test
	void centerOfMasstest() {
		Point2D p1=new Point2D(-10,-15);
		Point2D p2=new Point2D(10,5.1);
		Rect2D Rect1=new Rect2D(p1,p2);
		Point2D ifcenter=new Point2D (0,-4.95);
		assertEquals(Rect1.centerOfMass(),ifcenter);
		 ifcenter=new Point2D (15.1,3.535);
		assertNotEquals(Rect1.centerOfMass(),ifcenter);
	}
	@Test
	void areatest() {
		Point2D p1=new Point2D(3,6);
		Point2D p2=new Point2D(2,2);
		Rect2D Rect1=new Rect2D(p1,p2);
		double area=4;
		assertEquals(Rect1.area(),area);
		area=3.99;
		assertNotEquals(Rect1.area(),area);
	}
	@Test
	void perimetertest(){
		Point2D p1=new Point2D(3,6);
		Point2D p2=new Point2D(2,2);
		Rect2D Rect1=new Rect2D(p1,p2);
		int perimeter1=10;
		assertEquals(Rect1.perimeter(),perimeter1);
		perimeter1=12;
		assertNotEquals(Rect1.perimeter(),perimeter1);
		}
	@Test
	void movetest() {
		Point2D p1=new Point2D(3,6);
		Point2D p2=new Point2D(2,2);
		Rect2D Rect1=new Rect2D(p1,p2);
		Point2D p3=new Point2D(4,7);
		Point2D p4=new Point2D(3,3);
 		Rect2D Rect2=new Rect2D(p3,p4);
 		Point2D vec=new Point2D(1,1);
 		Rect1.move(vec);
 		for(int i=0; i<2;i++) {
 			assertEquals(Rect2.getPoints()[i],Rect1.getPoints()[i]);}
 		}
		
	@Test
	void copytest() {
		Point2D p1=new Point2D(3,6);
		Point2D p2=new Point2D(2,2);
		Rect2D tocopy=new Rect2D(p1,p2);
		Rect2D newRect=(Rect2D)tocopy.copy();
		for(int i=0; i<2;i++) {
		assertEquals(newRect.getPoints()[i],tocopy.getPoints()[i]);}
	}
	@Test
	void getpointstests() {
		Point2D p1=new Point2D(3,6);
		Point2D p2=new Point2D(2,2);
		Rect2D rect1=new Rect2D(p1,p2);
		Point2D [] point12 =rect1.getPoints();
			assertEquals(point12[0].x(),2);
			assertEquals(point12[1].x(),3);
			assertEquals(point12[0].y(),2);
			assertEquals(point12[1].y(),6);
		}
	}
	
	

