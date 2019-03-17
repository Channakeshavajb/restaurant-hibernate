package com.xworks.hibernate.HqlTester;


import java.util.Collection;
import java.util.List;

import com.xworks.hibernate.RestaurantDAO.restauranDAOLatest;
import com.xworks.hibernate.RestaurantDTO.RestaurantDTO;
import com.xworkz.hibernate.util.HibernateUtil;

//import antlr.collections.List;

public class hqlTester7 {
	
	 
	public static void main(String[] args) 
	{
		System.out.println("******************************************");
		
		restauranDAOLatest dao=new restauranDAOLatest();
		
		Collection<Object[]> result=dao.getMaxOfIdAndNameByNoOfRooms(10);
		
		//List<Object[]> list=dao.fetchAllLocAndNoOfRooms("Taj");
		for(Object[] res :result)
		{
			System.out.println(res[0]);
			System.out.println(res[1]);
		}
		
		System.out.println("-------------------------------------");
		result.forEach(e->System.out.println(e));
		System.out.println("-------------------------------------");
		
		System.out.println("********************************************");
		
		dao.getCountByName("Taj");
		
		dao.getSumNoOfRooms();
		
		dao.getCount();
		
		System.out.println("************************************");
		
		Collection<RestaurantDTO> dtos=dao.fetchAll();
	
		//industry standard for-Each loop
		dtos.forEach(e->System.out.println(e));
		
		System.out.println("******************************************");
		
		Collection<String> dtos1=dao.fetchByColumns("kesari");
		dtos1.forEach(i->System.out.println(i));
		
		
		System.out.println("**********************************");
		
		
		// Very Important
			//here we getting output as Object Array Fully qualified name so
			//we convert the ref name method(fetchAllLocAndNoOfRooms) to list<Object[]> of Generic type
			//Whenever you see output l[L@..@...fully qualified name] then covert it to list and loop the object[] to get the utput 
			//for more details see the below example ArrayList() to Object conversion
		
		
		/*Home work..............: /*public List<?> fetchIdAndByName(String name)
		{
			retrun null;
		}*/
		
		List<Object[]> list=dao.fetchAllLocAndNoOfRooms("Taj");
		for(Object[] refOfElement :list)
		{
			System.out.println(refOfElement[0]);
			System.out.println(refOfElement[1]);
		}
		
		HibernateUtil.getFactory().close();
	}

}
