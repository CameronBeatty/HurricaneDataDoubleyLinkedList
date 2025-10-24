package main;

public class Node 
{
	private HurricaneData dataLine = null;
	private Node next = null;
	private Node previous = null;
	
	//Constructor
	public Node(HurricaneData dataLine)
	{
		this.dataLine = dataLine;
		next = null;
		previous = null;
		System.out.println("a Node was created");
	}
	
	public int getACE()
	{
		if(this.dataLine == null)
		{
			return 0;
		}
		return this.dataLine.getACE();
	}
	
	public HurricaneData getData()
	{
		return this.dataLine;
	}
	
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	public Node getNext()
	{
		return this.next;
	}
	
	public void setPrevious(Node previous)
	{
		this.previous = previous;
	}
	
	public Node getPrevious()
	{
		return this.previous;
	}
	
	@Override
	
	public String toString()
	{
		return this.dataLine.toString();
	}
}
