package com.wipro.eb.service;
import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;
public class ConnectionService 
{
	public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException
	{
		try
		{
			int k=currentReading-previousReading;
			if(k<0||currentReading<0||previousReading<0)
				throw new InvalidReadingException("give correct Reading");
			if(!(type.equalsIgnoreCase("Domestic")||type.equalsIgnoreCase("Commercial")))
				throw new InvalidConnectionException("Invalid connection");
		}
		catch(InvalidReadingException ire)
        {
			return false;
        }
		catch(InvalidConnectionException ice)
		{
			return false;
		}
        return true;
	}
	public String generateBill(int currentReading, int previousReading, String type)
	{
		float ans=calculateBillAmt(currentReading,previousReading,type);
		if(ans==-1)
			return "Incorrect Reading";
		else if(ans==-2)
			return "Invalid ConnectionType";
		else
			return "Amount to be paid: "+ans;
	}
	public float calculateBillAmt(int currentReading, int previousReading, String type)
	{
		 try
		 {
	            boolean val = validate(currentReading, previousReading, type);
	            if(val==false)
	            	return -1;
	            if(type.equalsIgnoreCase("Domestic"))
	            {
	            	float[] slabs = {2.3f ,4.2f ,5.5f};
	            	Domestic d = new Domestic(currentReading,previousReading, slabs);
	                return d.computeBill();
	            }
	            else if(type.equalsIgnoreCase("Commercial"))
	            {	                   
	                    float[] slabs = {5.2f, 6.8f, 8.3f};
	                    Commercial c = new Commercial(currentReading,previousReading, slabs);      
	                    return c.computeBill();
	            }
	            else
	            	return -2;
	       } 
		 		catch(InvalidReadingException e)
		 		{
	                return -1;
	            }
		 		catch(InvalidConnectionException e)
		 		{
	                return -2;
	            }
	}
}