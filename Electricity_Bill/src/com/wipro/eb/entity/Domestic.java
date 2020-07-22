package com.wipro.eb.entity;
public class Domestic extends Connection
{
	public Domestic(int currentReading, int previousReading,float slabs[])
	{
		super(currentReading,previousReading,slabs);
	}
	public float computeBill()
	{
		float units=0.0f;
		units=currentReading-previousReading;
		double bill=0.0f;
		if(units<51)
			bill=units*2.3;
		if(units>50&&units<101)
			bill=(units-50)*4.2+115;
		else
			bill=(units-100)*5.5+325;
		return (float)bill;
	}
}