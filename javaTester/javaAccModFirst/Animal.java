package javaAccModFirst;

public class Animal {
	
	public String colorAnimal;
	protected String style;
	private int numAnimal;
	String environment;
	
	public void setNumAnimal(int numAnimal) {
		
		if (numAnimal > 0) {
			
			this.numAnimal = numAnimal;
		}
		else {
			
			System.out.print("Enter numAnimal is invalid");
		}
	}
	
	public int getNumAnimal() {
		
		return this.numAnimal;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Animal an = new Animal();
		an.numAnimal = 0;
		an.style = "";
		an.environment = "";
		an.colorAnimal = "";
		
	}

}
