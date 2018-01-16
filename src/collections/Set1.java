package collections;

import java.util.HashSet;

import benchmark.internal.Benchmark;
import benchmark.objects.A;
import pointerbench.markers.Alloc;

/*
 * @testcase Set1
 * 
 * @version 1.0
 * 
 * @author Johannes Späth, Nguyen Quang Do Lisa (Secure Software Engineering Group, Fraunhofer
 * Institute SIT)
 * 
 * @description HashSet
 */
public class Set1 {

  public static void main(String[] args) {

    HashSet<Object> set = new HashSet<Object>();
    Object a = new Object();
    Object c = null;
    Object b = new Alloc();
    set.add(a);
    set.add(b);
    for (Object i : set) {
      c = i;
      break;
    }
    a = null;

    Benchmark.pointsToQuery(c);
    Benchmark.mayAliasQuery(c, a, false);
    Benchmark.mayAliasQuery(c, b, false);
    Benchmark.mayAliasQuery(c, set, false);
  }
}