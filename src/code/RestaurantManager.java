package code;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantManager {

	static ArrayList<String> names = new ArrayList<>();
	static ArrayList<Double> prices = new ArrayList<>();

	public static void findMenu() {
		String filename = "data/menu.txt";
		ClassLoader loader = RestaurantManager.class.getClassLoader();
		InputStream in = loader.getResourceAsStream(filename);
		if (in == null) {
			System.out.println("Error reading file: " + filename);
			return;
		}

		Scanner sc = new Scanner(in);

		while (sc.hasNextLine()) {
			String line = sc.nextLine();

			if (line.startsWith("#") || line.startsWith(" #") || line.equals("")) {
				continue;
			}

			String[] array = line.split("; ");

			names.add(array[0]);
			prices.add(Double.parseDouble(array[1]));
		}
		sc.close();
	}

	public static String[] getMenuItems() {
		ArrayList<String> listMenu = names;
		String[] items = listMenu.toArray(new String[listMenu.size()]);
		return items;
	}

	public static double[] getPrice() {
		ArrayList<Double> listPrice = prices;
		double[] menuPrice = new double[listPrice.size()];
		for (int i = 0; i < menuPrice.length; i++) {
			menuPrice[i] = listPrice.get(i);
		}
		return menuPrice;
	}

	public static void recordOrder(int orderNumber, int[] order, double total) {

	}

	static void setMenu(String filename) {
		String outputfile = "menu.txt";
		OutputStream out = null;
		try {
			out = new FileOutputStream(outputfile);
		} catch (FileNotFoundException ex) {
			System.out.println("Couldn't open output file " + outputfile);
			return;
		}
		PrintStream pout = new PrintStream(out);
		pout.close();
	}

	static void init() {
		String whereFile = "src/data/menu.txt";
		setMenu(whereFile);
	}
}