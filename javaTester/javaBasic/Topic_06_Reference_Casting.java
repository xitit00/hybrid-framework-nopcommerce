package javaBasic;


public class Topic_06_Reference_Casting {
	
	public String stdName;
	
	public String getStdName() {
		
		return stdName;
	}
	
	public void setStdName(String stdName) {
		
		this.stdName = stdName;
	}
	
	public void showStdName() {
		
		System.out.println("Std name = " + getStdName());
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		Topic_06_Reference_Casting firstStd = new Topic_06_Reference_Casting();
		Topic_06_Reference_Casting secondStd = new Topic_06_Reference_Casting();

		firstStd.setStdName("ABC"); 
		secondStd.setStdName("DEF");;
		
		firstStd.showStdName();
		secondStd.showStdName();
		
		firstStd = secondStd;
		
		firstStd.showStdName();
		secondStd.showStdName();
		
		firstStd.setStdName("GHK");
		firstStd.showStdName();
		secondStd.showStdName();
		
		
	}

}
