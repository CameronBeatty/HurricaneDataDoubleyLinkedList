package main;
//Name: Cameron Beatty
//Date: 10/24/2025
//Class: CSCI2260 (U01)
//Purpose: To create a program that takes a organized
//file of data as input. Then using a Doubly Linked List
//sort that data based off ACE index vale.
//Then this information is formatted and written out to
//a text file.
/*Sources: \CSCI 2260 Java 2\2251_all_content\2251_all_content
			\module10_objects_and_fileio\070_fileio_unemployment\object_oriented
*/
import java.util.Scanner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) 
	{
		//Create a new instance of Hurricane
		//this is an object this has an array
		//that will format and store all the years
		//of data.
		Hurricane hurricane = new Hurricane();
		
		//Read in the data file
		try
		{
			File dataFile = new File("ace.csv");
			Scanner fileScanner = new Scanner(dataFile);
			//Skip the first line in the file
			fileScanner.nextLine();
			//Keep reading while there is more to read
			while(fileScanner.hasNext())
			{
				//Temporary string to hold an entire row of data
				String currentLine = fileScanner.nextLine();
				//currentLine is split into an array to
				//separate each piece of data
				String[] currentData = currentLine.split(",");
				//take the first item in currentData which
				//is the year, and make it an int
				int year = Integer.parseInt(currentData[0]);
				//System.out.println(year);//TEST
				//add the year calling Hurricane class method
				hurricane.addYear(year);
				//Cycle through and add each piece of data
				//in the currentData array to the specific
				//instance/year of HurricaneData using
				//the hurricane.addData method
				for(int i = 1; i < currentData.length; i++)
				{
					//System.out.println(currentData[i]);//TEST
					hurricane.addData(Integer.parseInt(currentData[i]));
				}
				//Assign each element in each
				//HurricanData instances array list
				//to the specific private int variable to
				//label each value,
				hurricane.labelData();
				//add data to Doubly Linked List
				hurricane.addToLinkedList();
				//Reads next line of data
				hurricane.readNextLine();
			}//while(fileScanner.hasNext()
			fileScanner.close();
			//FILE OUTPUT
			try
			{
				FileWriter fw = new FileWriter("output.txt");
				//Call the hurricane.toString method to
				//output the formatted data
				fw.write(hurricane.toString());
				//Print same output on command prompt
				System.out.print(hurricane.toString());
				fw.close();
			}//END try FileWriter
			//CANNOT WRITE FILE
			catch(IOException e)
			{
				System.out.println("ERROR:");
				System.exit(1);
			}
		}//END of try File dataFile = new File("ace.csv");
		//CANNOT FIND OR READ FILE
		catch(IOException e)
		{
			System.out.println("ERROR: File invalid or not found");
		}
		
	}//public static void main(String[] args) 

}//public class Main
