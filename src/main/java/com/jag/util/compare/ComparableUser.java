package com.jag.util.compare;

import java.util.Arrays;

/**
 * 对象本身是可比较的
 * 
 * @author edwin
 *
 */
public class ComparableUser implements Comparable {
	private String id;
	private int age;

	public ComparableUser(String id, int age) {
		this.id = id;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int compareTo(Object o) {
		return this.age - ((ComparableUser) o).getAge();
	}

	public static void main(String[] args) {
		ComparableUser[] users = new ComparableUser[] {
				new ComparableUser("id_1", 23), new ComparableUser("id_2", 20),
				new ComparableUser("id_3", 25), new ComparableUser("id_4", 19) };
		Arrays.sort(users);
		for (ComparableUser user : users) {
			System.out.println("id=" + user.getId() + " age=" + user.getAge());
		}
	}
}
