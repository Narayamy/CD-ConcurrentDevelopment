/*
 * Class Name: CollectionPointClient
 * Student Name: Sarah Narayamy Tavares Silva
 * Student Number: 2960992
 * 
 */
package question02;

public class CollectionPointClient extends Thread {
	private CollectionPoint collectP;

	CollectionPointClient(CollectionPoint c) {
		this.collectP = c;
	}

	public void run() { // simulate some activity
		for (int j = 0;j < 5;j = j + 1) {
			double x = ((int)(Math.random()*100))/10;
			double y = ((int)(Math.random()*100))/10;
			collectP.add(new Point(x,y));
		}
		
		System.out.print("Collection Point: ");
		System.out.println(collectP.toString()); // prints once for each thread

		Point p = collectP.get(0);
		System.out.println(p+" exists (true): "+collectP.search(p));
		System.out.println("List of at least 1 "+collectP.getAllX(p.x()));
		collectP.add(new Point(p.x(),9));
		System.out.println("List of at least 2 (3 for second thread) "+collectP.getAllX(p.x()));
		collectP.replace(p, new Point(5,5)); // only replaces once as all threads will replace the same point.
		System.out.println("Collection Point (1st point should be(5.0, 5.0): ");
		System.out.println(collectP.toString());
	}
}