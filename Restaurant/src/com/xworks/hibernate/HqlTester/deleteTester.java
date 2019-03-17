package com.xworks.hibernate.HqlTester;

import com.xworks.hibernate.RestaurantDAO.RestaurantDAO;

public class deleteTester {

	public static void main(String[] args) 
	{
		RestaurantDAO dao=new RestaurantDAO();
		dao.deleteById(4);
	}

}
