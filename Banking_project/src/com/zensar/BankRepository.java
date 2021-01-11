package com.zensar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BankRepository {

	public boolean loginCheck(String username, String password) {
		boolean result = false;
		Connection con = DBUtil.getMysqlDBConnection();
		String checkSql = "SELECT * FROM bank WHERE username=?";
		System.out.println(username+password);
		try {
			PreparedStatement pst = con.prepareStatement(checkSql);
			pst.setString(1, username); 
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String passwordDB = rs.getString("password");
				System.out.println(passwordDB);
				if(password.equals(passwordDB)) {
					result = true;
				}
			}

		} catch (Exception e) {
			System.out.println("LoginCheckRepo catch" + e);
		}
		return result;
	}// loginCheck
	public boolean addAccount(String username,String password,int amount,String address,String phone)
	{
		boolean returnresult = false;
		Connection con = DBUtil.getMysqlDBConnection();
		String sql = "insert into bank(username,password,amount,address,phone)  values(?,?,?,?,?)";

		try {
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, username);
			pst.setString(2, password);
			pst.setInt(3, amount);
			pst.setString(4, address);
			pst.setString(5, phone);
			int result = pst.executeUpdate();
			if(result == 0)
			{
				System.out.println("failed");
				returnresult = false;
			}else {
				System.out.println("data inserted");
				returnresult = true;
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return returnresult;
	}//addAccount Method
	public BankBean checkBalance(int accountNumber, String username, String password)
	{
		Connection con = DBUtil.getMysqlDBConnection();				
		String sql = "select * from bank where account_no= ? and username = ? and password =?";
		BankBean bb = null;
		
		try {
			PreparedStatement pst =  con.prepareStatement(sql);
			pst.setInt(1, accountNumber);
			pst.setString(2, username);
			pst.setString(3, password);
			System.out.println(accountNumber+""+username+""+password);
			
			
			ResultSet rs =  pst.executeQuery();
			
			while(rs.next())
			{
				bb= new BankBean(rs.getInt("account_no"),rs.getString("username"),rs.getString("password"),rs.getInt("amount"),rs.getString("address"),rs.getInt("phone"));
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return bb;

	}
	public boolean credit(int accNo , String username ,String password ,int amount) {
		boolean result = false;   
		Connection con = DBUtil.getMysqlDBConnection();
		String sql1 = "SELECT * from bank where account_no=? AND username=? AND password=?";
		String sql2 = "UPDATE bank set amount=? where account_no=?";
		try {

			PreparedStatement pst1 = con.prepareStatement(sql1);
			pst1.setInt(1, accNo);
			pst1.setString(2, username);
			pst1.setString(3,password);
			ResultSet rs = pst1.executeQuery();
			while(rs.next()) {
				int amountfromDb = rs.getInt("amount");

				int creditAmount = amount + amountfromDb; 
				PreparedStatement pst2 = con.prepareStatement(sql2);
				pst2.setInt(1, creditAmount);
				pst2.setInt(2, accNo);
				pst2.executeUpdate();
				result=true;
			}
		} catch (Exception e) {
			System.out.println("credit catch"+e);
		}
		return result;
	}//credit
	public boolean withdraw(int accNo , String username ,String password ,int amount) {
		boolean result = false;
		Connection con = DBUtil.getMysqlDBConnection();
		String sql1 = "select * from bank where account_no=? AND username=? AND password=?";
		String sql2 = "update bank set amount=? where account_no=?";
		int debit ;
		try {
			PreparedStatement pst = con.prepareStatement(sql1);
			pst.setInt(1, accNo);
			pst.setString(2, username);
			pst.setString(3,password);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int amountFromDb = rs.getInt("amount");
				if (amountFromDb >= 0) {
					debit = amountFromDb - amount;
					System.out.println(debit);
					PreparedStatement pst2 = con.prepareStatement(sql2);
					pst2.setInt(1, debit);
					pst2.setInt(2, accNo);
					pst2.executeUpdate();
					result = true;
				}
			}

		} catch (Exception e) {
			System.out.println("withdraw catch " + e);
		}
		return result;
	}//withdraw

	public boolean transfer(int accNo, String username, String password, int bAccNo, int amount) {
		Connection con =DBUtil.getMysqlDBConnection();

		boolean result = false;

		String fetchSql = "SELECT * FROM bank WHERE account_no=? AND username =? AND password=?";
		String fetchSql2 = "SELECT * FROM bank WHERE account_no=?";
		String fetchSql3 = "UPDATE bank SET amount=? WHERE account_no=?";
		String fetchSql4 = "UPDATE bank SET amount=? WHERE account_no=?";

		//int senderAmount ;
		try {
			//pst1 for fetching details from sender account		
			PreparedStatement pst1 = con.prepareStatement(fetchSql);
			pst1.setInt(1, accNo);
			pst1.setString(2, username);
			pst1.setString(3,password );
			ResultSet rs1 = pst1.executeQuery();
			System.out.println("Sender details fetched Successfully.....");
			//pst2 for fetching details from beneficiary account

			PreparedStatement pst2 = con.prepareStatement(fetchSql2);
			pst2.setInt(1, bAccNo);
			ResultSet rs2 = pst2.executeQuery();
			System.out.println("Beneficiary details fetched Successfully.....");


			while(rs1.next()) {
				int dbAmount = rs1.getInt("amount");
				if(dbAmount >= amount) {
					int senderAmount = dbAmount - amount;

					//pst2 for updating sender balance(withdraw)			 
					PreparedStatement pst3 = con.prepareStatement(fetchSql3);
					pst3.setInt(1, senderAmount);
					pst3.setInt(2, accNo);
					pst3.executeUpdate();
					System.out.println("Sender details Updated Successfully.....");
					if(rs2.next()) {
						int bAmount = rs2.getInt("amount");
						bAmount = bAmount + amount;

						//pst3 for updating beneficiary(receiver) balance(add)
						PreparedStatement pst4 = con.prepareStatement(fetchSql4);
						pst4.setInt(1, bAmount);
						pst4.setInt(2, bAccNo);
						pst4.executeUpdate();
						System.out.println("Beneficiary details Updated Successfully.....");
						result = true;
					}
					else {
						result = false;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Transfer Catch"+e);
		}
		return result;

	}// Transfer Method
	public boolean closeAccount(int accountNumber, String username, String password)
	{
		boolean result = false;
		Connection con = DBUtil.getMysqlDBConnection();

		String sql = "delete from bank where account_no= ? and username = ? and password =?";		
		try {
			System.out.println("CloseAccount called\n Deleting Account....");
			PreparedStatement pst =  con.prepareStatement(sql);
			pst.setInt(1, accountNumber);
			pst.setString(2, username);
			pst.setString(3, password);
			System.out.println(accountNumber+""+username+""+password);

			int rs= pst.executeUpdate();
			if(rs ==0)
			{
				System.out.println("Delete Failed!!");
				result = false;
			}
			else
			{
				System.out.println("Delete Successsfull");
				result = true;
			}
		} catch (Exception e) {
			System.out.println("CloseException!!"+e);
		}
		return result;
	}
}
