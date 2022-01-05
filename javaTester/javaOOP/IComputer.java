package javaOOP;

public interface IComputer {
	
	//Mọi method trong interface đều là abstract , cho dù ko viết ra thì mặc định nó hiểu ngầm abstract là bắt buộc 
	// lỗi khai báo {} phần than trong method abstract -> Abstract methods do not specify a body => nhớ remove phần thân đi , 	public void showComputerPerforamance();
//	public void showComputerPerforamance() {
//		
//		
//	}
	
	// Abstract Method
	public abstract void showComputerRam();

}
