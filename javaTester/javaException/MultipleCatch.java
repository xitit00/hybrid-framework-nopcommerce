package javaException;

public class MultipleCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// với những exception mà mình biết kq của nó thì mình có thể ghi rõ ra như vd bên dưới : Arith , Array Index ...
		// và cũng có thể gộp exception lại hoặc tách ra như 2 vd (1) , (2) bên dưới
		
//		(1) gộp lại
//		try {
//			
//		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} 
		
		int array[] = new int[10];

//		(2) tách ra
		try {
			
			array[10] = 30 / 1;
		}
		catch (ArithmeticException e) {
			
			// System.out.println("Ko thể chia ")
			e.printStackTrace();
		}
		catch (ArrayIndexOutOfBoundsException e) {
			
			// System.out.println("Index vượt ngoài độ dài của Mảng ");
		}
		
		// 
		
		
	}
}
