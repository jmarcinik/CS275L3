package com.cs275.parkinglottracker;

public class LotInfo 
{
	private String name, hours, price, location;
	boolean update;
	
	public LotInfo(String name, String hours, String price, String location, boolean update)
	{
		this.name = name;
		this.hours = hours;
		this.price = price;
		this.location = location;
	}
	
	public LotInfo(String name, String hours, String price, boolean update)
	{
		this.name = name;
		this.hours = hours;
		this.price = price;
	}
	
	public String getName()
	{
		return name;		
	}
	
	public String getHours()
	{
		return hours;
	}
	
	public String getPrice()
	{
		return price;
	}
	
	public String getLocation()
	{
		return "";
	}
	
	public boolean isUpdate()
	{
		return update;
	}
}
