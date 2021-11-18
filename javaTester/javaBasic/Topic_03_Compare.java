package javaBasic;

public class Topic_03_Compare {
	
	int number = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Kiểu nguyên thuỷ 
		int x = 5 ; 
		int y = x ; 
		System.out.println(x);
		System.out.println(y);

		
		// Kiểu tham chiếu 
		
		Topic_03_Compare topic = new Topic_03_Compare();
		Topic_03_Compare topic1 = topic;
//		Topic_03_Compare topic1 = new Topic_03_Compare();
//		
//		topic = topic1;
		
		topic1.number = 8;
		
		System.out.println(topic.number);
		System.out.println(topic1.number);


	}

}
