package javaOOP;

public class CarPOP {
	
	static String carCompany;
	static String carType;
	static String fuelType;
	static Float mileAge;
	static Double carPrice;

	public static void main(String[] args) {
		
		carCompany = "ABC";
		carType = "BWM";
		fuelType = "Petrol";
		mileAge = 200f;
		carPrice = 500000d;
		
		System.out.println("Car company = " + carCompany);
		System.out.println("Car type = " + carType);
		System.out.println("Fuel type = " + fuelType);
		System.out.println("Car mile type = " + mileAge);
		System.out.println("Car price = " + carPrice);
		
		carCompany = "Tesla";
		carType = "T500";
		fuelType = "Electric";
		mileAge = 500f;
		carPrice = 5000000000d;
		
		System.out.println("Car company = " + carCompany);
		System.out.println("Car type = " + carType);
		System.out.println("Fuel type = " + fuelType);
		System.out.println("Car mile type = " + mileAge);
		System.out.println("Car price = " + carPrice);
		
		
	}

}
