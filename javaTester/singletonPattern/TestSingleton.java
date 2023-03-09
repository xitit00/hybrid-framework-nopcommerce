package singletonPattern;

public class TestSingleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
		
//		GlobalConstants g1 = GlobalConstants.getBloGlobalConstants();
//		GlobalConstants g2 = GlobalConstants.getBloGlobalConstants();
//		GlobalConstants g3 = GlobalConstants.getBloGlobalConstants();
		
//		System.out.println(g1.hashCode());
//		System.out.println(g2.hashCode());
//		System.out.println(g3.hashCode());
		
		// Tạo ra nhiều thread để chạy xem coi GlobalConstants khởi tạo mấy lần 
		
		Thread t1 = new Thread(() -> GlobalConstants.getBloGlobalConstants());
		Thread t2 = new Thread(() -> GlobalConstants.getBloGlobalConstants());
		Thread t3 = new Thread(() -> GlobalConstants.getBloGlobalConstants());

		t1.start();
		t2.start();
		t3.start();
		
	
	}

}
