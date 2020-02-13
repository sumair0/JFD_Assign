package com.ibm.wallet.dao;

import java.sql.SQLException;

public interface DAOInterface {

	void storeDeposit(int amount, int accNo) throws SQLException;

	void storeWithdraw(int amount, int accNo) throws LowBalanceException, SQLException;

	String fetchAccDetails(String name) throws SQLException;
	
	int getBalance(int accNo) throws SQLException ;
	
	void fundTransfer(int accNo1, int accNo2 , int amount ) throws SQLException, LowBalanceException;
	
	void addNewAccount(String name, String accountType) throws SQLException ;

	String fetchTransactionDetails(String accNo) throws SQLException ;

}
