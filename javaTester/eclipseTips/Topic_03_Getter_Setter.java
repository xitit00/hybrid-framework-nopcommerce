package eclipseTips;

public class Topic_03_Getter_Setter {
	
	private String myName;

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Topic_03_Getter_Setter topic03 = new Topic_03_Getter_Setter();
		topic03.myName = "anh BTC";
		System.out.println(topic03.myName);

	}

}
