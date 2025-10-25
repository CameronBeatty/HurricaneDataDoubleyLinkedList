package main;
//A self sorted by ACE value, Doubly linked list
//to store and sort a file of a set of years Hurricane Data.
public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface 
{

	//first item in list
	private Node start;
	//last item in list
	private Node end;
	//list size
	private int size;
	//Constructor
	public DoublyLinkedSortedList()
	{
		this.start = null;
		this.end = null;
		this.size = 0;
	}

	@Override
	//inserts a new HurricaneData item into the list,
	//this method will also insert the item specifically
	//into a sorted location based of the objects ACE value
	public void insert(HurricaneData newValue) {
		//Item being added set as newData
		Node newData = new Node(newValue);
		//If the list is empty, the newData
		//item becomes the start and end of the list
		if(start == null)
		{
			start = newData;
			end = newData;
			start.setNext(newData);
			end.setPrevious(newData);
			size++;
			//System.out.println("insert first item\n" + newData.toString());
		}
		//New ACE value is largest yet, with only 1 other item
		else if(start.getACE() < newData.getACE() && size == 1)
		{
			//starts next is start, start shifted
			//to left one
			start.setNext(start);
			//the current start has become the end
			end = start;
			//newData is the new start and ends previous
			end.setPrevious(newData);
			start = newData;
			size++;
			//TEST
			//System.out.println("insert larger 2nd item\n" + newData.toString());
		}
		//If the new second item is smaller then the first
		else if(start.getACE() > newData.getACE() && size == 1)
		{
			//Starts next is the new item and
			//becomes the end, and its previous is start
			start.setNext(newData);
			end = newData;
			end.setPrevious(start);
			size++;
			//TEST
			//System.out.println("insert smaller 2nd item\n" + newData.toString());
		}
		//if the newData's ACE is greater than the start
		//and there are more then two items in the list
		else if(newData.getACE() > start.getACE())
		{
			Node current = start;
			//newData becomes new start, the old
			//start becomes newData next,
			//and becomes the old starts previous
			newData.setNext(current);
			current.setPrevious(newData);
			start = newData;
			size++;
		}
		//If the new item goes somewhere in the middle
		//of the list
		else
		{
			//TEST
			//System.out.println("insert additional item\n" + newData.toString());
			
			//Begins at first node
			Node current = start;
			//while the current node has a greater index
			//than the newData being added each node in the
			//list is iterated through until the node with a 
			//lesser ACE value is found
			boolean lastItem = false;
			if (newData.getACE() > end.getACE())
			{
				//Until current's ACE is less than newData's
				//ACE keep going through list
				while(current.getACE() > newData.getACE())
				{
					//TEST
					//System.out.println("while current.getACE() > newData.getACE()");
					current = current.getNext();
				}
				//Once current's ACE is less that newData's
				//ACE, new data is inserted between current
				//and currents previous
				newData.setNext(current);
				newData.setPrevious(current.getPrevious());
				current.getPrevious().setNext(newData);
				current.setPrevious(newData);
				size++;
			}
			//TEST
			//System.out.println("out of while trying to add additional item");
			
			//If newData has the smallest ACE yet
			if(newData.getACE() < current.getACE())
			{
				//newData is inserted after
				//current and becomes the new
				//end
				current.setNext(newData);
				newData.setPrevious(current);
				newData.setNext(null);
				end = newData;
				size++;
			}//END if item has smallest ACE

		}//END if item goes in middle
		
	}//END of insert()

	//Returns the start of the list
	public Node getStart()
	{
		return this.start;
	}
	
	@Override
	//Puts every node from the list
	//onto the allData String which results
	//in a sorted formatted list of all the
	//years of hurricane data
	public String toString()
	{
		//System.out.println("Linked List toString called");
		String allData = "";
		Node current = start;
		//Iterates through list, creating
		//a string for each year until the
		//end is reached
		while (current.getNext() != end)
		{
			allData = allData + current.toString();
			current = current.getNext();
		}
		//end is added on as well
		allData = allData + end.toString();
		//return the whole table of data
		return allData;
	}
	
	//I Implemented all these methods in
	//the Node class, because then I could
	//refer to and return nodes. I don't
	//understand how you can return
	//the whole DoublyLinkedList to
	//refer to a single node like first or last.
	//Also for getValue() how would I know what
	//value is supposed to be gotten if there is
	//no argument passed?
	//=================================
	@Override
	public HurricaneData getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasNext() {
		// TODO
		return false;
	}

	@Override
	public void setNext(DoublyLinkedSortedList next) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DoublyLinkedSortedList getNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPrevious(DoublyLinkedSortedList previous) {
		// TODO Auto-generated method stub
	}

	@Override
	public DoublyLinkedSortedList getPrevious() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DoublyLinkedSortedList getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DoublyLinkedSortedList getLast() {
		// TODO Auto-generated method stub
		return null;
	}
	//===========================================

	//I'm also confused on this one, shouldn't
	//this be something like
	/*
	 *public void remove(HurricaneData toRemove)
	 *	{	
	 *		Node current = start;
	 *		while(current.getNext().getData() != toRemove)
	 *			{
	 *				current = current.getNext();
	 *			}
	 *		current = current.getNext();
	 *		current.getNext().setPrevious(current.getPrevious())
	 *		current.getPrevious().setNext(current.getNext())
	 *	}
	*/
	@Override
	public DoublyLinkedSortedList remove(HurricaneData toRemove) {
		// TODO Auto-generated method stub
		return null;
	}

}
