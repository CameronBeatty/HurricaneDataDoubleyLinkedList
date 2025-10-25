package main;

public class Hurricane {

	//67 rows of data
	final int YEARS_OF_DATA = 67;
	//5 pieces of data per row
	final int ITEMS_PER_ROW = 5;
	//An array of HurricaneData objects, the array is sized
	//to the number of years which is also the number of rows
	//of data. Each HurricaneData instance will store one row/year
	//of data
	private HurricaneData[] hurricaneDataAr = new HurricaneData[YEARS_OF_DATA];
	private DoublyLinkedSortedList hurricaneLinkedList;
	//Variable that tracks the current row being read
	private int dataLine = 0;
	//Creates one instance of Hurricane Data for
	//each row of data and assigns it a position
	//in the array of HurricaneData objects
	public Hurricane()
	{
		hurricaneLinkedList = new DoublyLinkedSortedList();
		
		for(int i = 0; i < YEARS_OF_DATA; i++)
		{
			hurricaneDataAr[i] = new HurricaneData();
		}
	}
	
	//Using the hurricaneDataAr array, a specific
	//row of, or instance of, HurricaneData
	//data can be referred to and then assigned
	//the corresponding year.
	public void addYear(int year)
	{
		hurricaneDataAr[dataLine].setYear(year);
		//System.out.println("Year added: " + hurricaneDataAr[dataLine].getYear());//TEST
	}
	
	//Utilizing the loop in main tied to this, each individual
	//piece of data from a specific row is received and then relayed
	//to the specific row's HurricaneData array list us HurricaneData's
	//addData method
	public void addData(int dataPoint)
	{
		hurricaneDataAr[dataLine].addData(dataPoint);
		//System.out.println("Data Added :" + hurricaneDataAr[dataLine].getData());//TEST
	}
	
	//Using the hurricaneDataAr array, a specific
	//row of, or instance of, HurricaneData
	//data can be referred to. Doing this four
	//setters are called in HurricaneData which
	//assign each item in object's array list to
	//the correctly labeled private instance variable.
	public void labelData()
	{
		hurricaneDataAr[dataLine].setACE();
		hurricaneDataAr[dataLine].setTropicalStorms();
		hurricaneDataAr[dataLine].setOneToFiveHur();
		hurricaneDataAr[dataLine].setThreeToFiveHur();
	}
	//Add the item to the linked list
	public void addToLinkedList()
	{
		//TEST
		//System.out.println("addToLinkedList");
		hurricaneLinkedList.insert(hurricaneDataAr[dataLine]);
	}
	//A row has been read, increment dataLine
	//to read and assign the next row or instance of
	//HurricanData
	public void readNextLine()
	{
		dataLine++;
	}

	//toString overwritten to compile and format each year's data
	//as well as include the determined greatest ACE index and it's year.
	//The method utilizes another overwritten toString in the HurricaneData class
	//which sorts an individual row. Then this method compiles all the sorted rows
	@Override 
	public String toString()
	{
		//temp begins as the top row labels of the spreadsheet
		String temp = String.format("%-8s %-8s %-12s %-12s %-12s\n", "Year", "ACE", 
				"Tropic St-", "Cat 1-5 Hur", "Cat 3-5 Hur");
		temp = temp + hurricaneLinkedList.toString();
		//maxACE string stores what the greatest ACE index was
		//and what year it was in
		String maxACE = String.format("%-25s %-3d %-11s %-5d",
				"The highest ACE index is,", hurricaneLinkedList.getStart().getACE(),
				"in the year", hurricaneLinkedList.getStart().getYear());
		//The message about the highest ACE is added to the end of
		//the formatted string
		temp = temp + maxACE;
		return temp;
	}//END of public String toString()
	
}//END public class Hurricane
