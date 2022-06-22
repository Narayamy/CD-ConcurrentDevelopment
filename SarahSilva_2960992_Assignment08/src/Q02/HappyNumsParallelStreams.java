/*
 * HappyNumsParallelStreams.java
 *
 */

package Q02;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.function.*;
import java.util.stream.*;
import java.util.stream.Collectors.*;

public class HappyNumsParallelStreams{
	public static void main(String args[]){
		Predicate<Integer> happy = x ->{
			HappySad hp = new HappySad();
			return hp.isHappy(x);
		};
		
		//Creating a list and populating it with values from 1 to 1000000
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for(int i=0; i<1000000; i++) {
			lst.add(i+1);
		}
		
		//Getting current time before starting the streams
		long startTime = System.currentTimeMillis();
		
		//Initiating the streams
		long total = lst.parallelStream().filter(happy).count();
		   	
		//Getting the current time after the streams have finished their process
		long endTime = System.currentTimeMillis();
		
		//Calculating how long it took to finish the process in milliseconds
		long runningTime = endTime - startTime;
		    	
		//Printing results
		System.out.println("Total: " + total);
		System.out.println("Running Time = " + runningTime/1000.0 + " secs");
		
		
		
		/*
    	 * Parallel streams are not be the most efficient way of processing in this case, because
    	 * while the first program is separating the array in equal parts and allocating a thread to each
    	 * available processor to work in the array section it was given to, the second one is
    	 * iterating, applying the filter and counting all at the same time, while the processor
    	 * is probably still being used to add elements to the list.
    	 * 
    	 */
				
	}
}