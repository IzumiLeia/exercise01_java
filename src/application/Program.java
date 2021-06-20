package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Ordem;
import entities.Ordemitem;
import entities.Product;
import entities.enums.OrdemStatus;

public class Program {

	public static void main(String[] args) throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (dd/MM/yyyy) : ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrdemStatus status = OrdemStatus.valueOf(sc.next());
		
		Ordem ordem = new Ordem(new Date(), status, client);
		
		System.out.print("How many items to this order?");
		int N = sc.nextInt();
		for (int i=0; i<N; i++) {
			System.out.println("Enter #" + (i+1) + " item data:");
			System.out.print("Product name: ");
			sc.nextLine(); 
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			
			Ordemitem it = new Ordemitem(quantity, productPrice, product);
			
			ordem.addItem(it);
			
		}
		
		System.out.println();
		System.out.println(ordem);
	
		
		
		sc.close();



	}

}
