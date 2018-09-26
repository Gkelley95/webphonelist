package View;

import java.util.List;
import java.util.Scanner;

import Controller.ListItemHelper;
import model.ListItem;

public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static ListItemHelper lih = new ListItemHelper();

	private static void addAnItem() {

		System.out.print("Enter a brand: ");
		String brand = in.nextLine();
		System.out.print("Enter an item: ");
		String item = in.nextLine();
		System.out.print("Enter a price: ");
		String price = in.nextLine();

		ListItem toAdd = new ListItem(brand, item, price);
		lih.insertItem(toAdd);
	}

	private static void deleteAnItem() {

		System.out.print("Enter the brand to delete: ");
		String brand = in.nextLine();
		System.out.print("Enter the item to delete: ");
		String item = in.nextLine();
		ListItem toDelete = new ListItem(brand, item, null);

		lih.deleteItem(toDelete);
	}

	private static void editAnItem() {

		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Brand");
		System.out.println("2 : Search by Item");

		int searchBy = in.nextInt();
		in.nextLine();

		List<ListItem> foundItems;

		if (searchBy == 1) {

			System.out.print("Enter the brand name: ");
			String brandName = in.nextLine();
			foundItems = lih.searchForItemBybrand(brandName);

		} else {

			System.out.print("Enter the item: ");
			String itemName = in.nextLine();
			foundItems = lih.searchForItemByItem(itemName);

		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");

			for (ListItem l : foundItems) {
				System.out.println("ID: " + l.getId() + " - " + l.returnItemDetails());

			}

			System.out.print("Which ID to edit: ");

			int idToEdit = in.nextInt();

			ListItem toEdit = lih.searchForItemById(idToEdit);

			System.out.println("Retrieved " + toEdit.getItem() + " from " + toEdit.getBrand());
			System.out.println("1 : Update Brand");
			System.out.println("2 : Update Item");
			System.out.println("3 : Update Price");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {

				System.out.print("New brand: ");
				String newbrand = in.nextLine();
				toEdit.setBrand(newbrand);

			} else if (update == 2) {

				System.out.print("New Item: ");
				String newItem = in.nextLine();
				toEdit.setItem(newItem);
			} else if (update == 3) {

				System.out.print("New Price: ");
				String newPrice = in.nextLine();
				toEdit.setPrice(newPrice);
			}
			
			lih.updateItem(toEdit);

		} else {

			System.out.println("---- No results found");

		}
	}

	public static void main(String[] args) {
		runMenu();
	}

	public static void runMenu() {

		boolean goAgain = true;

		System.out.println("--- Welcome to the Phone Database ---");

		while (goAgain) {

			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an item");
			System.out.println("*  2 -- Edit an item");
			System.out.println("*  3 -- Delete an item");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {

				editAnItem();
			} else if (selection == 3) {

				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();

			} else {

				lih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
		}
	}

	private static void viewTheList() {

		List<ListItem> allItems = lih.showAllItems();
		for(ListItem l : allItems){
			System.out.println(l.returnItemDetails());
		}
	}
}