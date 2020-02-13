package com.ibm.wallet.ui;

import java.sql.SQLException;

import com.ibm.wallet.dao.LowBalanceException;
import com.ibm.wallet.service.ServiceClass;

import java.util.Scanner;

public class UI {
	
	

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);


		try {
			ServiceClass serviceLayer = new ServiceClass() ;
		
		
		
		
		int id , id2;
		String name;
		int amount;
		String accountType;
		
		int choice = 0 ;

		final int CHOICE_ZERO = 0 , CHOICE_ONE = 1, CHOICE_TWO = 2, CHOICE_THREE = 3, CHOICE_FOUR = 4, CHOICE_FIVE = 5 , CHOICE_SIX = 6;
		
		
		while(true) {
			System.out.println("Welcome to our Banking Wallet\n\n"
					+ "Press : \n\n"
					+ " 0 for veiwing your BALANCE\n"
					+ " 1 for Account Creation\n"
					+ " 2 for making a DEPOSIT\n"
					+ " 3 for making a WITHDRAWAL\n"
					+ " 4 for transferring FUNDS\n"
					+ " 5 for viewing your all transaction DETAILS\n"
					+ " 6 for viewing account details\n"
					+ "   Any other number TO EXIT ");
			
			choice = scan.nextInt();
			
			if( choice == CHOICE_ONE ) {
				
				System.out.println("Enter the new account holder name");
				
				name = scan.next();
				
				System.out.println("Enter the account Type");
				
				accountType = scan.next() ;
				
				serviceLayer.addNewAccount(name, accountType);
			}
			
			else if ( choice == CHOICE_TWO ) {
				
				System.out.println("Enter your Account Number");
				
				id = scan.nextInt() ;
				
				System.out.println("Enter the amount to be deposited");
				
				amount = scan.nextInt();
				
				serviceLayer.storeDeposit(amount, id);
			}
			
				else if (choice == CHOICE_THREE) {

					System.out.println("Enter your Account Number");

					id = scan.nextInt();

					System.out.println("Enter the amount to be withdrawn");

					amount = scan.nextInt();

					serviceLayer.storeWithdraw(amount, id);
				}
			
				else if (choice == CHOICE_FOUR) {
					
					System.out.println("Enter your account Number");
					
					id = scan.nextInt();

					System.out.println("Enter your account Number to transfer to");
					
					id2 = scan.nextInt();
					
					System.out.println("Enter the amount you want to transfer");
					
					amount = scan.nextInt() ;		
					
					
					
					
					
				}
			
				else if( choice == CHOICE_FIVE ) {
					System.out.println("Enter the name of the account holder");
					
					name = scan.next();
					
					System.out.println(serviceLayer.fetchTransactionDetails(name.toString()));
				}
			
				else if(choice == CHOICE_ZERO) {
					
					System.out.println("Enter your account number");
					
					id = scan.nextInt();
					
					System.out.println("Your Balance is  : " +serviceLayer.getBalance(id)) ;
				}
			
				else if (choice == CHOICE_SIX) {

					System.out.println("Enter the name of the account holder");

					name = scan.next();

					System.out.println(serviceLayer.fetchAccDetails(name));

				}

				else {
					break;
				}
			
			
			
			
			
		}
		
		} catch (SQLException e) {
			
			System.out.println("Some issues with data..." + e.getMessage());
			
		} catch ( LowBalanceException lbe) {
			
			System.out.println("Insufficient Funds");			
		}
		
		
		

	}

}
