package code;

import java.util.Random;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * User interface for a menu and ordering system, using console interface. You
 * can delete your order or add by delete its quantity:)
 * 
 * @author Korawit Rupanya
 */

public class SkeRestaurant {

	static RestaurantManager theManager = new RestaurantManager();
	static Scanner my = new Scanner(System.in);
	static int quantity = 0;
	static String[] menuItems = RestaurantManager.getMenuItems();
	static double[] unitPrice = RestaurantManager.getPrices();
	static double[] totalQuantity = new double[menuItems.length];
	static double[] price = new double[menuItems.length];

	public static void getPrice(int quan) {
		quantity = my.nextInt();
		totalQuantity[quan - 1] += quantity;
		price[quan - 1] = totalQuantity[quan - 1] * unitPrice[quan - 1];
	}

	public static int totalPrice() {
		int tt = 0;
		for (int i = 0; i < menuItems.length; i++) {
			tt += price[i];
		}

		return tt;
	}

	// this method print receipt with discount for membership
	public static void receiptwithmember() {
		System.out.println("+------------Here is you receipt---------+");
		System.out.println("+------ Menu -----+-- Qty --+-- Price ---+");
		for (int i = 0; i < menuItems.length; i++) {
			if (totalQuantity[i] != 0) {
				System.out.printf("| %-17s|%9f|%11f|\n", menuItems[i], totalQuantity[i], price[i]);
			}
		}
		System.out.println("+------------------+---------+-----------+");
		System.out.printf("| member discount%%10         |    %.2f  |\n", totalPrice() - (totalPrice() * 0.9));
		System.out.printf("| Total\t\t             |    %.2f |\n", (totalPrice()) * 0.9);
		System.out.println("*------------------+---------+-----------*");
	}

	// this method print total for check total prices
	public static void total() {
		System.out.println("+------ Menu -----+-- Qty --+-- Price ---+");
		for (int i = 0; i < menuItems.length; i++) {
			if (totalQuantity[i] != 0) {
				System.out.printf("| %-17s|%9d|%11d|\n", menuItems[i], totalQuantity[i], price[i]);
			}
		}
		System.out.println("+------------------+---------+-----------+");
		System.out.printf("| Total\t\t             |  %.2f    |\n", totalPrice());
		System.out.println("*------------------+---------+-----------*");
	}

	// this method print the special Ske promotion
	public static void SKEpromotion(int num1) {
		Random rand = new Random();
		int ran1 = rand.nextInt(3) + 1;
		if (num1 == ran1) {
			System.out.println("WOW!!! You are real SKE and and a real gambler too 555!!!");
			System.out.println("+------------Here is you receipt---------+");
			System.out.println("+------ Menu -----+-- Qty --+-- Price ---+");
			for (int i = 0; i < menuItems.length; i++) {
				if (totalQuantity[i] != 0) {
					System.out.printf("| %-17s|%9d|%11d|\n", menuItems[i], totalQuantity[i], price[i]);
				}
			}
			System.out.println("+------------------+---------+-----------+");
			System.out.printf("| Total\t\t             |  %.2f    |\n", 0);
			System.out.println("*------------------+---------+-----------*");
			
		} else {
			System.out.println("Sorry...You miss it!");
			System.out.println("+------------Here is you receipt---------+");
			total();
		}
	}

	// this method print menu
	public static void intro() {
		System.out.println("--------- Welcome to SKE Restaurant ---------");
		for (int x = 0; x < menuItems.length; x++) {
			System.out.printf("%d. %s\t\t%.2f Baht.\n", x + 1, menuItems[x], unitPrice[x]);
		}
		;
		System.out.println("4.tatal");
		System.out.println("5.Get Receipt");
		System.out.println("6.The SKE promotion (Try this after you have already done your order.)");
		System.out.println("7.Exit");
	}

	// this method contains logic about how user choose choices
	public static void choices() {
		while (true) {
			System.out.print("Enter your Choice: ");
			int choice = my.nextInt();
			if (choice == 7) {
				System.out.print("==========Thank you==========");
				break;
			} else if (choice >= 1 && choice < 4) {
				System.out.print("Enter Quantity: ");
				int quan = my.nextInt();
				getPrice(choice);
			} else if (choice == 4) {
				total();
			} else if (choice == 5) {
				System.out.print("Do you have member card Y/N?");
				String member = my.next();
				if (member.equals("Y")) {
					receiptwithmember();
				} else if (member.equals("N")) {
					System.out.println("+------------Here is you receipt---------+");
					total();
				}
				break;

			} else if (choice == 6) {
				System.out.println(
						"If you can answer this question right,you will be taken to random phase.\nIf you are real SKE and lucky enough you might get a free meal!!!\nWhat is code name of java version J2SE 5.0 that was released on September 30, 2004.?");
				System.out.println("Choice 1.CAT 2.TIGER 3.LION 4.CHHETAH 5.LEOPARD");
				System.out.print("Enter your answer:");
				int answer = my.nextInt();
				if (answer == 2) {
					System.out.print("CONGRATULATION!!! Please enter number 1,2 or 3 : ");
					int num1 = my.nextInt();
					SKEpromotion(num1);
					break;
				} else {
					System.out.println("Sorry you are not real SKE?");
					System.out.println("+------------Here is you receipt---------+");
					total();
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		intro();
		choices();
	}
}