package javaOOP;

public class CarOOP {
	
	String carCompany;
	String carType;
	String fuelType;
	Float mileAge;
	Double carPrice;
	
	protected String getCarCompany() {
		
		System.out.println("Car company = " + carCompany);
		
		return carCompany;
	}

	public CarOOP(String carCompany, String carType, String fuelType, Float mileAge, Double carPrice) {
	
		this.carCompany = carCompany;
		this.carType = carType;
		this.fuelType = fuelType;
		this.mileAge = mileAge;
		this.carPrice = carPrice;
	}

	protected void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}

	protected String getCarType() {
		
		System.out.println("Car type = " + carType);
		
		return carType;
	}

	protected void setCarType(String carType) {
		
		
		
		this.carType = carType;
	}

	protected String getFuelType() {
		
		System.out.println("Fuel type = " + fuelType);
		
		return fuelType;
	}

	protected void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	protected Float getMileAge() {
		
		System.out.println("Car mile type = " + mileAge);
		
		return mileAge;
	}

	protected void setMileAge(Float mileAge) {
		
		
		this.mileAge = mileAge;
	}

	protected Double getCarPrice() {
		
		
		System.out.println("Car price = " + carPrice);
		
		return carPrice;
	}

	protected void setCarPrice(Double carPrice) {
		this.carPrice = carPrice;
	}

	
	public void showInfoCar() {
		
		carCompany = getCarCompany();
		carType = getCarType();
		fuelType = getFuelType();
		mileAge = getMileAge();
		carPrice = getCarPrice();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// generate with get , set 
//		CarOOP honda = new CarOOP();
//		honda.setCarCompany("Honda");
//		honda.setCarType("CRV");
//		honda.setCarPrice(1500000d);
//		honda.setFuelType("Petrol");
//		honda.setMileAge(100f);
//		honda.showInfoCar();
		
		
		// generate with constructor 
		CarOOP ford = new CarOOP("Ford", "Everest", "Petrol", 50f, 500000d);
		ford.showInfoCar();
		
	}

}
