package javaBasic;

import com.github.javafaker.Faker;

public class Topic_19_Faker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// default US
		Faker faker = new Faker();
		System.out.println(faker.address().firstName());
		System.out.println(faker.address().lastName());
		System.out.println(faker.business().creditCardNumber());
		System.out.println(faker.business().creditCardExpiry());
		System.out.println(faker.business().creditCardType());
		
		// default VN 
		Faker fakerVN = new Faker();
		System.out.println(fakerVN.address().firstName());
		System.out.println(fakerVN.address().lastName());
		
	
	}

}
