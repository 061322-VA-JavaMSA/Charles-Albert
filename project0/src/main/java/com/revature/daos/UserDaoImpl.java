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
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Inventory;

public class UserDaoImpl implements UserDAO{

	@Override
	public void createCustomer(Customer cc) {
		
		String sql = "insert into customer_info (username, password, customer_name, account_number) values (?,?,?,?) returning id;";

		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1,cc.getUserName());
			ps.setString(2, cc.getUserPassword());
			ps.setString(3, cc.getName());
			ps.setString(4, cc.getCustomeAccountNumber());
			
			
			ResultSet rs = ps.executeQuery();
			
				if (rs.next()) {
				
						cc.setUserId(rs.getInt("id"));
					}
			
			
			}catch (SQLException  | IOException e) {
			
				 e.fillInStackTrace();
			}
	
				
	}
	
	@Override
	public void createEmployee(Employee e) {
		String sql = "insert into customer_info (username, password, customer_name, account_number) values ('?', '?', '?', '?');";
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, e.getUserName());
			ps.setString(2, e.getUserPassword());
			ps.setString(3, e.getName());
			ps.setString(5, e.getemployeeAccess());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				e.setUserId(rs.getInt("id"));
			}
		} catch (SQLException | IOException except) {
			//e.printStackTrace();
		}
		
	}
		
	
		
	


	public boolean deleteAll(int id, boolean isCustomer) {
		deleteOfferById(id);
		if(isCustomer) {
		String sql = "delete from customer_info where id = ?;";
		
		int rowsChanged = -1;
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			rowsChanged = ps.executeUpdate();
		}catch (SQLException  | IOException e) {
			
			e.printStackTrace();
		}
		
		if(rowsChanged > 0) {
			System.out.println("Customer succesfully deleted ");
		}
		return true;
		}else if (isCustomer == false) {
			
			String sql = "delete from employee_info where id = ?;";
			int rowsChanged = -1;
			try(Connection c = ConnectionUtil.getConnectionFromFile()){
				PreparedStatement ps = c.prepareStatement(sql);
				rowsChanged = ps.executeUpdate();
			} catch (SQLException | IOException e) {
				//log.error("Connection error. Exception thrown: " + 
						e.fillInStackTrace();
			}
		
		if(rowsChanged > 0) {
			System.out.println("Employee succesfully deleted");
		}
			return true;
		}
		return false;
	}
			
	


	
	private boolean deleteOfferById(int id) {
		String sql = "delete from offers where bcus_id = ?;";
		int rowsChanged = -1;
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1,id);
			rowsChanged = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			//log.error("Connection error. Exception thrown: " +
			e.fillInStackTrace();
		}
	
	if(rowsChanged > 0) {
		//System.out.println("Deletion Successful");
		return true;
	}
		return false;
	}

		


	@Override
	public Customer retrieveCustomerByID(int id) {
		String sql = "select * from customer_info where customer_name = ?;";
		Customer user = null;
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, sql);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new Customer();
				user.setUserId(rs.getInt("id"));
				user.setUserName(rs.getString("customer_name"));
				user.setUserPassword(rs.getString("password"));
				user.setCustomeAccountNumber(rs.getString("acccount_number"));
				user.setName(rs.getString("customer_name"));
				
			}
		} catch (SQLException | IOException e) {
			//log.error("Connection error. Exception thrown: " + 
			e.fillInStackTrace();
		}
		return user;
	
	}


	@Override
	public Employee retrieveEmployeeByID(int id) {
		String sql = "select * from employee_info where id = ?;";
		Employee user = null;
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new Employee();
				user.setUserId(rs.getInt("id"));
				user.setUserName(rs.getString("employee_name"));
				user.setUserPassword(rs.getString("password"));
				user.setName(rs.getString("employee_name"));
			}
		} catch (SQLException | IOException e) {
			//log.error("Connection error. Exception thrown: " +
			e.fillInStackTrace();
		}
		return user;
	}

	@Override
	public Customer retrieveCustomerByUsername(String username) {
		String sql = "select * from customer_info where username = ?;";
		Customer user = null;
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new Customer();
				user.setUserId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setUserPassword(rs.getString("password"));
				user.setCustomeAccountNumber(rs.getString("acccount_number"));
				user.setName(rs.getString("customer_name"));
			}
		} catch (SQLException | IOException e) {
			//log.error("Connection error. Exception thrown: " + 
			e.fillInStackTrace();
		}
		return user;
	}
	

	@Override
	public Employee retrieveEmployeeByUsername(String username) {
		String sql = "select * from employee_info where username = ?;";
		Employee user = null;
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new Employee();
				user.setUserId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setUserPassword(rs.getString("password"));
				user.setName(rs.getString("employee_name"));
				
			}
		} catch (SQLException | IOException e) {
			//log.error("Connection error. Exception thrown: " + 
			e.fillInStackTrace();
			System.out.println("method in userdao impl");
		}
		return user;
	}


	@Override
	public List<Customer> retrieveCustomers() {
		String sql = "select * from customers;";
		Customer user = null;
		List<Customer> cusList = new ArrayList<Customer>();
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new Customer();
				user.setUserID(rs.getInt("id"));
				user.setUserName(rs.getString("customer_name"));
				user.setUserPassword(rs.getString("password"));
				user.setCustomeAccountNumber(rs.getNString("account_number"));;
				user.setName(rs.getString("customer_name"));
				
				cusList.add(user);
			}
		} catch (SQLException | IOException e) {
			//log.error("Connection error. Exception thrown: " +
			e.fillInStackTrace();
		}
		return cusList;
	}


	@Override
	public List<Employee> retrieveEmployees() {
		String sql = "select * from employee_info;";
		Employee user = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new Employee();
				user.setUserId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setUserPassword(rs.getString("password"));
				user.setName(rs.getString("employee_name"));
				employeeList.add(user);
			}
		} catch (SQLException | IOException e) {
			//log.error("Connection error. Exception thrown: " + 
			e.fillInStackTrace();
		}
		return employeeList;
	}


	@Override
	public boolean updateUser(int id, boolean isCustomer, Scanner sc) {
		if(isCustomer) {
			String sql = "";
			boolean isQuit = false;
			while(isQuit == false) {
			System.out.println("What would you like to update?\n1: Name\n2: Username"
					+ "\n3: Password\n4: Quit");
			switch(sc.nextLine()) {
			case "1":
				sql = "update customer_info set customer_name = ? where id = ?;";
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
				System.out.println("Enter new username.");
				sql = "update customer_info set customer_name = ? where id = ?;";
				
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
				System.out.println("Customer name changed successfully.");
			}
				break;
			case "3":
				System.out.println("Enter new password.");
				sql = "customer_info set password = ? where id = ?;";
				
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
				System.out.println("Password changed successfully.");
			}
				break;
			
			
			case "4":
				isQuit = true;
				break;
			default:
				System.out.println("Input not found. Try again.");
				break;
				}
			}
			
			return true;
		}else if(isCustomer = false){
			String sql="";
			boolean isQuit = false;
			while(isQuit == false) {
			System.out.println("What would you like to update?\n1: Name\n2: Username"
					+ "\n3: Password\n4: Quit");
			switch(sc.nextLine()) {
			case "1":
				sql = "update employee_info set username = ? where id = ?;";
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
				System.out.println("Enter new username.");
				sql = "update employee_info set username = ? where id = ?;";
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
				System.out.println("Username changed successfully.");
			}
				break;
			case "3":
				System.out.println("Enter new password.");
				sql = "update employee_info set password = ? where id = ?;";
				
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
				System.out.println("Password changed successfully.");
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
		
		return false;
	}


	@Override
	public boolean deleteByID(int id, boolean isCustomer) {
		deleteOfferById(id);
		if(isCustomer) {
			String sql = "delete from customer_info where id = ?;";
			int rowsChanged = -1;
			try(Connection c = ConnectionUtil.getConnectionFromFile()){
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setInt(1, id);
				rowsChanged = ps.executeUpdate();
			} catch (SQLException | IOException e) {
				//log.error("Connection error. Exception thrown: " 
				e.fillInStackTrace();
			}
		
		if(rowsChanged > 0) {
			System.out.println("Deletion Successful");
		}
			return true;
		}else if(isCustomer == false) {
			String sql = "delete from employees where id = ?;";
			int rowsChanged = -1;
			try(Connection c = ConnectionUtil.getConnectionFromFile()){
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setInt(1, id);
				rowsChanged = ps.executeUpdate();
			} catch (SQLException | IOException e) {
				//log.error("Connection error. Exception thrown: " 
				 e.fillInStackTrace();
			}
		
		if(rowsChanged > 0) {
			System.out.println("Deletion Successful");
		}
			return true;
		}
		return false;
	}



	@Override
	public void makeOffer(float amount, int userID, int itemID) {
		String sql = "insert into offers (offer_cus_id, offer_item_id, offer, payments) values ('?','?','?','?');";
		int rowsChanged = -1;
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, userID);
			ps.setInt(2, itemID);
			ps.setFloat(3,amount);
			rowsChanged = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			//log.error("Connection error. Exception thrown: " + 
			e.fillInStackTrace();
		}
	
	if(rowsChanged > 0) {
		System.out.println("Offer has been placed.");
	}
		
	}

	@Override
	public ArrayList<Inventory> ownedItems(int userID) {
		Inventory item;
		ArrayList<Inventory> items = new ArrayList<Inventory>();
		String sql = "select * from inventory where buyers_id = ?;";
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);	
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				item = new Inventory();
				item.setItemId(rs.getInt("item_id"));;
				item.setItemName(rs.getString("item_name"));
			    item.setItemModel(rs.getString("item_model"));
			    item.setItemPrice(rs.getFloat("item_price"));
			    item.setBuyersId(rs.getInt("buyers_id"));
				
				items.add(item);
			}
		} catch (SQLException | IOException e) {
			//log.error("Connection error. Exception thrown: " + 
			e.fillInStackTrace();
		}
		return items;
	}


	

	@Override
	public void paymentsLeft(int usedId) {
		String sql = "select * from offers where offer_cus_id =?;";
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, usedId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getFloat("payments")!=0){
					System.out.println("Item ID: " + rs.getString("offer_item_id"));
					System.out.println("Amount owed: " + rs.getFloat("payments"));
				}
			}
		} catch (SQLException | IOException e) {
			//log.error("Connection error. Exception thrown: " + 
			e.fillInStackTrace();
		}
	}

	public boolean deleteBidsID(int id) {
		String sql = "delete from offers where offer_cus_id = ?;";
		int rowsChanged = -1;
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1,id);
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

	@Override
	public boolean deleteAll(boolean isCustomer) {
		// TODO Auto-generated method stub
		return false;
	}

	
	

}
