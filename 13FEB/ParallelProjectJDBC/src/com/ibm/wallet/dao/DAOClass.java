package com.ibm.wallet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOClass implements DAOInterface {

	Connection bdCon;
	PreparedStatement prepStat;

	public DAOClass() throws SQLException {

		this.bdCon = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"root", "");

	}

	@Override
	public void storeDeposit(int amount, int accNo) throws SQLException {

		String query = "UPDATE account SET balance = ? WHERE accNumber = ?";

		int currBalance = this.getBalance(accNo);

		int newBalance = currBalance + amount;

		prepStat = this.bdCon.prepareStatement(query);

		prepStat.setInt(1, newBalance);

		prepStat.setInt(2, accNo);

		query = "INSERT INTO `transaction` (`transactionID`, `time`, `fromT`, `toT`) VALUES (NULL, current_timestamp(), ? , 'Bank');";

		prepStat = this.bdCon.prepareStatement(query);

		prepStat.setInt(1, accNo);
		
		prepStat.executeUpdate();

	}

	@Override
	public void storeWithdraw(int amount, int accNo) throws LowBalanceException, SQLException {

		if (this.getBalance(accNo) - amount < 0) {
			throw new LowBalanceException();
		}

		else {

			String query = "UPDATE account SET balance = ? WHERE accNumber = ?";

			int currBalance = this.getBalance(accNo);

			int newBalance = currBalance - amount;

			prepStat = this.bdCon.prepareStatement(query);

			prepStat.setInt(1, newBalance);

			prepStat.setInt(2, accNo);

			query = "INSERT INTO `transaction` (`transactionID`, `time`, `fromT`, `toT`) VALUES (NULL, current_timestamp(), 'Bank' , ?);";

			prepStat = this.bdCon.prepareStatement(query);

			prepStat.setInt(1, accNo);
			
			prepStat.executeUpdate();

		}

	}

	

	@Override
	public String fetchAccDetails(String name) throws SQLException {

		String query = "SELECT * FROM account WHERE name = ?";

		prepStat = this.bdCon.prepareStatement(query);
		
		prepStat.setString(1, name);
		
		ResultSet rs = prepStat.executeQuery();
		
		String result = "" ;
		
		while(rs.next()) {
			System.out.println("Entered loop");
			
			result += "|AccountNumber : " + rs.getInt("accNumber") + " Name : " + rs.getString("name") + " Balance : " + rs.getInt("balance") + " Accout Type : " + rs.getString("accountType") + "|"  ;                     
			
		}
		
		return result ;

	}

	@Override
	public int getBalance(int accNo) throws SQLException {
		
		String query = "SELECT balance FROM account WHERE accNumber = ?";
		
		prepStat = this.bdCon.prepareStatement(query);
		
		ResultSet rs = prepStat.executeQuery() ;
		
		
	    return rs.getInt("balance") ;
		
		
		
	}

	@Override
	public void fundTransfer(int accNo1, int accNo2, int amount) throws SQLException, LowBalanceException {
		
		if (this.getBalance(accNo1) - amount < 0) {
			throw new LowBalanceException();
		}

		else {

			String query1 = "UPDATE account SET balance = ? WHERE accNumber = ?";
			String query2 = "UPDATE account SET balance = ? WHERE accNumber = ?";

			int currBalance1 = this.getBalance(accNo1);
			int currBalance2 = this.getBalance(accNo2);

			int newBalance1 = currBalance1 - amount;
			int newBalance2 = currBalance2 + amount;

			prepStat = this.bdCon.prepareStatement(query1);
			
			prepStat.setInt(1, newBalance1);

			prepStat.setInt(2, accNo1);
			
			
			
			prepStat = this.bdCon.prepareStatement(query2);
			prepStat.setInt(1, newBalance2);

			prepStat.setInt(2, accNo2);
			
			
			String query = "INSERT INTO `transaction` (`transactionID`, `time`, `fromT`, `toT`) VALUES (NULL, current_timestamp(), ? , ?);";

			prepStat = this.bdCon.prepareStatement(query);

			prepStat.setInt(1, accNo1);
			prepStat.setInt(2, accNo2);
			
			prepStat.executeUpdate();

		}
	}

	@Override
	public void addNewAccount(String name, String accountType) throws SQLException {
		
		String query = "INSERT INTO account (accNumber, name, balance, accountType) VALUES (NULL, ?, 0 , ?)";
		
		prepStat = this.bdCon.prepareStatement(query);

		prepStat.setString(1, name);

		prepStat.setString(2, accountType);
		
		prepStat.executeUpdate();
		
		
	}

	@Override
	public String fetchTransactionDetails(String accNo) throws SQLException {
		
		String query = "SELECT * FROM transaction WHERE fromT = ? OR toT = ?";

		prepStat = this.bdCon.prepareStatement(query);
		
		prepStat.setString(1, accNo);
		prepStat.setString(2, accNo);
		
		ResultSet rs = prepStat.executeQuery();
		
		String result = "" ;
		
		while(rs.next()) {
			
			if((rs.getString("fromT").equals(accNo))||(rs.getString("toT").equals(accNo))) {
			
			result += "|TransactionID : " + rs.getInt("transactionID") + " Time : " + rs.getString("time") + " From : " + rs.getString("fromT") + " To : " + rs.getString("toT") + "|"  ;                     
			}	
		}
		
		return result ;

		
		
	}
	
	

}
