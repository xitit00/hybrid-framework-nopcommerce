package javaAccModSecond;

import javaAccModFirst.Animal;
import javaAccModFirst.Dog;

public class Fish extends Animal {
	
	// ko dc vi cat la default class
	//Cat c = new Cat();
	
	Dog d = new Dog();
	
	public void showProperties() {
		
		this.style = "";
		this.colorAnimal = "";
		
		this.setNumAnimal(4);
		int numAnimal = this.getNumAnimal();
		System.out.println(numAnimal);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

}
