package com.cts.jd.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.jd.exception.DatabaseException;
import com.cts.jd.model.Item;

public class ItemRepoImpl implements ItemRepo {
	

	private Item mapRecord(ResultSet rs) throws SQLException {
		return new Item(rs.getInt(1), rs.getString(2), rs.getDouble(3));
	}

	@Override
	public Item add(Item item) throws DatabaseException {
		if (item != null) {
			try (PreparedStatement pst = ConnectionFactory.getInstance().getConnection()
					.prepareStatement(QueryMapper.ADD_ITEM)) {

				pst.setInt(1, item.getItemId());
				pst.setString(2, item.getName());
				pst.setDouble(3, item.getPrice());

				pst.executeUpdate();

			} catch (SQLException | IOException e) {
				throw new DatabaseException("Sorry! and ExcepitonOccured! " + e.getMessage());
			}
		}
		return item;
	}

	@Override
	public Item update(Item item) throws DatabaseException {
		if (item != null) {
			try (PreparedStatement pst = ConnectionFactory.getInstance().getConnection()
					.prepareStatement(QueryMapper.UPD_ITEM)) {

				pst.setString(1, item.getName());
				pst.setDouble(2, item.getPrice());
				pst.setInt(3, item.getItemId());

				pst.executeUpdate();

			} catch (SQLException | IOException e) {
				throw new DatabaseException("Sorry! and ExcepitonOccured! " + e.getMessage());
			}
		}
		return item;
	}

	@Override
	public void delete(int itemId) throws DatabaseException {
		try (PreparedStatement pst = ConnectionFactory.getInstance().getConnection()
				.prepareStatement(QueryMapper.DEL_ITEM)) {

			pst.setInt(1, itemId);

			pst.executeUpdate();

		} catch (SQLException | IOException e) {
			throw new DatabaseException("Sorry! and ExcepitonOccured! " + e.getMessage());
		}
	}

	@Override
	public List<Item> getAll() throws DatabaseException {
		List<Item> items = new ArrayList<Item>();

		try (PreparedStatement pst = ConnectionFactory.getInstance().getConnection()
				.prepareStatement(QueryMapper.GET_ALL_ITEMS)) {

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				items.add(mapRecord(rs));
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
			throw new DatabaseException("Sorry! and ExcepitonOccured! " + e.getMessage());
		}

		return items;
	}

	@Override
	public Item getById(int itemId) throws DatabaseException {
		Item item = null;

		try (PreparedStatement pst = ConnectionFactory.getInstance().getConnection()
				.prepareStatement(QueryMapper.GET_ITEM)) {
			
			pst.setInt(1, itemId);
			
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				item =mapRecord(rs);
			}

		} catch (SQLException | IOException e) {
			throw new DatabaseException("Sorry! and ExcepitonOccured! " + e.getMessage());
		}

		return item;
	}

}
