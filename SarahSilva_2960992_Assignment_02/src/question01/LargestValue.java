/*
 * Class Name: largestValue
 *
 * Student Name: Sarah Narayamy Tavares Silva
 * Student Number: 2960992
 * 
 */
package question01;

import java.util.concurrent.Callable;

/* 
 * A program is required to find the largest value
 * together with the frequency of its occurrence in
 * a huge integer array. This program will be executed
 * on a multi-core machine and the program must
 * maximize the use of this resource. Using a Threadpool
 * and the Callable interface and the examples
 * outlined in the lectures write a solution to this
 * problem. 
 *
 */

public class LargestValue implements Callable<Integer>{
	
	private int data[];
	private int lb;
	private int ub;
	private int largest;
	
	LargestValue(int data[], int lb, int ub){
		this.lb = lb;
		this.ub = ub;
		this.data = data;
	}
	
	public Integer call() {
		
		// index is set to lb which is defined in the main method
		// by finding the number of processors
		int index = lb;
		// loop through each array 
		while(index < ub) {
			if(data[index] >= data[index+1]) {
				largest = data[index];
				index++;
			}
			else {
				largest = data[index+1];
				index++;
			}
		}
		return largest;
	}
	
	
	
	

}
