/**
 * MySet.java
 *
 *Student name: Sarah Narayamy Tavares Silva
 *Student number: 2960992
 *
 */

package Q01;

import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Function;
interface MySet<E>{
	public void add(E x);
	public void add(Set<E> s);
	public boolean forAll(Predicate<E> pr);
	public boolean exists(Predicate<E> pr);
	public long count(Predicate<E> pr);
	public Set<E> map(Function<E,E> fn);
	public Set<E> filter(Predicate<E> pr);
	public Set<E> mapFilter(Function<E,E> fn, Predicate<E> pr);
}