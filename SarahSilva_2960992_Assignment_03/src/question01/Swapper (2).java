/*
 * Class Name: Swapper
 *
 * Student Name: Sarah Narayamy Tavares Silva
 * Student Number: 2960992
 * 
 */

package question01;

public class Swapper implements Runnable{
	// repeatedly swap two arbitrary elements of b
	
	// The program is showing a list of different totals because
	// the program is not being executed sequentially hence while
	// Swapper is swapping values in the array the sum is also being made.
	// The correct way would be to synchronize the two classes (methods)
	// or using an Object class to manage the lock. The same problem happens
	// in the Summer class.
	private int data[];
	Object lock;
	private volatile boolean go = true;

	public Swapper(int b[], Object lock) {
		data = b;
		this.lock = lock;
	}

	public void stopSwap() {
		go = false;
	}

	public void run() {
		synchronized(lock) {
			int j;
			int k;
			int t;
			while (go) {
				j = ((int) (Math.random() * 1000)) % data.length;
				k = ((int) (Math.random() * 1000)) % data.length;
				t = data[j];
				data[j] = data[k];
				data[k] = t;
			}
		}
	}
}
