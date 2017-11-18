package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for manager to load menu,get menu items,get prices of items,record
 * order,and write menu.
 * 
 * @author Korawit Rupanya
 */

public class RestaurantManager {

	static ArrayList<String> names = new ArrayList<>();
	static ArrayList<Double> prices = new ArrayList<>();

	/**
	 * Load the data from file and add those data to list.
	 */
	public static void loadMenu() {
		String filename = "data/menu.txt";
		ClassLoader loader = RestaurantManager.class.getClassLoader();
		InputStream in = loader.getResourceAsStream(filename);
		if (in == null) {
			System.out.println("Error reading file: " + filename);
			return;
		}

		Scanner sc = new Scanner(in);

		while (sc.hasNextLine()) {
			String line = sc.nextLine().trim();
			if (line.startsWith("#") || line.equals("")) {
				continue;
			}
			String[] array = line.split(";");

			names.add(array[0]);
			prices.add(Double.parseDouble(array[1]));
		}
		
		sc.close();
	}

	/**
	 * Get names of items then add them to array menuItems.
	 * 
	 */
	public static String[] getMenuItems() {
		ArrayList<String> listMenu = names;
		String[] items = listMenu.toArray(new String[listMenu.size()]);
		return items;
	}

	/**
	 * Get prices of items then add them to array menuPrices.
	 * 
	 */
	public static double[] getPrices() {
		ArrayList<Double> listPrice = prices;
		double[] menuPrice = new double[listPrice.size()];
		for (int i = 0; i < menuPrice.length; i++) {
			menuPrice[i] = listPrice.get(i);
		}
		return menuPrice;
	}

	/*
	 * Write the receipt.
	 */
	public static void writeReceipt(ArrayList<Object> allOrder) throws IOException {
		String outputfile = "src/data/receipt.txt";
		File out1 = new File(outputfile);
		FileOutputStream out;
		try {
			out = new FileOutputStream(out1);
		} catch (FileNotFoundException ex) {
			System.out.println("Couldn't open output file " + out1);
			return;
		}
		String receipt = "",dateTime = "",memberRec = "",promotionRec = "";
		for(int x = 0;x < allOrder.size();x++) {
			receipt = ((OrderRecord) allOrder.get(x)).getAllOrder();
			dateTime = ((OrderRecord) allOrder.get(x)).getDateTime();
			memberRec = ((OrderRecord) allOrder.get(x)).getMember();
			promotionRec = ((OrderRecord) allOrder.get(x)).getPromotion();
			
			PrintStream pout = new PrintStream(out);
			pout.println(dateTime);
			pout.println(memberRec +" , "+ promotionRec);
			pout.println(receipt);
			pout.println("--------------------------------------");
		}
	}
}