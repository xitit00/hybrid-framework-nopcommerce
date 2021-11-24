package javaBasic;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class Topic_08_For_Each {
	
	
	//@Test 
	public void TC_01_For() {
		

		// String Array 
		String[] cityName = {"Ha Noi","HCM","Da Nang","Can Tho"};
		
		for (int i = 0; i < cityName.length; i++) {
			
			String strCity = cityName[i];
			System.out.println(strCity);
			
			
		}
		
		// String Array ket hop If/break for
		
		for (int i = 0; i < cityName.length; i++) {
			
			String strCity = cityName[i];
			if (strCity.equals("HCM")) {
				
				System.out.println(strCity);
				break;
			}
			
		}
	
		
		// For each 
		
		int y = 0;
		for (String strCity : cityName) {
			
			if (strCity.equals("Da Nang")) {
				
				System.out.println(y);
				break;
			}
			
			y++;
		}
		
	}
	
	@Test
	public void TC_02_For() {
		
		// Java Collection : Interface implements Class 
		// Class : ArrayList / LinkedList / vector 
		// Interface : List / Set / Queue
		// -> List : ArrayList / LinkedList / Vector , Set : HashSet , Queue : Priority Queue , ...
		
		String[] cityName = {"HN", "HCM" , "Da Nang", "Can Tho", "Hai Phong", "Khanh Hoa"};
		
		List<String> cityAddress = new ArrayList<String>();
		
		
		for (String strName : cityName) {
			
			cityAddress.add(strName);
			System.out.print(strName);

		}
		
		int i = cityAddress.indexOf("Da Nang");
		cityAddress.set(i, "Long An");
		
		for (String strAddress : cityAddress) {
			
			System.out.print(strAddress);
			
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
