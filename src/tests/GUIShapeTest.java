package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import ex4.GUIShape;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Segment2D;

class GUIShapeTest {

	@Test
	void testallclass() { //without Data function
		Point2D  p1= new Point2D (1,1);
		Point2D  p2= new Point2D (1,1);
	     Rect2D rect = new Rect2D(p1,p2);
		GUIShape gui=new GUIShape(rect , true , Color.black ,2);
		assertEquals(rect, gui.getShape());//test getShape function
		Segment2D segment = new Segment2D(p1,p2);
		gui.setShape(segment); // test setShape function
		assertEquals(segment ,gui.getShape());// test setShape function
		assertTrue(gui.isFilled());//test isFilled function
		gui.setFilled(false);//test setFilled function
		assertFalse(gui.isFilled());//test isFilled+setFilled function
		assertEquals(gui.getColor(),Color.black);//test getColor function
		gui.setColor(Color.BLUE);//test setColor function
		assertEquals(gui.getColor(),Color.BLUE);//test setColor+getColor function
		assertEquals(gui.getTag(), 2);//test getTag function
		gui.setTag(5);//test setTag function
		assertEquals(gui.getTag(),5);//test getTag+setTAG function
		GUIShape gui2=(GUIShape) gui.copy();
		assertEquals(gui2.getColor(), gui.getColor());//test of copy
		assertEquals(gui2.getShape(), gui.getShape());//test of copy
		}

   @Test
	void testData() {
	   Point2D  p1= new Point2D (1,1);
		Point2D  p2= new Point2D (1,1);
	     Rect2D rect = new Rect2D(p1,p2);
		GUIShape gui=new GUIShape(rect , true , Color.blue ,2);
		String line = "GUIShape,255,true,2,Rect2D,1,1,1,1";
		GUIShape gui3= GUIShape.data(line);
		assertEquals(gui3.getTag(),gui.getTag());
		assertEquals(gui3.getColor(),gui.getColor());
		assertEquals(gui3.getShape().toString(),gui.getShape().toString());
		}

}
