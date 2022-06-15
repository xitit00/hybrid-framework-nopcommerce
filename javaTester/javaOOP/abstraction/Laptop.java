package javaOOP.abstraction;

// 1 class ko kế thừa nhiều đc , ko giống interface 
public class Laptop extends Computer {

	// implement abstact method from Computer class
	@Override
	public void setRam() {
		// TODO Auto-generated method stub
		
	}
	
	// có thể gọi normal method từ abstract class ra dùng 
	public void renderVideo() {
		
		showCPU();
	}
	
	// hoặc override lại theo tính kế thừa thì tuỳ 
	@Override
	public void showCPU() {
		// TODO Auto-generated method stub
		super.showCPU();
		
	}

	
}
