/*
 * Class Name: Summer
 *
 * Student Name: Sarah Narayamy Tavares Silva
 * Student Number: 2960992
 * 
 */
package question01;

public class Summer implements Runnable{
	// display the sum of the elements of b
	private int data[];
	Object lock;

	public Summer(int b[], Object lock) {
		data = b;
		this.lock = lock;
	}

	public void run() {
		synchronized(lock) {
			for (int j = 0; j < 10; j = j + 1) {
				int total = 0;
				for (int i = 0; i < data.length; i++) {
					try {
						Thread.sleep(2);
					}
					catch (Exception e) {}
					total = total + data[i];
				}
				System.out.println("Sum = " + total);
			}
		}
	}
}
