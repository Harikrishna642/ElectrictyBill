package com.wipro.eb.main;
import com.wipro.eb.service.ConnectionService;
public class EBMain 
{
	public static void main(String a[])
	{
		System.out.println(new ConnectionService().generateBill(90,100,"domestic"));
		System.out.println(new ConnectionService().generateBill(150,100,"domestic"));
		System.out.println(new ConnectionService().generateBill(190,-6,"domestic"));
		System.out.println(new ConnectionService().generateBill(90,130,"commercial"));
		System.out.println(new ConnectionService().generateBill(150,100,"commercial"));
	}
}