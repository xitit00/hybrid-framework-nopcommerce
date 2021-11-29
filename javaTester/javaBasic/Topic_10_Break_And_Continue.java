package javaBasic;

public class Topic_10_Break_And_Continue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		for (int i = 0; i < 10; i++) {
//			
//			// Loại trừ 1 đk này ra , còn lại đề in ra 
//			// i = 0, 1,2,3,4,6,7,8,9
////			if (i == 5) {
////		
////				continue;
////			}
//			
//			// thoát khỏi vòng lặp , khi gặp đk này
//			// i = 1,2,3,4 
//			if (i == 5) {
//
//				break;
//			}
//			
//			System.out.println(i);
//		}
		
		// nested for , for lồng for 
		// break hoặc continue đc dùng cho for bên trong , ko ảnh hưởng đến for bên ngoài 
		for (int i = 0; i < 5 ; i++) {
			
			System.out.print("i: " + i);
			
			for (int j = 0; j < 5; j++) {
				
				if (j==4) {
					
					continue;
				}
				
				System.out.print("j: " + j);

			}
		}
	}

}
