package com.jag.util.collection.set;

import java.util.HashSet;
import java.util.Set;

class PrivilegeDTO {
	private Long id;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return this.name;
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean b1 = obj instanceof PrivilegeDTO;
		PrivilegeDTO dd = (PrivilegeDTO)obj;
		boolean b2 = (this.id.hashCode() == dd.getId().hashCode());
		return b1 && b2;
	}
}

public class SetTest {
	public static void main(String[] args) {
		PrivilegeDTO dto1 = new PrivilegeDTO();
		dto1.setId(new Long(1));
		dto1.setName("删除权限");
		
		PrivilegeDTO dto2 = new PrivilegeDTO();
		dto2.setId(new Long(1));
		dto2.setName("增加权限");
		
		Set<PrivilegeDTO> privilegeSet = new HashSet<PrivilegeDTO>();
		System.out.println(dto1.equals(dto2));
		privilegeSet.add(dto1);
		privilegeSet.add(dto2);
		System.out.println(privilegeSet);
	}
}
