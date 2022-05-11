package javOOP.overloading;

public class Overloading {
	
	private int fisrtNumber;
	private int secNumber;
	
	public void sumNumber() {
		
		System.out.print(this.fisrtNumber + this.secNumber);
	}
	
	public void sumNumber(int firstNum , int secNum) {
		
		this.fisrtNumber = firstNum;
		this.secNumber = secNum;
		
		System.out.print(this.fisrtNumber + this.secNumber);
	}
	
	public void sumNumber(int firstNum , float secNum) {
		
		
		System.out.print(firstNum + secNum);
	}
	
	public void sumNumber(float firstNum , float secNum) {
		
		
		System.out.print(firstNum + secNum);
	}

	// tính đa hình trong compile code 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Overloading over = new Overloading();
		over.sumNumber(7.5f,5.5f);
	}

}
