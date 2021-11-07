package ex4;

import java.awt.Color;
import java.awt.Shape;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;

import ex4.geometry.Circle2D;
import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Segment2D;
import ex4.geometry.Triangle2D;
/**
 * This class represents a collection of GUI_Shape.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Shape_Collection implements GUI_Shape_Collection{
	private  ArrayList<GUI_Shape> GShapes;

	public Shape_Collection(){
		this.GShapes=new ArrayList<GUI_Shape>();
	}

	public Shape_Collection(ArrayList<GUI_Shape> shapes) {
		this.GShapes=new ArrayList<GUI_Shape>();
		for(int i=0; i<shapes.size(); i++){
			GShapes.add(shapes.get(i));}
	}
	public Shape_Collection(Shape_Collection sh) {
		this.GShapes.addAll(sh.GShapes);
	}


	@Override
	public GUI_Shape get(int i) {//return gui_shape in i's place
		return this.GShapes.get(i);
	}

	@Override
	public int size() {//return the size of the array
		return this.GShapes.size();
	}

	@Override
	public GUI_Shape removeElementAt(int i) {//remove all the elements from the array
		GUIShape s=(GUIShape) GShapes.remove(i);
		return s;
	}

	@Override
	public void addAt(GUI_Shape s, int i) {//add a new gui_shape in i's place
		this.GShapes.add(i, s);
	}
	@Override
	public void add(GUI_Shape s) {//add to the array a new gui_shape
		GShapes.add(s);
	}
	@Override
	public GUI_Shape_Collection copy() {//return a copy of other gui_shape
		return new Shape_Collection(this.GShapes);
	}

	@Override
	public void sort(Comparator<GUI_Shape> comp) {//sort the array by comp
		GShapes.sort(comp);
	}

	@Override
	public void removeAll() {//remove all the gui_shape from the array
		this.GShapes.removeAll(GShapes);
	}

	@Override
	public void save(String file) {//this function save array of gui_shape in text file 
		try {
			FileWriter myWriter = new FileWriter(file);//create a new file 
			for(int i=0;i<GShapes.size();i++) {
				myWriter.write(GShapes.get(i).toString());//write the i's gui_shape in the file 
				if(i<GShapes.size() - 1) {//create a new line until the last line
					myWriter.write("\r\n");
				}
			}
			myWriter.close();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public void load(String file) {
		try {
			File MyCollect= new File(file);
			Scanner myReader=new Scanner(MyCollect);
			int i=0;
			while(myReader.hasNextLine()) {//while has line in the text file 
				String data=myReader.nextLine();
				GUIShape gui1=GUIShape.data(data);
				GShapes.add(gui1);
				i=i+1;
			}
			myReader.close();
		}
		catch(Exception e) {	
			e.printStackTrace();}
	}
	@Override
	public Rect2D getBoundingBox() {
		ArrayList<Double> Xarr=new ArrayList<Double>();//create a new list for x's points
		ArrayList<Double> Yarr=new ArrayList<Double>();//create a new list for y's points
		for (int i = 0; i < GShapes.size(); i++) {
			GeoShape geo=GShapes.get(i).getShape();//new geoshape from the list
			if (geo instanceof Point2D) {
				Point2D p=(Point2D)geo;//casting to Point2D
				Xarr.add(p.x());
				Yarr.add(p.y());
			}
			if (geo instanceof Circle2D) {//check if geoshape is Circle2D
				Circle2D c=(Circle2D)geo;//casting to Point2D
				Point2D ccenter=c.get_center();
				Xarr.add(ccenter.x()+c.getRadius());//compute the point with the radius
				Xarr.add(ccenter.x()-c.getRadius());//compute the point with the radius
				Yarr.add(ccenter.y()+c.getRadius());//compute the point with the radius
				Yarr.add(ccenter.y()-c.getRadius());//compute the point with the radius
				Xarr.add(ccenter.x());
				Yarr.add(ccenter.y());
			}
			if (geo instanceof Segment2D) {//check if geoshape is Segment2D
				Segment2D s=(Segment2D)geo;//casting to Segment2D
				Xarr.add(s.getp1X());
				Xarr.add(s.getp2X());
				Yarr.add(s.getp1Y());
				Yarr.add(s.getp2Y());
			}
			if (geo instanceof Rect2D) {
				Rect2D r=(Rect2D)geo;//casting to Rect2D
				Xarr.add(r.getp1X());
				Xarr.add(r.getp2X());
				Yarr.add(r.getp1Y());
				Yarr.add(r.getp2Y());
			}
			if (geo instanceof Triangle2D) {
				Triangle2D t=(Triangle2D)geo;//casting to Triangle2D
				Xarr.add(t.getP1().x());
				Xarr.add(t.getP2().x());
				Xarr.add(t.getP3().x());
				Yarr.add(t.getP1().y());
				Yarr.add(t.getP2().y());
				Yarr.add(t.getP3().y());
			}			
		}
		Xarr.sort(Comparator.naturalOrder());//sort the Xpoints in the arraylist
		double minxpoint=Xarr.get(Xarr.size()-1);
		double maxxpoint=Xarr.get(0);
		Yarr.sort(Comparator.naturalOrder());//sort the Ypoints in the arraylist
		double maxypoint=Xarr.get(0);
		double minypoint=Xarr.get(Yarr.size()-1);
		return new Rect2D(new Point2D(minxpoint,minypoint),new Point2D(maxxpoint,maxypoint));//return the bounding box 


	}
	@Override
	public String toString() {
		return GShapes.toString();
	}
}
