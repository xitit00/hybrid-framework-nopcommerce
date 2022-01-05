package javaOOP;

public class Topic_01_Class_Object_Student {
	
	private int MSSV;
	private String hoTen;
	private float diemLT;
	private float diemTH;
	
	

	protected int getMSSV() {
		return MSSV;
	}



	protected void setMSSV(int mSSV) {
		MSSV = mSSV;
	}



	protected String getHoTen() {
		return hoTen;
	}



	protected void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}



	protected float getDiemLT() {
		return diemLT;
	}



	protected void setDiemLT(float diemLT) {
		this.diemLT = diemLT;
	}



	protected float getDiemTH() {
		return diemTH;
	}



	protected void setDiemTH(float diemTH) {
		this.diemTH = diemTH;
	}

	
	public void showInfoSV() {
		
		MSSV = getMSSV();
		System.out.println("MSSV: " + MSSV);
		hoTen = getHoTen();
		System.out.println("Ho ten: " + hoTen);
		diemLT = getDiemLT();
		System.out.println("Diem LT: " + diemLT);
		diemTH = getDiemTH();
		System.out.println("Diem TH: " + diemTH);
		
		float diemTB = (diemLT + diemTH*2) / 3;
		System.out.println("Diem TB: "+ diemTB);
	}

	public static void main(String[] args) {
		
		Topic_01_Class_Object_Student e = new Topic_01_Class_Object_Student();
		
		e.setMSSV(01);
		e.setHoTen("Anh");
		e.setDiemLT(8);
		e.setDiemTH(7);
		
		e.showInfoSV();

	}

}
