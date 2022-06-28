package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.Util.ConnectionUtil;
import com.revature.models.Account;
import com.revature.models.User;

public class AccountDaoImpl implements AccountDAO {
	
	Connection conection;
	
	@Override
	public Account createAccount(Account a) {
		System.out.println("this method was called");
		String sql = "insert into accounts (id, accountbal) values (?,?);";
		try(Connection c = ConnectionUtil.getHardcodedConnection()){
			PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, a.getId());
			ps.setFloat(2, a.getAccountBal());
			
			int count = ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			
				if (count == 1) {
				
					System.out.println("User added successfully");
					rs.next();
					int generatedId = rs.getInt(1);
				
					a.setId(generatedId);
					return a;
				}
			}
			
				catch (SQLException e) {
			
					e.printStackTrace();
					System.out.println("Something went wrong with the insertion");
				}
		return null;
	}

	@Override
	public Account retrieveAccountById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> retrieveAccounts() {
		String sql = "select * from account;";
		List<Account> a = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getHardcodedConnection()){
			
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				
				Account a1 = new Account();
				a1.setId(rs.getInt("id"));
				a1.setAccountBal(rs.getFloat("account"));
				a1.setUserAssigned((User) rs.getArray(sql));
				
				//users.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}

	@Override
	public boolean updateAccount(Account a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletAccountbyId(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
