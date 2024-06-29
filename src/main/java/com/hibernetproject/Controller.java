package com.hibernetproject;

import java.util.List;
import java.util.Scanner;

public class Controller {
	public static void main(String[] args) {

		CustomerDAO dao = new CustomerDAO();
		boolean choice = true;
		while (choice) {
			System.out.println("Enter 1 to INSERT data \n Enter 2 to FETCH_one \n Enter 3 to UPDATE \n "
					+ "Enter 4 to DELETE data \n Enter 5 to FETCH_all data \n Enter 6 to EXIT");

			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			switch (option) {
			case 1: {
				System.out.println("Enter name");
				String name = scanner.next();
				System.out.println("Enter product");
				String product = scanner.next();
				System.out.println("Enter price");
				int price = scanner.nextInt();
				Customer customer = new Customer(name, product, price);
				dao.insert(customer);
				break;
			}

			case 2: {
				System.out.println("Enter ID of which data you want to FETCH");
				int id = scanner.nextInt();
				System.out.println(dao.fetch(id));
				break;
			}

			case 3: {
				System.out.println("Enter ID of which data you want to UPDATE");
				int id = scanner.nextInt();
				Customer customer = dao.fetch(id);
				System.out.println("Enter name you want to UPDATE for this ID " + id);
				String name = scanner.next();
				customer.setName(name);
				System.out.println("Enter product name you want to UPDATE for this ID " + id);
				String pname = scanner.next();
				customer.setPname(pname);
				dao.update(customer);
				System.out.println("Data got UPDATED");
				break;
			}

			case 4: {
				System.out.println("Enter ID to Delete data of that ID");
				int id = scanner.nextInt();
				Customer customer = dao.fetch(id);
				dao.delete(customer);
				System.out.println("DATA got DELETED");
				break;
			}

			case 5: {
				System.out.println("Displaying all data present in DATABASE");
				List<Customer> a=dao.fetchall();
				for(Customer x:a) {
					System.out.println(x);
				}
				System.out.println("---------------");
				break;
			}

			case 6: {
				choice = false;
				System.out.println("Succefull exited");
				break;
			}
			default:
				break;
			}
		}
	}
}
