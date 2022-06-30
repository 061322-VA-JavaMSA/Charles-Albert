package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.Util.ConnectionUtil;
import com.revature.models.Inventory;

public class InventoryDaoImpl implements InventoryDAO {

	Connection connection;

	
	public Inventory create( Inventory itemname) {
		System.out.println("this method was called");
		String sql = "insert into inventory (item_name, item_model,item_price) values (?,?,?);";
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, itemname.getItemName());
			ps.setString(2, itemname.getItemModel());
			ps.setFloat(3, itemname.getItemPrice());
			
			ResultSet rs = ps.executeQuery();
			
				if (rs.next()) {
				
					itemname.setItemId(rs.getInt("item_id"));
				}
			}catch (SQLException | IOException e) {
			
					e.printStackTrace();
					System.out.println("this method was call in impl");
				}
		return itemname;
	
	} 
	
	public Inventory retrieveInventoryByItemname(String itemname) {
		String sql = "select * inventory from  where item_name  = ?;";
		Inventory i = null;
		
		try (Connection c = ConnectionUtil.getConnectionFromFile();){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, itemname); 

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				i = new Inventory();
				i.setItemId(rs.getInt("item_id"));
				i.setItemName(rs.getString("item_name"));
				i.setItemPrice(rs.getFloat("item_price"));
				i.setStatus(rs.getString("status"));
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
	
	@Override
	public Inventory retrieveById(int id) {
		Inventory i = new Inventory();
		String sql = "select * from inventory where item_id = ?;";
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			
		
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				i.setItemId(rs.getInt("item_id"));
				i.setItemName(rs.getString("item_name"));
				i.setItemModel(rs.getString("item_model"));
				i.setItemPrice(rs.getFloat("item_price"));
				if(rs.getInt("owners_id")!=0) {
					i.setOwned(true);
					i.setBuyersId(rs.getInt("buyers_id"));;
				}
			}
		} catch (SQLException | IOException e) {
			//log.error("Connection error. Exception thrown: " + 
			e.fillInStackTrace();
		}
		  //log.info("Item Retrieved: " + i);
		return i;
	}
	

	
	public ArrayList<Inventory> retrieveInventory() {
		
		Inventory  i = null;
		
		ArrayList<Inventory> itemname = new ArrayList<Inventory>();
		String sql = "select *from inventory;";
	    
	    
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				i = new Inventory( );
				i.setItemId(rs.getInt("item_id"));
				i.setItemName(rs.getString("item_name"));
				i.setItemModel(rs.getString("item_model"));
				i.setItemPrice(rs.getFloat("item_price"));
				itemname.add(i);
			 }
		}
			 catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		return itemname;
	}
	
	
		
	



	@Override
	public boolean deleteByID(int id) {
		String sql = "delete from inventory where id = ?;";
		int rowsChanged = -1;
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			rowsChanged = ps.executeUpdate();
		}catch (SQLException |IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rowsChanged > 0) {
			
			return true;
		}
		return false;
		}
	

	
	@Override
	public boolean updateItem(int id, Scanner sc) {
		String sql = "";
		boolean isQuit = false;
		while(isQuit == false) {
		System.out.println("What would you like to update?\n1: Name\n2: Cost"
				+ "\n3: Description\n4: Quit");
		switch(sc.nextLine()) {
		case "1":
			sql = "update inventory set item_name = ? where item_id = ?;";
			System.out.println("Enter new name.");
			int rowsChanged = -1;
			try(Connection c = ConnectionUtil.getConnectionFromFile()){
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setString(1, sc.nextLine());
				ps.setInt(2, id);
				rowsChanged = ps.executeUpdate();
			} catch (SQLException | IOException e) {
				//log.error("Connection error. Exception thrown: " +
						e.fillInStackTrace();
			}
		
		if(rowsChanged > 0) {
			System.out.println("Name changed successfully.");
		}
			break;
		case "2":
			System.out.println("Enter new cost.");
			sql = "update inventory set item_price = ? where item_price = ?;";
			
			rowsChanged = -1;
			try(Connection c = ConnectionUtil.getConnectionFromFile()){
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setFloat(1, sc.nextFloat());
				ps.setInt(2, id);
				rowsChanged = ps.executeUpdate();
			} catch (SQLException | IOException e) {
				//log.error("Connection error. Exception thrown: " + 
				e.fillInStackTrace();
			}
		if(rowsChanged > 0) {
			System.out.println("Cost changed successfully.");
		}
			sc.nextLine();
			break;
		case "3":
			System.out.println("Enter new description");
			sql = "update inventory set item_ model= ? where item_model = ?;";
			
			rowsChanged = -1;
			try(Connection c = ConnectionUtil.getConnectionFromFile()){
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setString(1, sc.nextLine());
				ps.setInt(2, id);
				rowsChanged = ps.executeUpdate();
			} catch (SQLException | IOException e) {
				//log.error("Connection error. Exception thrown: " +
						e.fillInStackTrace();
			}
		
		if(rowsChanged > 0) {
			System.out.println("Description changed successfully.");
		}
			break;
		case "4":
			isQuit = true;
			break;
		default:
			System.out.println("Input not found. Try again");
			break;
			}
		}
		return true;
		}
	
	@Override
	public boolean deleteAll() {
		deleteOffersAll();
		String sql = "delete from inventory;";
		int rowsChanged = -1;
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			rowsChanged = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			//log.error("Connection error. Exception thrown: " +
				e.fillInStackTrace();
		}
	
	if(rowsChanged > 0) {
		System.out.println("Deletion Successful");
		return true;
	}
		return false;
	}
	
	public boolean deleteOffersAll() {
		String sql = "delete from bids;";
		int rowsChanged = -1;
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			rowsChanged = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			//log.error("Connection error. Exception thrown: " + 
					e.fillInStackTrace();
		}
	
	if(rowsChanged > 0) {
		//log.info("Deletion successful ");
		return true;
	}
		return false;
	}

	


	@Override
	public boolean itemOffer(int itemID, Scanner sc) {
		String sql = "select * from offers join inventory on offfer_cus_id = buyers_id;";
		boolean isAccepted = false;
		
		int cusId = 0;
		float offered = 0;
		float payments = 0;
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(isAccepted == false) {
					System.out.println("Item Name: " + rs.getString("item_name"));
					System.out.println("Item Offer: " + rs.getFloat("offer"));
					System.out.println("Do you accept this bid? [Y] or [N]");
					if(sc.nextLine().equals("Y")) {
						cusId = rs.getInt("offer_cus_id");
						offered = rs.getFloat("offered");
						payments = offered;
						isAccepted = true;
						deleteByID(itemID);
						insertBid(cusId,itemID, offered, payments);
						updateOwner(cusId,itemID);
					}else {
						System.out.println("Offer Rejected");
						}
					}
			}
			
			return true;
			
		} catch (SQLException | IOException e) {
			//log.error("Connection error. Exception thrown: " + 
			e.fillInStackTrace();
		}
		return false;
	}

		static void updateOwner(int customer, int item_name) {
			String sql = "update inventory set buyers_id = ? where item_id = ?;";
			
			int rowsChanged = -1;
			try(Connection c = ConnectionUtil.getConnectionFromFile()){
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setInt(1, customer);
				ps.setInt(2, item_name);
				rowsChanged = ps.executeUpdate();
			} catch (SQLException | IOException e) {
				//log.error("Connection error. Exception thrown: " + 
				e.fillInStackTrace();
			}
		
		if(rowsChanged > 0) {
			
		}
		}

	
		static void insertBid(int cusId, int offer_item_id, float offered, float payments) {
			String sql = "insert into offers (offer_cus_id, offer_item_id, offer, payments) values ('?','?','?','?');";
			int rowsChanged = -1;
			try(Connection c = ConnectionUtil.getConnectionFromFile()){
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setInt(1,cusId);
				ps.setInt(2, offer_item_id);
				ps.setFloat(3, offered);
				ps.setFloat(4, payments);
				rowsChanged = ps.executeUpdate();
				
			}catch(SQLException | IOException e) {
				//log.error("Connection error. Exception thrown: " + 
						e.fillInStackTrace();
			}
			
			if(rowsChanged > 0) {
				//log.info("Insert successful");
			}

		}

		@Override
		public Inventory createItem(Inventory i) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Inventory retrieveByName(String name) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void viewPayments() {
			// TODO Auto-generated method stub
			
		}

	

	
	

	
}



