package com.wipro.eb.entity;
public class Commercial extends Connection
{
	public Commercial(int currentReading, int previousReading,float slabs[])
	{
		super(currentReading,previousReading,slabs);
	}
	public float computeBill()
	{
		float units=0.0f;
		units=currentReading-previousReading;
		double bill=0.0f;
		if(units<51)
			bill=units*5.2;
		else if(units>50&&units<101)
			bill=(units-50)*6.8+260;
		else
			bill=(units-100)*8.3+600;
		if(bill>=10000)
			bill+=bill*0.09;
		else if(bill>=5000)
			bill+=bill*0.06;
		else
			bill+=bill*0.02;
		return (float)bill;	
	}

}