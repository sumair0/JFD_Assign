package com.ibm.wallet.service;

import java.sql.SQLException;

import com.ibm.wallet.dao.LowBalanceException;

public interface ServiceInterface {
	public void storeDeposit(int amount, int accNo) throws SQLException;

	public void storeWithdraw(int amount, int accNo) throws LowBalanceException, SQLException;

	public String fetchAccDetails(String name) throws SQLException;
	
	public int getBalance(int accNo) throws SQLException ;
	
	public void fundTransfer(int accNo1, int accNo2 , int amount ) throws SQLException, LowBalanceException;
	
	public void addNewAccount(String name, String accountType) throws SQLException ;
	
	public String fetchTransactionDetails(String accNo) throws SQLException ;
}
