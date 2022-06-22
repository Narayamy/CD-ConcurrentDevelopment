/*
 * Class Name: CollectionPoint
 *
 * Student Name: Sarah Narayamy Tavares Silva
 * Student Number: 2960992
 * 
 */
package question02;

import java.util.*;
class CollectionPoint{
	List<Point> list = new ArrayList<>();

	// Adds a new point to the collection
	synchronized void add(Point p){
		list.add(p);
	}
	
	// searches for a point in the class
	synchronized boolean search(Point p){
		boolean found = list.contains(p);
		return found;
	}
	
	// check all points whose x-coordinate matches x
	synchronized List<Point> getAllX(double x){
		List<Point> points = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).x() == x) {
				points.add(list.get(i));
			}
		}
		return points;
	}
	
	// replace an existing point with a new one
	synchronized void replace(Point p1, Point p2){
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(p1)) {
				list.set(i, p2);
			}
		}
	}
	
	// prints the list of points as a String
	public synchronized String toString(){
		if(list.size() == 0) {
			return "[]";
		}
		String rep = "[";
		for(int i = 0; i < list.size() - 1; i++) {
			rep = rep + list.get(i) + ", ";
		}
		return rep + list.get(list.size()-1) + "]"; 
		
	}

	// returns a point in a specific index of the list
	public Point get(int i) {
		return list.get(i);
	}
}

