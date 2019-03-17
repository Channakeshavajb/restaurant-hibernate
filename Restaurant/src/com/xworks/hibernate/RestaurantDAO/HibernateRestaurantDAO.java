package com.xworks.hibernate.RestaurantDAO;

import com.xworkz.hibernate.util.HibernateUtil;

public class HibernateRestaurantDAO 
{
	public HibernateRestaurantDAO()
	{
		System.out.println("created.....");
	}
	
	public RestaurantDTO fetchByName(String name)
	{
		System.out.println("Fetch by name\t"+name);
		
		Session session=HibernateUtil.getFactory().openSession();
		
		try
		{
		//step1 :prepare the query
			String syntax="select rdto from RestaurantDTO rdto where rdto.name='"+name+"'";
			Query query=session.createQuery(syntax);
			//
			System.out.println("return object from session.createQuery"+query);
			
			//step:2 process the query
			RestaurantDTO dtoFromDB=(RestaurantDTO)query.uniqueResult();
			
			if(dtoFromDB!=null)
			{
				System.out.println("Data found for from dto\t "+name+"details"+dtoFromDB);
				return dtoFromDB;
			}else{
				System.out.println("data not found for name\t"+name);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("exception caused by name\t"+name);
		}
		finally
		{
			session.close();
		}
		return null;
	}
}
