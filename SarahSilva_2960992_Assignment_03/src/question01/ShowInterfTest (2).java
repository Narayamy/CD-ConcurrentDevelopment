/*
 * Class Name: ShowInterfTest
 *
 * Student Name: Sarah Narayamy Tavares Silva
 * Student Number: 2960992
 * 
 */
package question01;

public class ShowInterfTest {
	public static void main(String[] args) {
		int data[] = new int[100];
		Object lock = new Object();
		Runnable summer = new Summer(data, lock);
		Swapper swapper = new Swapper(data, lock);
		Thread tSwapper = new Thread(swapper);
		Thread tSummer = new Thread(summer);
		// initialise the data
		for (int j = 0; j < data.length; j = j + 1) {
			int t = (int) (Math.random() * 100);
			data[j] = t;
		}
		tSummer.start();
		tSwapper.start();
		// wait for tSummer to finish
		try {
			tSummer.join();
		}
		catch (InterruptedException e) {}
		// now stop tSwapper
		swapper.stopSwap();
		
		sumArray(data);
	}
	
	static public void sumArray(int[] f) {
		int sum =0;
		for (int i=0; i<f.length; i++) {
			sum = sum + f[i];
		}
		System.out.println();
		System.out.println("Correct sum: "+sum);
	}
}
