package code;
import java.util.Random;
import java.util.Scanner;
	public class skeRestaurant {
		/**
		  * User interface for a menu and ordering system,
		  * using console interface.
		  * You can delete your order or add by delete its quantity:)
		  * @author Korawit Rupanya
		  */
			static Scanner my = new Scanner(System.in);
			static int q1 = 0, q2 = 0, q3 = 0, sumq1, sumq2, sumq3, sump1, sump2, sump3;
			static int tt = 0;
			
			public static void receiptwithmember(int q1, int sumq1, int q2, int sumq2, int q3, int sumq3) {
				tt = q1 + q2 + q3;
				System.out.println("+------------Here is you receipt---------+");
				System.out.println("+------ Menu -----+-- Qty --+-- Price ---+");
				if (sumq1 >= 0) {
					System.out.printf("| Pizza\t\t   |   %5d |  %5d    |\n", sumq1, q1);
				}
				if (sumq2 >= 0) {
					System.out.printf("| Chickens\t   |   %5d |  %5d    |\n", sumq2, q2);
				}
				if (sumq3 >= 0) {
					System.out.printf("| Coke\t\t   |   %5d |  %5d    |\n", sumq3, q3);
				}
				System.out.println("+------------------+---------+-----------+");
				System.out.printf("| member discount%%10         |    %.2f  |\n", tt - (tt) * 0.9);
				System.out.printf("| Total\t\t             |    %.2f |\n", (tt) * 0.9);
				System.out.println("*------------------+---------+-----------*");
			}

			public static void total(int q1, int sumq1, int q2, int sumq2, int q3, int sumq3) {
				tt = q1 + q2 + q3;
				System.out.println("+------ Menu -----+-- Qty --+-- Price ---+");

				if (sumq1 >= 0) {
					System.out.printf("| Pizza\t\t   |   %5d |  %5d    |\n", sumq1, q1);
				}
				if (sumq2 >= 0) {
					System.out.printf("| Chickens\t   |   %5d |  %5d    |\n", sumq2, q2);
				}
				if (sumq3 >= 0) {
					System.out.printf("| Coke\t\t   |   %5d |  %5d    |\n", sumq3, q3);
				}
				System.out.println("+------------------+---------+-----------+");
				System.out.printf("| Total\t\t             |  %5d    |\n", tt);
				System.out.println("*------------------+---------+-----------*");
			}

			public static void SKEpromotion(int num1) {
				Random rand = new Random();
				int ran1 = rand.nextInt(3) + 1;
				if (num1 == ran1) {
					System.out.println("WOW!!! You are real SKE and and a real gambler too 555!!!");
					System.out.println("+------------Here is you receipt---------+");
					total(0, 0, 0, 0, 0, 0);
				} else {
					System.out.println("Sorry...You miss it!");
					System.out.println("+------------Here is you receipt---------+");
					total(q1, sumq1, q2, sumq2, q3, sumq3);
				}
			}
			
			public static void intro() {
				System.out.println("--------- Welcome to SKE Restaurant ---------");
				System.out.printf("1.Pizza\t\t  %5d Baht.%n", 250);
				System.out.printf("2.Chicken\t  %5d Baht.%n", 120);
				System.out.printf("3.Coke\t\t  %5d Baht.%n", 45);
				System.out.println("4.tatal");
				System.out.println("5.Get Receipt");
				System.out.println("6.The SKE promotion (Try this after you have already done your order.)");
				System.out.println("7.Exit");
			}
			
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
						if (choice == 1) {
							sump1 = quan * 250;
							q1 = q1 + sump1;
							sumq1 = sumq1 + quan;
						}
						if (choice == 2) {
							sump2 = quan * 120;
							q2 = q2 + sump2;
							sumq2 = sumq2 + quan;
						}
						if (choice == 3) {
							sump3 = quan * 45;
							q3 = q3 + sump3;
							sumq3 = sumq3 + quan;
						}
					} else if (choice == 4) {
						total(q1, sumq1, q2, sumq2, q3, sumq3);
					} else if (choice == 5) {
						System.out.print("Do you have member card Y/N?");
						String member = my.next();
						if (member.equals("Y")) {
							receiptwithmember(q1, sumq1, q2, sumq2, q3, sumq3);
						} else if (member.equals("N")) {
							System.out.println("+------------Here is you receipt---------+");
							total(q1, sumq1, q2, sumq2, q3, sumq3);
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
							total(q1, sumq1, q2, sumq2, q3, sumq3);
							break;
						}
					}
				}
			}
			
			public static void main(String[] args){
				intro();
				choices();
			}
		}
