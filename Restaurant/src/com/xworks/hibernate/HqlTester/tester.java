package com.xworks.hibernate.HqlTester;

import com.xworks.hibernate.RestaurantDAO.RestaurantDAO;
import com.xworks.hibernate.RestaurantDTO.RestaurantDTO;
import com.xworkz.hibernate.util.HibernateUtil;

public class tester 
{
	public static void main(String[] args)
	{
		RestaurantDTO dto=new RestaurantDTO();
		//dto.setRid(1);
		dto.setNoOfRooms(35);
		dto.setName("Taj");
		dto.setLocation("banglore");
		
		RestaurantDAO dao=new RestaurantDAO();
		dao.save(dto);
		
		HibernateUtil.getFactory().close();
	}
}
