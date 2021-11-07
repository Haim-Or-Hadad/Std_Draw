package ex4;
/**
 * This class implements the GUI_shape.
 * Ex4: you should implement this class!
 * @author I2CS
 */
import java.awt.Color;

import javax.swing.text.Segment;

import ex4.geometry.Circle2D;
import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Segment2D;
import ex4.geometry.Triangle2D;

public class GUIShape implements GUI_Shape{
	private Color Color;
	private boolean Filled;
	private int tag;
	private GeoShape Shape;
	private String name;

	public GUIShape(GeoShape Shape , boolean Filled ,Color Color, int tag) {
		this.Color=Color;
		this.Filled=Filled;
		this.tag=tag;
		this.Shape=Shape;
		this.name=Shape.getClass().getSimpleName();
	}

	public GUIShape(GUIShape GUI) {
		this.Color=GUI.Color;
		this.Filled=GUI.Filled;
		this.tag=GUI.tag;
		this.Shape=GUI.Shape;
	}

	public GUIShape() {
		this.Color=null;
		this.Filled=true;
		this.tag=0;
		this.Shape=null;
	}


	@Override
	public GeoShape getShape() {//return the shape of the guishape
		return this.Shape;
	}

	@Override
	public void setShape(GeoShape g) {// set a new geoshape 
		this.Shape=g;
	}

	@Override
	public boolean isFilled() { //check if the  guishapeif filled
		if(Filled==true)return true;
		else return false;	}

	@Override
	public void setFilled(boolean filled) {//set that the guishape be filled
		this.Filled=filled;
	}

	@Override
	public Color getColor() {//get the color of the guishape
		return Color;
	}

	@Override
	public void setColor(Color cl) {//set a new color to the guishape 
		this.Color=cl;
	}

	@Override
	public int getTag() {//return the tag of the shape
		return this.tag;
	}

	@Override
	public void setTag(int tag) {//set a new tag to the shape
		this.tag=tag;
	}

	@Override
	public GUI_Shape copy() {//create a new GUIShape and copy the other GUIShape
		GUIShape GUI=new GUIShape(this.Shape , this.Filled ,this.Color,this.tag);
		return GUI;
	}
	@Override
	public String toString() {
		return "GUIShape,"+ (this.Color.getRGB()&0xffffff)+","+this.Filled+","+this.tag+","+this.name+","+this.Shape;
	}


	public static GUIShape data(String file) {//this function take a line from a text file and add to the list a new guishape 
		System.out.println(file);
		String [] str=file.split(",");//split the line and enter to array 
		GUIShape gui1=new GUIShape();

		gui1.setColor(java.awt.Color.decode(str[1]));//set the color from the array 
		gui1.setFilled(Boolean.parseBoolean(str[2])); //set the value of filled  from the array 
		gui1.setTag(Integer.parseInt(str[3]));//set tag from the array 
		double point1=Double.parseDouble(str[5]);
		double point2=Double.parseDouble(str[6]);
		if(str[4].equals("Point2D")) { 
			gui1.setShape(new Point2D(point1,point2));}//set Point2D
		else if (str[4].equals("Circle2D")) {
			double radius1=Double.parseDouble(str[7]);
			Point2D cent=new Point2D(point1,point2);
			gui1.setShape(new Circle2D(cent,radius1));}//set Circle2D
		else if(str[4].equals("Segment2D")) {
			double point3=Double.parseDouble(str[7]);
			double point4=Double.parseDouble(str[8]);
			Point2D seg1=new Point2D(point1,point2);
			Point2D seg2=new Point2D(point3,point4);
			gui1.setShape(new Segment2D(seg1,seg2));}//set Segment2D
		else if(str[4].equals("Rect2D")) {
			double point3=Double.parseDouble(str[7]);
			double point4=Double.parseDouble(str[8]);
			Point2D rec1=new Point2D(point1,point2);
			Point2D rec2=new Point2D(point3,point4);
			gui1.setShape(new Rect2D(rec1,rec2));}//set Rect2D
		else if(str[4].equals("Triangle2D")) {
			double point3=Double.parseDouble(str[7]);
			double point4=Double.parseDouble(str[8]);
			double point5=Double.parseDouble(str[9]);
			double point6=Double.parseDouble(str[10]);
			Point2D tri1=new Point2D(point1,point2);
			Point2D tri2=new Point2D(point3,point4);
			Point2D tri3=new Point2D(point5,point6);
			gui1.setShape(new Triangle2D(tri1,tri2,tri3));//set Triangle2D
		}
		return gui1;
	}


}




