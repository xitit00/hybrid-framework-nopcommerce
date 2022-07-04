package javaOOP.knowledge;

public class Topic_06_Getter_Setter {
	
	private String personName;
	private int personAge;
	private int personPhone;
	private float personBankAccountAmount;
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		
		if (personName == null || personName.isEmpty() || personName.isBlank()) {
			
			throw new IllegalArgumentException("Tên nhập vào ko đc bỏ trống!");
		}
		else {
			
			this.personName = personName;
		}
		
		
	}
	public int getPersonAge() {
		return personAge;
	}
	public void setPersonAge(int personAge) {
		
		if (personAge > 0 && personAge <= 100) {
			
			this.personAge = personAge;
		}
		else {
			
			throw new IllegalArgumentException("Số tuổi ko hợp lệ!");
		}
	}
	public int getPersonPhone() {
		
		return personPhone;
	}
	public void setPersonPhone(int personPhone) {
		
		if (!String.valueOf(personPhone).startsWith("0")) {
			
			throw new IllegalArgumentException("Sdt ko hợp lệ!");
		}
		else {
			
			this.personPhone = personPhone;
		}
		
		
	}
	public float getPersonBankAccountAmount() {
		
		return personBankAccountAmount;
		
	}
	public void setPersonBankAccountAmount(float personBankAccountAmount) {
		
		if (personBankAccountAmount < 50000) {
			
			throw new IllegalArgumentException("Stk ko dc bé hơn 50000!");
		}
		else {
			

			this.personBankAccountAmount = personBankAccountAmount;
		}
		
	}

}
