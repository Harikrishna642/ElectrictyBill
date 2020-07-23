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
			bill=units*slabs[0];
		else if(units>50&&units<101)
			bill=(units-50)*slabs[1]+50*slabs[0];
		else
			bill=(units-100)*slabs[2]+50*slabs[1]+50*slabs[0];
		if(bill>=10000)
			bill+=bill*0.09;
		else if(bill>=5000)
			bill+=bill*0.06;
		else
			bill+=bill*0.02;
		return (float)bill;

		

	}

}