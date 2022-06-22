/*
 * Class Name: CollectionPointTest
 *
 * Student Name: Sarah Narayamy Tavares Silva
 * Student Number: 2960992
 * 
 */
package question02;

public class CollectionPointTest {
	
	public static void main(String[] args) {
		CollectionPoint collectP = new CollectionPoint();
		System.out.println();
		System.out.println("~~~~~ Testing Q1 ~~~~~");
		testQ1();
	}

	public static void testQ1() {
		CollectionPoint collectP = new CollectionPoint();
		Thread t1 = new CollectionPointClient(collectP);
		t1.start();

		Thread t2 = new CollectionPointClient(collectP);
		t2.start();

		try{
			t1.join();
			t2.join();
		}catch(InterruptedException e) {}
/*
		// Sequential version
		for (int j = 0;j < 3;j = j + 1) {
			int x =  (int)(Math.random()*20);
			int y =  (int)(Math.random()*20);
			collectP.add(new Point(x,y));
		}
		System.out.println ();
		collectP.display();
*/
	}
}
