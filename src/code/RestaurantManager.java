package code;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantManager {

	static ArrayList<String> names = new ArrayList<>();
	static ArrayList<Double> prices = new ArrayList<>();
	static double[] quantities = new double[names.size()];
	static double[] choices = new double[prices.size()];
	
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
				
			}
			static void init() {
				
			}
	}

