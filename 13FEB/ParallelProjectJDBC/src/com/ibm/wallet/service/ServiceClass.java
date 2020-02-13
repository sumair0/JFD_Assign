package com.ibm.wallet.service;

import java.sql.SQLException;

import com.ibm.wallet.dao.DAOClass;
import com.ibm.wallet.dao.LowBalanceException;

public class ServiceClass {
	
	DAOClass dao ;
	
	public ServiceClass() throws SQLException {
		dao = new DAOClass() ;
	}
	
		
	public void storeDeposit(int amount, int accNo) throws SQLException {
		dao.storeDeposit(amount, accNo);
	}

	public void storeWithdraw(int amount, int accNo) throws LowBalanceException, SQLException {
		dao.storeWithdraw(amount, accNo);
	}

	public String fetchAccDetails(String name) throws SQLException {
		return dao.fetchAccDetails(name);
	}
	
	public int getBalance(int accNo) throws SQLException {
		return dao.getBalance(accNo);
	}
	
	public void fundTransfer(int accNo1, int accNo2 , int amount ) throws SQLException, LowBalanceException {
		dao.fundTransfer(accNo1, accNo2, amount);
	}
	
	public void addNewAccount(String name, String accountType) throws SQLException {
		dao.addNewAccount(name, accountType);
	}
	
	public String fetchTransactionDetails(String accNo) throws SQLException{
		return dao.fetchTransactionDetails(accNo);
	}

}
