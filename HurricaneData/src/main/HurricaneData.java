package main;

import java.util.ArrayList;

public class HurricaneData {
	
	//ArrayList stores one row of data, except the year
	private ArrayList<Integer> hurricaneData;
	//Labels and stores each piece of
	//data on one row
	private int year;
	private int ACEindex;
	private int tropicalStorms;
	private int oneToFiveHurricanes;
	private int threeToFiveHurricanes;
	
	//Constructor
	//Each row of data has an ArrayList
	//i.e a row to store data
	public HurricaneData() 
	{
		hurricaneData = new ArrayList<Integer>();
	}
	//Receive the year read in an assign it
	//to this instance/row of HurricaneData
	public void setYear(int year)
	{
		this.year = year;
	}
	//Return the year if needed
	public int getYear()
	{
		return this.year;
	}
	//Receive the data point read in
	//and add it to the row (ArrayList)
	public void addData(int dataPoint)
	{
		hurricaneData.add(dataPoint);
	}
	//return the whole row (ArrayList) of data
	public String getData()
	{
		return hurricaneData.toString();
	}
	//Assign the first item in the row (ArrayList index 0)
	//as the ACEindex
	public void setACE()
	{
		this.ACEindex = hurricaneData.get(0);
	}
	//Return ACEindex
	public int getACE()
	{
		return this.ACEindex;
	}
	//Assign second item in row (ArrayList index 1)
	//to the number of Tropical Storms
	public void setTropicalStorms()
	{
		this.tropicalStorms = hurricaneData.get(1);
	}
	//Assign third item in row (ArrayList index 2)
	//to the number of category 1-5 hurricanes
	public void setOneToFiveHur()
	{
		this.oneToFiveHurricanes = hurricaneData.get(2);
	}
	//Assign fourth item in row (ArrayList index 3)
	//to the number of category 3-5 hurricanes
	public void setThreeToFiveHur()
	{
		this.threeToFiveHurricanes = hurricaneData.get(3);
	}
	
	//The overwritten toString formats all 5 pieces of data in
	//a row similar to how they're presented in the original file.
	//This method is called in Hurricane to add every years formatted
	//row to one string and output it.
	@Override
	public String toString()
	{
		System.out.println("HurricaneData toString called");
		return String.format("%-8d %-8d %-12d %-12d %-12d\n", year, ACEindex,
				tropicalStorms, oneToFiveHurricanes, threeToFiveHurricanes);
	}
	
}//END public class Hurricane
