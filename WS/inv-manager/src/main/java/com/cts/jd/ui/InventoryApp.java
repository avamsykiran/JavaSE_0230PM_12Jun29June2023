package com.cts.jd.ui;

import java.util.List;

import com.cts.jd.dao.ItemRepo;
import com.cts.jd.dao.ItemRepoImpl;
import com.cts.jd.exception.DatabaseException;
import com.cts.jd.model.Item;

public class InventoryApp {

	public static void main(String[] args) {
		
		ItemRepo repo = new ItemRepoImpl();
		
		try {
			List<Item> items = repo.getAll();
			if(items.isEmpty()) {
				System.out.println("No records");
			}else {
				items.stream().forEach(System.out::println);
			}
			
			
		} catch (DatabaseException e) {
			System.out.println(e.getMessage());
		}

	}

}
