package com.jag.lang;

import java.io.Serializable;
import java.util.List;

class CloneTest implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	
	String tableName = null;

	String lutsFieldName = null;

	List<List<Object>> rowData = null;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getLutsFieldName() {
		return lutsFieldName;
	}

	public void setLutsFieldName(String lutsFieldName) {
		this.lutsFieldName = lutsFieldName;
	}

	public List<List<Object>> getRowData() {
		return rowData;
	}

	public void setRowData(List<List<Object>> rowData) {
		this.rowData = rowData;
	}
	
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
//			RepMsg msg = (RepMsg)o;
		} catch (CloneNotSupportedException e) {
			System.out.println("RepMsg can't be cloned!!!");
		}
		return o;
	}
	
	public static void main(String[] args) {
		
	}

}
