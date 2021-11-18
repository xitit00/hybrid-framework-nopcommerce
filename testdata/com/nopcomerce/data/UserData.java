package com.nopcomerce.data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class UserData {

	// class này chứa subclass quản lý data test cho những classes trong
	// com.nopcommerce.user ,
	// chứ ko phải cứ mỗi class trong com.nopcommerce.user ,là mình lại tao ra bấy
	// nhiêu class bên trong com.nopcommerce.data
	// -> chỉ cần tạo ra 1 class bên trong chứa nhiều subclass quản lý data test là
	// đủ

	public class Login {
		
		List<String> listString = new ArrayList<String>();
		
		List<String> vector = new Vector<>();
		List<String> linkedList = new LinkedList<>();

		ArrayList<String> arrList = new ArrayList<String>();
	}

	public class Register {

	}

	public class Address {

	}

	public class Invoice {

	}
}
