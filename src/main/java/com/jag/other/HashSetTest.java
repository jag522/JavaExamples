package com.jag.other;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
public static void main(String[] args) {
	String[] s1 = {"1", "2"};
	String[] s2 = {"2", "3"};
	HashSet h = new HashSet();
	for(int i=0; i<s1.length; i++) h.add(s1[i]);
	for(int i=0; i<s2.length; i++) h.add(s2[i]);
	h.remove("3");
	Iterator i = h.iterator();
	while(i.hasNext())
		System.out.println(i.next());
}
}
