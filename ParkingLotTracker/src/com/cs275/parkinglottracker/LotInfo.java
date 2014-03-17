package com.cs275.parkinglottracker;

public class LotInfo 
{
	private String name, hours, price, location;
	
	public LotInfo(String name, String hours, String price, String location)
	{
		this.name = name;
		this.hours = hours;
		this.price = price;
		this.location = location;
	}
	
	public LotInfo(String name, String hours, String price)
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
}
