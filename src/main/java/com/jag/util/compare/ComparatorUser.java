package com.jag.util.compare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 对象本身不可比较，但是可以从外部传一个Comparator比较器
 * 
 * @author edwin
 *
 */
public class ComparatorUser implements Comparator<User> {

	public int compare(User o1, User o2) {
		return o1.getAge() - o2.getAge();
	}

	public static void main(String[] args) {
		User[] users = new User[] { new User("id_1", 38), new User("id_2", 29),
				new User("id_3", 39), new User("id_4", 20) };
		Arrays.sort(users, new ComparatorUser());
		for (User user : users) {
			System.out.println("id=" + user.getId() + " age=" + user.getAge());
		}
	}
}
