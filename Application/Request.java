package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import EntitieClient.Client;
import Entities.Order;
import Entities.OrderItem;
import Entities.Product;
import EntitiesEnum.OrderStatus;

public class Request {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		//Order order = new Order();
		
		System.out.println("Enter Cliente Date: ");
		System.out.print("Name: ");
		String nameClient = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth Date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		//System.out.println(sdf.format(birthDate));
		Client cliente = new Client(nameClient, email, birthDate);
		
		System.out.println("Enter order Data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		//String status = sc.next();
		
		Order order = new Order(new Date(), status, cliente);
		
		System.out.println();
		
		System.out.print("How many items to this order? ");
		int cont = sc.nextInt();
		
		System.out.println();
		
		for(int i = 1; i <= cont;i++) {
			System.out.printf("Enter #%d item data", i);
			System.out.println();
			System.out.print("Poduct Name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer productQuantity = sc.nextInt();
			System.out.println();
			//order = new Order(new Date(), OrderStatus.valueOf(status), new Product(productName, productPrice),
			//new Client(nameClient, email, birthDate), new OrderItem(productQuantity, productPrice));
			Product prod = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, prod);
			
			order.addItem(orderItem);

		}
		//order = new Order(new Date(), OrderStatus.valueOf(status), prod, cliente);
		
		System.out.println();
		System.out.println("Order Sumary: ");
		System.out.println();
		System.out.println(order);
		sc.close();
	}
}
