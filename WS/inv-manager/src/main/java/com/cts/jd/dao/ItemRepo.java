package com.cts.jd.dao;

import java.util.List;

import com.cts.jd.exception.DatabaseException;
import com.cts.jd.model.Item;

public interface ItemRepo {
	Item add(Item item) throws DatabaseException;
	Item update(Item item) throws DatabaseException;
	void delete(int itemId) throws DatabaseException;
	List<Item> getAll() throws DatabaseException;
	Item getById(int itemId) throws DatabaseException;
}
