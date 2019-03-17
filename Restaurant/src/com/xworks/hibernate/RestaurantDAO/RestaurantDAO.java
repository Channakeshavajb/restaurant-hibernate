package com.xworks.hibernate.RestaurantDAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xworks.hibernate.RestaurantDTO.RestaurantDTO;
import com.xworkz.hibernate.util.HibernateUtil;
public class RestaurantDAO 
{
	private static final String factory = null;

	public RestaurantDAO()
	{
		System.out.println("created.....");
	}
	
	public void save(RestaurantDTO dto)
	{
		Session session=HibernateUtil.getFactory().openSession();
		System.out.println("Saving restaurant....\t"+dto);
		System.out.println(factory!=null ? "factory found":"factory not found");
		Transaction transaction=session.beginTransaction();
		
		try
		{
			System.out.println("saving dto with session\t"+dto.getName());
			session.save(dto);
			transaction.commit();
			System.out.println("saving dto was successfully\t"+dto.getName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("exception saving dto \t"+dto.getName());
		}
		finally
		{
			//session.close();
			System.out.println("closing only session");
		}
	}
	
	public void updatenoOfRoomsFromDB(int rid,int newNoOfRooms)  
	{
		//Parameter's are odd coded we need to make it is Dynamic
		//if length exceed's from column of table length then it thorw's exception
		//for duplicate id's it gives error
		
		System.out.println("Invoked getById,with argument:\t"+rid);
		Session session=HibernateUtil.getFactory().openSession();
		Transaction transaction=session.beginTransaction();
		//update
		//step1
		
		try{
		RestaurantDTO dtoFromDB=session.get(RestaurantDTO.class,rid);
	
			if(dtoFromDB!=null)
			{
			dtoFromDB.setNoOfRooms(newNoOfRooms);
			session.update(dtoFromDB);
			transaction.commit();
			System.out.println("Update successfull to DB:\t"+newNoOfRooms);
			}
			else
			{
			System.out.println("rid not found"+rid);
			}
		}
		catch(Exception e)
		{
			System.err.println("Exception caused"+e);
			e.printStackTrace();
		}
		
	}
	
	public void deleteById(int rid)
	{
		System.out.println("invoked getById,with arg\t"+rid);
		
		Session session=HibernateUtil.getFactory().openSession();
		Transaction transaction=session.beginTransaction();
		
		//step:1
		//delete
		
		try
		{
			RestaurantDTO dtoFromDB=session.get(RestaurantDTO.class, rid);
			if(dtoFromDB!=null)
			{
				session.delete(dtoFromDB);
				transaction.commit();
				System.out.println("Restaurant id deleted"+rid);
			}else{
				System.out.println("rid not found"+rid);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception caused"+e);
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
	}
}
