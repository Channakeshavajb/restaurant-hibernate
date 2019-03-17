package com.xworks.hibernate.RestaurantDTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Restaurant")
// @NamedQueries(name="selectAll",query="select r from RestaurantDTO r")

/*
 * @NamedQueries{
 * 
 * @NamedQuery(name="selectAll",query="select r from RestaurantDTO r"),
 * 
 * @NamedQuery(name="fetchBycolumn",
 * query="select r.location from RestaurantDTO r") }
 */

@NamedQueries({ @NamedQuery(name = "selectAll", query = "select r from RestaurantDTO r"),
		@NamedQuery(name = "fetchBycolumn", query = "select r.location from RestaurantDTO r where name=:nm"),
		@NamedQuery(name="fetchByLocAndRooms", query="select r.location,r.noOfRooms from RestaurantDTO r where name=:nm"),
		@NamedQuery(name="fetchCount",query="select count(*) from RestaurantDTO"),
		@NamedQuery(name="fetchSumOfRooms", query="select count(noOfRooms) from RestaurantDTO"),
		@NamedQuery(name="fetchByName", query="select count(*) from RestaurantDTO where name=:name1"),
		@NamedQuery(name="fetchBy", query="select max(rid),name from RestaurantDTO where noOfRooms=:noOffRooms group by noOfRooms")
	})

public class RestaurantDTO implements Serializable {
	@Id
	@GenericGenerator(name = "rid", strategy = "increment")
	@GeneratedValue(generator = "rid")
	@Column(name = "r_id")
	private int rid;

	@Column(name = "no_of_rooms")
	private int noOfRooms;

	@Column(name = "Restaurant_name")
	private String name;

	@Column(name = "location")
	private String location;

	public RestaurantDTO() {
		System.out.println("RestaurantDTO cretaed........");
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "RestaurantDTO [rid=" + rid + ", noOfRooms=" + noOfRooms + ", name=" + name + ", location=" + location
				+ "]";
	}

}
