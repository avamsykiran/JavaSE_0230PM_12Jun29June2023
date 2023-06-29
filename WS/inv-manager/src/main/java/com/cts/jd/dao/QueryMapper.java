package com.cts.jd.dao;

public interface QueryMapper {
	
	public static final String ADD_ITEM = "insert into items values(?,?,?)";
	public static final String UPD_ITEM = "update items set iname=?,price=? where itemid=?";
	public static final String DEL_ITEM = "delete from items where itemid=?";
	public static final String GET_ALL_ITEMS = "select * from items";
	public static final String GET_ITEM = "select * from items where itemid=?";

}
