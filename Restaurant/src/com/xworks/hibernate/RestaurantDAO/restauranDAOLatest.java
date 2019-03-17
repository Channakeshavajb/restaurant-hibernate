package com.xworks.hibernate.RestaurantDAO;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.xworks.hibernate.HibernateUtil.hibernateUtil;
import com.xworks.hibernate.RestaurantDTO.RestaurantDTO;

//import antlr.collections.List;

public class restauranDAOLatest {

	public restauranDAOLatest() {
		System.out.println("restauranDAOLatest Created");
	}

	public Collection<Object[]> getMaxOfIdAndNameByNoOfRooms(int noOffRooms) {
		Session session = hibernateUtil.getFactory().openSession();
		try {
			Query query = session.getNamedQuery("fetchBy");
			query.setParameter("noOffRooms", noOffRooms);
			List<Object[]> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception caused in:" + e);
		} finally {
			session.close();
		}
		return null;
	}

	public Long getCountByName(String name1) {
		Session session = hibernateUtil.getFactory().openSession();

		try {
			Query query = session.getNamedQuery("fetchByName");
			query.setParameter("name1", name1);
			Long nameres = (Long) query.uniqueResult();
			System.out.println("-----------------------------------------");
			System.out.println("The\t\t" + name1 + "\t\tcount is\t\t" + nameres);
			System.out.println("------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception caused in :" + e);
		} finally {
			session.close();
		}
		return 0l;
	}

	public Long getSumNoOfRooms() {
		Session session = hibernateUtil.getFactory().openSession();
		try {
			Query query = session.getNamedQuery("fetchSumOfRooms");
			Long sum = (Long) query.uniqueResult();
			System.out.println("-----------------------------");
			System.out.println("The total nnumber of Rooms is:\t\t" + sum);
			System.out.println("--------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception caused in " + e);
		} finally {
			session.close();
		}
		return 0L;
	}

	public Long getCount() {
		Session session = hibernateUtil.getFactory().openSession();
		try {
			Query query = session.getNamedQuery("fetchCount");
			Long count = (Long) query.uniqueResult();
			System.out.println("-------------------------------------------------");
			System.out.println("Count of RestaurantDTO is\t\t...." + count);
			System.out.println("-------------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception caused in" + e);
		} finally {
			session.close();
		}
		return 0L;
	}

	public Collection<RestaurantDTO> fetchAll() {
		Session session = hibernateUtil.getFactory().openSession();
		try {
			String res = "select r from restauranDAOLatest r";
			Query query = session.getNamedQuery("selectAll");
			List<RestaurantDTO> list = query.list(); // instead of unique result
														// we use list because
														// we are getting
														// collection of columns
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception caused fetching data:" + e);
		} finally {
			session.close();
		}
		return null;
	}

	public Collection<String> fetchByColumns(String name) {
		Session session = hibernateUtil.getFactory().openSession();
		try {
			Query query = session.getNamedQuery("fetchBycolumn");
			query.setParameter("nm", name);
			List<String> list = query.list();
			// return list;
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception caused in" + e);
		} finally {
			session.close();
		}
		return null;
	}

	public List<Object[]> fetchAllLocAndNoOfRooms(String name) {
		Session session = hibernateUtil.getFactory().openSession();
		try {
			Query query = session.getNamedQuery("fetchByLocAndRooms");
			query.setParameter("nm", name);
			// List<RestaurantDTO> list=query.list();
			// return list;
			return query.list(); // it is returning list so we convert the
									// return to list of <>
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception caused in" + e);
		}

		finally {
			session.close();
		}
		return null;
	}

}
