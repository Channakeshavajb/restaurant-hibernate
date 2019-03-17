package com.xworks.hibernate.HqlTester;

import com.xworks.hibernate.RestaurantDAO.RestaurantDAO;

public class updateTester 
{
	public static void main(String[] args)
	{
		RestaurantDAO updateDAO=new RestaurantDAO();
		updateDAO.updatenoOfRoomsFromDB(5,40);
	}
}
