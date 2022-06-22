/*
 * Class Name: Point
 *
 * Student Name: Sarah Narayamy Tavares Silva
 * Student Number: 2960992
 * 
 */
package question02;

import java.util.*;
public final class Point{
	private final double x;
	private final double y;
	
	public Point(double x0, double y0){
		x = x0; y = y0;
	}
	
 	public double x(){
 		return x;
 	}
 	
	public double y(){
		return y;
	}
	
	public String toString(){
		return "("+x+","+y+")";
	}

	public boolean equals(Object ob){
		if(!(ob instanceof Point)) return false;
		Point p = (Point)ob;
		return x == p.x && y == p.y;
	}
}
