package ex4;
import java.awt.Color;
import java.util.ArrayList;

import ex4.geometry.Circle2D;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Segment2D;
import ex4.geometry.Triangle2D;
/**
 * This class is the "main" class which will be constructed and run as in (Test_Ex4).
 * Ex4: you should implement this class!
 * @author boaz.benmoshe
 *
 */

public class Ex4 implements Ex4_GUI{
	private GUI_Shape_Collection s;
	public static void main(String [] args) {
		Ex4 win = new Ex4();
		GUI_Shape_Collection sc = win.getShape_Collection();
		StdDraw.setCanvasSize(Ex4_Const.Width, Ex4_Const.Height);
		StdDraw.setScale(-0.15, 0.9);
		String file = args[0]; 
		String sortNum = args[1];
		int flag = Integer.parseInt(sortNum); 
		sc.load(file);
		Shape_Comp comp = new Shape_Comp(flag);
		sc.sort(comp);
		win.show();

	}
	public Ex4() {
		this.s =new Shape_Collection();
	}
	public Ex4( Ex4 e) {
		this.s=(GUI_Shape_Collection) e;
	}

	@Override
	public void init(GUI_Shape_Collection g) {
		this.s=g;
	}

	@Override
	public GUI_Shape_Collection getShape_Collection() {
		return this.s;
	}

	@Override
	public void show() {
		for(int i=0; i<s.size(); i++) {
			GUIShape GUI=(GUIShape) s.get(i);
			if( GUI.getShape() instanceof Circle2D) {
				Circle2D c=(Circle2D) GUI.getShape();
				if(GUI.isFilled()==true) {
					StdDraw.setPenColor(GUI.getColor());
					StdDraw.filledCircle(c.centerOfMass().x(), c.centerOfMass().y(), c.getRadius());
				}
				else { 
					StdDraw.setPenColor(GUI.getColor());
					StdDraw.circle(c.centerOfMass().x(), c.centerOfMass().y(), c.getRadius());
				}
			}
			else if( GUI.getShape() instanceof Rect2D) {
				Rect2D r=(Rect2D) GUI.getShape();
				if(GUI.isFilled()==true) {
					StdDraw.setPenColor(GUI.getColor());
					StdDraw.filledRectangle(r.centerOfMass().x(), r.centerOfMass().y(), r.gethalfWidth(), r.gethalfHeight());

				}
				else { 
					StdDraw.setPenColor(GUI.getColor());
					StdDraw.rectangle(r.centerOfMass().x(), r.centerOfMass().y(), r.gethalfWidth(), r.gethalfHeight());
				}
			}
			else if( GUI.getShape() instanceof Segment2D) {
				Segment2D seg=(Segment2D) GUI.getShape();
				StdDraw.setPenColor(GUI.getColor());
				StdDraw.line(seg.getp1X(), seg.getp1Y(), seg.getp2X(), seg.getp2Y());

			}
			else if( GUI.getShape() instanceof Triangle2D) {
				Triangle2D t=(Triangle2D) GUI.getShape();
				if(GUI.isFilled()==true) {
					StdDraw.setPenColor(GUI.getColor());
					StdDraw.filledPolygon(t.xgetPoints(), t.ygetPoints());
				} else 
					StdDraw.setPenColor(GUI.getColor());
				StdDraw.polygon(t.xgetPoints(), t.ygetPoints());

			}
			else if( GUI.getShape() instanceof Point2D) {
				Point2D t=(Point2D) GUI.getShape();
				StdDraw.point(t.x(), t.y());
			}

		}
	}


	@Override
	public String getInfo() {
		return s.toString();
	}
}
