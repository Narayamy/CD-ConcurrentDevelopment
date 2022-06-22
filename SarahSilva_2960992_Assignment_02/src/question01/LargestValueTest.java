package question01;

import java.util.concurrent.*;
import java.util.*;
public class LargestValueTest {

	// get the number of processors in the machine
	static int nProcessors = Runtime.getRuntime().availableProcessors();
	// determine how many threadPool will be existing
	// according to the number of processors
	static ExecutorService pool = Executors.newFixedThreadPool(nProcessors);
	static final int N = 10;
	
	public static void main(String[] args) {
		
		// create and populate the array to be split
		// into n threads (number of processors)
		int data[] = new int[N];
		for(int j = 0; j<N; j++) {
			data[j] = (int)(Math.random()*N);
		}
		
		// array list which will store the largest value
		// found on each thread
		ArrayList <Future<Integer>> futureLst = new ArrayList<Future<Integer>>();
		
		// array to determine the limits of each thread
		// lowerbound and upperbound
		int[] index = new int[nProcessors+1];
		// loop through the index array determining the
		// lowerbound and upperbound on the array to be passed in
		for (int i=0; i<=nProcessors; i++) {
			index[i] = (i*data.length)/nProcessors;
		}
		// looping again to store the the largest value on each thread in "f"
		// and adding it to the future array
		for(int j = 0; j < index.length-1 ;j++){
			Future<Integer> f = pool.submit(new LargestValue(data, index[j], index[j+1]));
			futureLst.add(f);
		}
		
		// array result to store the results found on each thread
		int result[] = new int[index.length - 1];
		// loop through it to store the largest value in the future array
		for(int k = 0; k < result.length; k++){
			try {
				Future<Integer> f = futureLst.get(k);
				result[k] = f.get();
			}
			catch (InterruptedException e) {}
			catch (ExecutionException e) {};
		}
		
		for(int m = 0; m < result.length; m++){
			
		}
				
		
		
		
	}

}
