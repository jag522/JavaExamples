package com.jag.util.collection;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<ListVO> list = new ArrayList<ListVO>();
		
		ListVO listVO1 = new ListVO();
		listVO1.setId("1");
		
		ListVO listVO2 = new ListVO();
		listVO1.setId("2");
		
		list.add(listVO1);
		list.add(listVO2);
		System.out.println(list);
		list.remove(0);
		
		System.out.println(list);
	}

}

class ListVO {
	private String id = "";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}