package javaOOP;

public class Topic_05_This_Super {
	
	private int firstNum;
	private int secondNum;
	
	

	public Topic_05_This_Super(int firstNum, int secondNum) {
	
		this.firstNum = firstNum;
		this.secondNum = secondNum;
	}
	
	public void sumNum() {
		
		System.out.println(firstNum + secondNum);
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Topic_05_This_Super topic = new Topic_05_This_Super(4, 3);
		topic.sumNum();
		

	}

}
