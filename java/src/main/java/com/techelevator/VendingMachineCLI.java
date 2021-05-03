package com.techelevator;

import com.techelevator.view.Menu;
import customexceptions.InvalidBillException;
import customexceptions.InvalidProductException;
import logging.Logger;
import logging.SalesReport;

import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_OPTION_HIDDEN= "";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_OPTION_HIDDEN};

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH };


	private Menu menu;
	private Menu purchaseMenu;

	public VendingMachineCLI(Menu menu, Menu purchaseMenu) {
		this.menu = menu;
		this.purchaseMenu = purchaseMenu;
	}

	public void run() { // think of this like the main
		Logger log = new Logger("C:\\Users\\Student\\workspace\\mod1-wk4-pairs-green-t4\\java\\src\\main\\resources\\Log.txt");
		VendingProductsMethods vendingProducts = new VendingProductsMethods();
		SalesReport salesReport = new SalesReport();

		salesReport.loadProductsSalesReport(vendingProducts.getVendingProducts());

		while (true) {
			String choice = ((String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS));

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				System.out.println(vendingProducts.print());
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				purchaseMenu(vendingProducts, log, salesReport);
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				// exit program
				System.exit(0);
			} else if (choice.equals(MAIN_MENU_OPTION_HIDDEN)){
				System.out.println(salesReport.printOut());
			}
		}
	}



	public void purchaseMenu(VendingProductsMethods vendingProducts, Logger log, SalesReport salesReport) {
		Balance balance = new Balance();

		while (true) {
			System.out.println("\nCurrent Balance: " + balance.print());
			String choice = (String) purchaseMenu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
			Scanner userInput = new Scanner(System.in);

			if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)){
				System.out.print("Enter 1, 2, 5, or 10 bill ");
				try {
					//assign userInput
						int moneyAdded = Integer.parseInt(userInput.nextLine());

					//create boolean isValidBill
					//pass in moneyAdded to isValidBill
					//if isValidBill false, then throw exception InvalidBillException();

					//create a startingBalance variable, assign to current balance
					double startingBalance = balance.getBalance();
					//create a endingBalance variable
					double endingBalance;

					boolean isValidBill = balance.isValidBill(moneyAdded);
					if (!isValidBill) {
						throw new InvalidBillException();
					}
					//update endingBalance variable to the new balance
					endingBalance = balance.getBalance();

					//Call log method for Feed money, startingBalance, endingBalance
					log.loggingAction(startingBalance, endingBalance);

				} catch (NumberFormatException e) {
					System.out.println("Invalid bill. Please insert either a 1, 2, 5, or 10 bill");
				} catch (InvalidBillException e){
					System.out.println(e.getMessage());
				}
			} else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
				// select product
				// display vending machine items
				System.out.println(vendingProducts.print());
				//Prompt userInput
				System.out.println("Press enter to return to previous menu OR");
				System.out.print("Please enter product code: ");
				//Create codeOfSelection string variable assign to userInput
				String codeOfSelection = userInput.nextLine().toUpperCase();
				try {
					//create boolean variable, default to false
					String purchaseMessage = vendingProducts.invalidProduct(codeOfSelection,  balance, log, salesReport);
					if (purchaseMessage == null) {
						throw new InvalidProductException();
					}
					System.out.println(purchaseMessage);

				} catch (InvalidProductException e) {
					System.out.println(e.getMessage());
				}
			} else if (choice.equals(PURCHASE_MENU_OPTION_FINISH)) {
				// exit menu
				System.out.println(balance.cashOut(log));
				break;
			}
		}
	}


	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		Menu purchaseMenu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu, purchaseMenu);
		cli.run();
	}
}
