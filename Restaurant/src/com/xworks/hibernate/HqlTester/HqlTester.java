package com.xworks.hibernate.HqlTester;

import com.xworks.hibernate.RestaurantDAO.HibernateRestaurantDAO;
import com.xworks.hibernate.RestaurantDTO.RestaurantDTO;

public class HqlTester {

	public static void main(String[] args)
	{
		HibernateRestaurantDAO dao=new HibernateRestaurantDAO();
		
		RestaurantDTO dto=dao.fetchByName("Taj");
		
		if(dto!=null)
		{
			System.out.println("Book Hotel");
		}
	}

}
