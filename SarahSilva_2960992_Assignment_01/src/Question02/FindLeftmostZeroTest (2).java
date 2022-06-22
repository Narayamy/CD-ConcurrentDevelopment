/*
 * Class Name: FindLeftmostZeroTest
 *
 * Student Name: Sarah Narayamy Tavares Silva
 * Student Number: 2960992
 * 
 */
package Question02;

public class FindLeftmostZeroTest {

	static final int N = 1000000;
	
	public static void main(String[] args) {
		
		// create and populate the array to be split into 4 threads
		int array[] = new int[N];
		for(int j = 0; j<N; j++) {
			array[j] = (int)(Math.random()*N);
		}
		
		// lowerbound starts at zero
		// upperbound is the division of the array by 4
		int lb = 0;
		int ub = N/4;
		
		// Initiating Threads (4 in this case)
		FindLeftmostZero t = new FindLeftmostZero(array, lb, ub);
		// updating the values for lowerbound and upperbound for each thread
		lb = ub;
		ub = ub+(N/4);
		FindLeftmostZero t1 = new FindLeftmostZero(array, lb, ub);
		lb = ub;
		ub = ub+(N/4);
		FindLeftmostZero t2 = new FindLeftmostZero(array, lb, ub);
		lb = ub;
		ub = ub+(N/4);
		FindLeftmostZero t3 = new FindLeftmostZero(array, lb, ub);
		
		// Running the created Threads
		t.start();
		t1.start();
		t2.start();
		t3.start();
		
		// Wait until all Threads have finished
		try {
			// join allow the threads to work in parallel
			t.join();
			t1.join();
			t2.join();
			t3.join();
		}
		catch(InterruptedException e) {
		}

		// if the signal is zero means there was no zero found in 
		// any of the threads
		if(t.getFlag() == 0 && t1.getFlag() == 0 && t2.getFlag() == 0 && t3.getFlag() == 0) {
			System.out.println("Zero Not found");
		}
		
		// Otherwise if the signal is positive to found a zero
		// it's needed to determine in which array (thread) the zero was found
		else if(t.getFlag() == -1) {
			System.out.println("Leftmost zero found at position: " + t.getIndex());
		}
		else if(t1.getFlag() == -1) {
			System.out.println("Leftmost zero found at position: " + t1.getIndex());
		}
		else if(t2.getFlag() == -1) {
			System.out.println("Leftmost zero found at position: " + t2.getIndex());
		}
		else {
			System.out.println("Leftmost zero found at position: " + t3.getIndex());
		}

	}
}
