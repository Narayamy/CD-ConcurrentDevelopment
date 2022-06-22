/**
 * MyTreeSet.java
 *
 *Student name: Sarah Narayamy Tavares Silva
 *Student number: 2960992
 *
 */

package Q01;

import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyTreeSet<E> implements MySet<E>{
	private TreeSet<E> data = new TreeSet<>();
	
	//Add an element to the TreeSet
	public void add(E x) {
		synchronized(this){
			data.add(x);
		}
	}
	
	//Add a set to the existing TreeSet
	public void add(Set<E> s) {
		synchronized(this){
			data.addAll(s);		
		}
	}
	
	//Check if all elements in the TreeSet satisfy the predicate
	public boolean forAll(Predicate<E> pr) {
		synchronized(this){
			return data.parallelStream().allMatch(pr);
		}
	}
	
	//Check if there is any element in the TreeSet that satisfies the predicate
	public boolean exists(Predicate<E> pr) {
		synchronized(this){
			return data.parallelStream().anyMatch(pr);
		}
	}
	
	//Counts the number of elements that satisfy the predicate
	public long count(Predicate<E> pr) {
		synchronized(this){
			return data.parallelStream().filter(pr).count();
		}
	}
	
	//Applies a given function to the elements and collects the results in a new TreeSet
	public Set<E> map(Function<E, E> fn) {
		synchronized(this){
			return data.parallelStream().map(fn).collect(Collectors.toCollection(TreeSet::new));
		}
	}
	
	//Filters the elements in the TreeSet by using the predicate. Collects the results in a new TreeSet
	public Set<E> filter(Predicate<E> pr) {
		synchronized(this){
			return data.parallelStream().filter(pr).collect(Collectors.toCollection(TreeSet::new));
		}
	}
	
	//Applies the function that is passing in to the elements in the TreeSet and filters the results by using 
	//the predicate. Collects the filtered results in a new TreeSet
	public Set<E> mapFilter(Function<E, E> fn, Predicate<E> pr) {
		synchronized(this){
			return data.parallelStream().map(fn).filter(pr).collect(Collectors.toCollection(TreeSet::new));
		}
	}
	
	//Print result
	public ArrayList<E> printSet() {
		ArrayList<E> result = new ArrayList<E>();
		Iterator<E> iterator = data.iterator();
		while (iterator.hasNext()) {
            result.add(iterator.next());
		}
		return result;
	}
}