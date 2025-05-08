package com.ebrain.browse;
import java.util.*;

public class HashMapCore {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> cars = new ArrayList<>();

		HashMap<String, ArrayList<String>> sample = new HashMap<>();
		

		System.out.println("Enter the car brand:");
		String brand = scanner.nextLine();

	
		System.out.println("How many cars  enter for " + brand + "?");
		int numberOfCars = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < numberOfCars; i++) {
			System.out.println("Enter car " + (i + 1) + " model:");
			cars.add(scanner.nextLine());
		}
		
		
		sample.put(brand, cars);

	
		System.out.println("Cars under " + sample );

	
	
		scanner.close();
	}
}
