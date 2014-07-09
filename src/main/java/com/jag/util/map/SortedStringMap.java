package com.jag.util.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortedStringMap {

	private HashMap map = new HashMap();
	private Set keySet = map.keySet();

	public Object get(String key) {
		return map.get(key);
	}

	public void put(String key, Object value) {
		map.put(key, value);
	}

	public void sort() {
		List list = new ArrayList(map.keySet());

		Collections.sort(list, new Comparator() {
			public int compare(Object a, Object b) {
				return a.toString().toLowerCase().compareTo(
						b.toString().toLowerCase());
			}
		});

		this.keySet = new TreeSet(list);
	}

	public Set keySet() {
		return this.keySet;
	}

	public static void main(String[] args) {
		SortedStringMap map = new SortedStringMap();
		map.put("123", "123");
		map.put("234", "234");
		map.put("345", "345");
		map.put("456", "456");
		map.put("567", "567");

		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String) it.next();
			System.out.println("key[" + key + "],   value[" + map.get(key)
					+ "]");
		}

		System.out.println("\n");
		map.sort();
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			String key = (String) it.next();
			System.out.println("key[" + key + "],   value[" + map.get(key)
					+ "]");
		}
	}
}
