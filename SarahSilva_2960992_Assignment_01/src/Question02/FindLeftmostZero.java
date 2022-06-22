/*
 * Class Name: FindLeftmostZero
 *
 * Student Name: Sarah Narayamy Tavares Silva
 * Student Number: 2960992
 * 
 */
package Question02;

public class FindLeftmostZero extends Thread {
	
	// variables to be used, lb and ub will define the limits of each array
	// data is the array that will be passed in by each thread
	// flag will signal whether the zero was found or not
	// index will determine where on each array the zero was found
	// index should be set to -1 because is considered a index within an array
	private int lb;
	private int ub;
	private int data[];
	private int flag = 0;
	private int index = -1;
	
	// Constructor
	FindLeftmostZero( int data[], int lb, int ub) {
		this.lb = lb;
		this.ub = ub;
		this.data = data;
	}
		
	public void run() {
		
		// index is set to lb which is defined in the main method
		index = lb;
		// loop through each array while there is no zero found
		while(index < ub && data[index] != 0) {
			index++;
		}
		// if index is equal to the length of the array there was 
		// no zero found in the array
		if(index == ub) {
		}
		// signal whether the zero was found
		else {
			flag = -1;
		}
	}

	// getters to access the index and the signal whether the zero was found or not
	public int getFlag() {
		return flag;
	}
	public int getIndex() {
		return index;
	}
}
