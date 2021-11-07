package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ex4.GUIShape;
import ex4.GUI_Shape;
import ex4.GUI_Shape_Collection;
import ex4.Shape_Collection;
import ex4.Shape_Comp;
import ex4.geometry.Circle2D;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;

class Shape_CollectionTest {

	static final double EPS = 0.0001;

	@Test
	void testallclass() {
		Shape_Collection list1=new Shape_Collection();
		Point2D p1 = new Point2D(1,2);
		Circle2D c1 = new Circle2D(p1,0.7);
		GUI_Shape geo1 = new GUIShape(p1,false, Color.blue, 0);
		GUI_Shape geo2= new GUIShape(c1,true, Color.red, 1);
		list1.add(geo1);//test add function
		list1.add(geo2);
		assertEquals(list1.get(0),geo1);//test get function
		Shape_Collection list2=new Shape_Collection();
		int sizeoflist=list1.size();
		assertEquals(sizeoflist,2);//test size function
		GUI_Shape geo3= new GUIShape(c1,true, Color.black, 1);
		assertEquals(list1.removeElementAt(0),geo1);//test removeElementAt function
		list1.addAt(geo3, 0);
		list2.addAt(geo3, 0);
		assertEquals(list1.get(0),list2.get(0));//test addAt function
		list1.removeAll();//test removeAll 
		list2.removeAll();//test removeAll 
		list1.add(geo2);
		list1.add(geo1);
		 Shape_Comp comp = new Shape_Comp(0);//Sort_By_Tag = 0
		list1.sort(comp);
		list1.sort(comp);
		assertEquals(list1.get(0),geo1); //test for sort function
		comp = new Shape_Comp(5); //Sort_By_Anti_Perimeter = 5
		list1.sort(comp);
		assertEquals(list1.get(0),geo2);//test for sort function
	}
	@Test
	void copytest() {
		Shape_Collection list1=new Shape_Collection();
		Point2D p1 = new Point2D(1,2);
		Circle2D c1 = new Circle2D(p1,0.7);
		GUI_Shape geo1 = new GUIShape(p1,false, Color.blue, 0);
		GUI_Shape geo2= new GUIShape(c1,true, Color.red, 1);
		list1.add(geo1);
		list1.add(geo2);
		GUI_Shape_Collection s=list1.copy();
		assertEquals(s.get(0),list1.get(0));
	}
	@Test
	void saveandloadtest() {
		Shape_Collection list1=new Shape_Collection();
		Point2D p1 = new Point2D(1,2);
		Circle2D c1 = new Circle2D(p1,0.7);
		GUI_Shape geo1 = new GUIShape(p1,false, Color.blue, 0);
		GUI_Shape geo2= new GUIShape(c1,true, Color.red, 1);
		list1.add(geo1);
		list1.add(geo2);
		list1.save("Jtest_save.txt");
		Shape_Collection list2=new Shape_Collection();
	    list2.load("Jtest_save.txt");
	    assertEquals(list1.get(0).getColor(),list2.get(0).getColor());
	    assertEquals(list1.get(0).getShape(),list2.get(0).getShape());
	    assertEquals(list1.get(0).getTag(),list2.get(0).getTag());
	    
}
	@Test
	void getboundingboxtest() {
		Point2D p1 = new Point2D(1,2);
		Rect2D r1 = new Rect2D(new Point2D(5,5),new Point2D(10,10));
		GUI_Shape geo1 = new GUIShape(p1,false, Color.blue, 0);
		GUI_Shape geo2= new GUIShape(r1,true, Color.red, 1);
		Shape_Collection list1=new Shape_Collection();
		list1.add(geo1);
		list1.add(geo2);
        Rect2D boundingbox=list1.getBoundingBox();
	    assertEquals(boundingbox.getp1X(),10.0,EPS);
	    assertEquals(boundingbox.getp1Y(),10.0,EPS);
	    assertEquals(boundingbox.getp2X(),1,EPS);
	    assertEquals(boundingbox.getp2Y(),1,EPS);
	}
}




