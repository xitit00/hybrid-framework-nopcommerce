package javaOOP;


public class Topic_05_This {
	
	private int firstNum;
	private int secondNum;
	
	
	public Topic_05_This() {
		
		// constructor lồng constructor
		this(10,15);
	}

	public Topic_05_This(int firstNum, int secondNum) {
	
		// tham chiếu đến biến
		this.firstNum = firstNum;
		this.secondNum = secondNum;
	}
	
	public void sumNum() {
		
		System.out.println(firstNum + secondNum);
	}
	
	public void showNumber() {
		
		// gọi method hiện tại
		this.sumNum();
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Topic_05_This_Super topic = new Topic_05_This_Super(4, 3);
//		topic.showNumber();
		
		
		Topic_05_This topic = new Topic_05_This();
		topic.sumNum();

	}

}
