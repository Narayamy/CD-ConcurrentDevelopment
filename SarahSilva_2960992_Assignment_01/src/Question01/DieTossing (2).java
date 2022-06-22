/*
 * Class Name: Die Tossing
 *
 * Student Name: Sarah Narayamy Tavares Silva
 * Student Number: 2960992
 * 
 */

package Question01;

/* 
 * Write a program that uses 4 threads that each toss a die a given number of times. In both
 * cases the result of each toss is stored in a shared array. The array is deemed to be large
 * enough to store the result of each throw and each thread should only write to its own array
 * segment. Once the threads have completed their work then the main program counts the
 * frequency of each throw and prints it on the screen. 
 *
*/
import java.lang.Math;
public class DieTossing extends Thread{
	
	private int myArray[];
	private int lb;
	private int ub;
	
	// Constructor
	DieTossing(int myArray[], int lb, int ub){
		this.myArray = myArray;
		this.lb = lb;
		this.ub = ub;
	}
	
	// using the UpperBound and LowerBound to limit the array segments
	// generating randomly each face of the die and storing it into the array
	public void run() {
		for(int i = lb; i<ub; i++) {
			int dieFaces = (int)(Math.random()*6)+1;
			myArray[i] = dieFaces;
		}
	}
}
