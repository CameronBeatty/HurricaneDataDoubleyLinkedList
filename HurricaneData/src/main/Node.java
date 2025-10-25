package main;
//Each Node stores a specific
//HurricaneData object i.e one year
//and the corresponding hurricane data 
//for that year
public class Node 
{
	private HurricaneData dataLine;
	private Node next;
	private Node previous;
	
	//Constructor
	public Node(HurricaneData dataLine)
	{
		this.dataLine = dataLine;
		this.next = null;
		this.previous = null;
		//System.out.println("a Node was created");
	}
	//The Node retrieves it's
	//dataLine's ACE value calling
	//HurricaneData.getACE()
	public int getACE()
	{
		return this.dataLine.getACE();
	}
	//The Node retrieves it's
	//dataLine's year calling
	//HurricaneData.getYear()
	public int getYear()
	{
		return this.dataLine.getYear();
	}
	//returns the Node's
	//HurricanData object
	public HurricaneData getData()
	{
		return this.dataLine;
	}
	//Sets this nodes reference to the next item
	public void setNext(Node next)
	{
		this.next = next;
	}
	//returns this nodes reference to its next item
	//i.e returns the node next to this node
	public Node getNext()
	{
		return this.next;
	}
	//sets this nodes reference to its previous item
	public void setPrevious(Node previous)
	{
		this.previous = previous;
	}
	//returns this nodes reference to its previous item
	//i.e returns the node before this node
	public Node getPrevious()
	{
		return this.previous;
	}
	
	@Override
	//Puts this nodes HurricaneData instance's
	//data onto a formatted line by calling
	//HurricaneDataObject.toString()
	public String toString()
	{
		return this.dataLine.toString();
	}
}
