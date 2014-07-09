package com.jag.util.compare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * �������ɱȽϣ����ǿ��Դ��ⲿ��һ��Comparator�Ƚ���
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
