package eclipseTips;


import org.testng.annotations.Test;

public class Topic_02_Debug {
	
	String strTemp = "Ho Chi Minh";
	int numTemp = 20;
	

	@Test
	public void TC_01() {
		
		String a = strTemp;
		System.out.println(a);
		
		int b = numTemp;
		System.out.println(b);
	
		
	}
}
