/**
 * MyTreeSetTest.java
 *
 *Student name: Sarah Narayamy Tavares Silva
 *Student number: 2960992
 *
 */

package Q01;


import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.function.Function;

public class TreeTest {
	public static void main(String[] args){
		//create MyTreeSet & instances of MyTreeSet
		MyTreeSet<Integer> tSet = new MyTreeSet<Integer>();

		//create Predicate and Function variables
		Predicate<Integer> odd = x -> x % 2 != 0; // odd numbers
		Predicate<Integer> positive = x -> x > 0; // positive numbers
		Function<Integer,Integer> inc = x -> x + 1;

		// Test all the methods of MyTreeSet
		Set<Integer> aSet = new TreeSet<Integer>();
		//add initial values of 10 & 100 to TreeSet
		aSet.add(10);
		aSet.add(100);
		tSet.add(aSet);
		System.out.println(tSet.printSet());

		//add value of 20 and print
		tSet.add(20);
		System.out.println(tSet.printSet());

		//call the  method(s) and print them to the screen
		System.out.println("For All (odd):  should be false: "+tSet.forAll(odd));
		System.out.println("For All (positive) should be true: "+tSet.forAll(positive));
		System.out.println("Exists (odd) should be false: "+tSet.exists(odd));
		System.out.println("Exists (positive) shuld be true: "+tSet.exists(positive));
		System.out.println("Count should be 0: "+tSet.count(odd));
		System.out.println("Map  should be 11 21 101: "+tSet.map(inc));
		System.out.println("Filter  should be empty: "+tSet.filter(odd));
		System.out.println("MapFilter  should be 11 21 101: "+tSet.mapFilter(inc, odd));

		tSet.add(5);	tSet.add(7);
		System.out.println();
		System.out.println(tSet.printSet());
		System.out.println("For All (odd) should be false: "+tSet.forAll(odd));
		System.out.println("For All (positive) should be true: "+tSet.forAll(positive));
		System.out.println("Exists (odd) should be true: "+tSet.exists(odd));
		System.out.println("Exists (positive) should be true: "+tSet.exists(positive));
		System.out.println("Count should be 2: "+tSet.count(odd));
		System.out.println("Map should be 6 8 11 21 101: "+tSet.map(inc));
		System.out.println("Filter should be 5 7: "+tSet.filter(odd));
		System.out.println("MapFilter should be 11 21 101: "+tSet.mapFilter(inc, odd));

	}
}