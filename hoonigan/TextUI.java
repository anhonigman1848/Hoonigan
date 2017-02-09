package hoonigan;

import java.util.Scanner;

public class TextUI {

	public static void main(String[] args){

		Library library = new Library();

		boolean keepRunning = true;

		Scanner input = new Scanner(System.in);

		//while keepRunning is true
		//Prompt user for checkin/checkout input

		while (keepRunning == true) {

			library.printLibrary();

			try{
				System.out.print(
						"Would you like to check out [enter 0], check in [enter 1], or quit [enter 2]: ");
				int checkStatus = -1;
				
				try {
					checkStatus = Integer.parseInt(input.nextLine());
				}
				catch (Exception ex) {
				}

				if (checkStatus == 2) {
					System.out.println("Goodbye then");
					input.close();
					System.exit(0);
				}


				else if (checkStatus == 0) {
					//Prompt user for search input
					System.out.print("Enter the ID for the item would you like to check out: ");
					String searchId = input.nextLine();
					
					if (library.validId(searchId)) {
						if (library.itemCheckedOut(searchId)) {
							System.out.println("This item is already checked out");
						}
						else {
							library.checkOutItem(searchId);
							System.out.println("Item checked out successfully");
						}
					}

					else {
						System.out.println("Item not found, try again");
					}

				}

				else if (checkStatus == 1) {
					//Prompt user for search input
					System.out.print("Enter the ID for the item would you like to check in: ");
					String searchId = input.nextLine();

					if (library.validId(searchId)) {
						if (!library.itemCheckedOut(searchId)) {
							System.out.println("This item is already checked in");
						}
						else {
							library.checkInItem(searchId);
							System.out.println("Item checked in successfully");
						}
					}

				}

				else {
					System.out.println("I didn't understand, try again");
				}

			}catch(Exception ex){
				ex.printStackTrace();
			}

		}


	}

}
