/*
 * Class Name: DieTossingTest
 *
 * Student Name: Sarah Narayamy Tavares Silva
 * Student Number: 2960992
 * 
 */
package Question01;

import java.util.Arrays;

public class DieTossingTest {

	public static void main(String[] args) {
		// array into which the die faces will be stored 
		int array[] = new int[20];
		
		// Initiating Threads (4 in this case)
		DieTossing t = new DieTossing(array, 0, 5);
		DieTossing t1 = new DieTossing(array, 5, 10);
		DieTossing t2 = new DieTossing(array, 10, 15);
		DieTossing t3 = new DieTossing(array, 15, 20);
		
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
		
		System.out.println(Arrays.toString(array));
		// loop to count the frequency of each face through the array
		int count = 0;
		for(int j = 0; j < array.length; j++) {
			if(array[j]==1) {
				count++;
			}
		}
		System.out.println("Frequency of face 1: " + count);
		// reseting the count
		count = 0;
		for(int j = 0; j < array.length; j++) {
			if(array[j]==2) {
				count++;
			}
		}
		System.out.println("Frequency of face 2: " + count);
		// reseting the count
		count = 0;
		for(int j = 0; j < array.length; j++) {
			if(array[j]==3) {
				count++;
			}
		}
		System.out.println("Frequency of face 3: " + count);
		// reseting the count
		count = 0;
		for(int j = 0; j < array.length; j++) {
			if(array[j]==4) {
				count++;
			}
		}
		System.out.println("Frequency of face 4: " + count);
		// reseting the count
		count = 0;
		for(int j = 0; j < array.length; j++) {
			if(array[j]==5) {
				count++;
			}
		}
		System.out.println("Frequency of face 5: " + count);
		// reseting the count
		count = 0;
		for(int j = 0; j < array.length; j++) {
			if(array[j]==6) {
				count++;
			}
		}
		System.out.println("Frequency of face 6: " + count);
		
	}
}
