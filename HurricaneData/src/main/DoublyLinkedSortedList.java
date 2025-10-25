package main;

public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface 
{

	//first item in list
	private Node start;
	//last item in list
	private Node end;
	//list size
	private int size;
	
	public DoublyLinkedSortedList()
	{
		System.out.println("DoublyLinkedList Constructed");
		this.start = null;
		this.end = null;
		this.size = 0;
	}
	
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

	@Override
	public DoublyLinkedSortedList remove(HurricaneData toRemove) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(HurricaneData newValue) {
		System.out.println("Made it to insert");
		if(start != null)
		{
		System.out.println("Current Start\n" + start.toString());
		System.out.println("Current End\n" + end.toString());
		}
		Node newData = new Node(newValue);
		if(start == null)
		{
			start = newData;
			end = newData;
			start.setNext(newData);
			end.setPrevious(newData);
			size++;
			System.out.println("insert first item\n" + newData.toString());
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
			System.out.println("insert larger 2nd item\n" + newData.toString());
		}
		else if(start.getACE() > newData.getACE() && size == 1)
		{
			start.setNext(newData);
			end = newData;
			end.setPrevious(start);
			size++;
			System.out.println("insert smaller 2nd item\n" + newData.toString());
		}
		else if(newData.getACE() > start.getACE())
		{
			Node current = start;
			newData.setNext(current);
			current.setPrevious(newData);
			start = newData;
		}
		else
		{
			System.out.println("insert additional item\n" + newData.toString());
			//Begins at first node
			Node current = start;
			//while the current node has a greater index
			//than the newData being added each node in the
			//list is iterated through until the node with a 
			//lesser ACE value is found
			boolean lastItem = false;
			if (newData.getACE() > end.getACE())
			{
				while(current.getACE() > newData.getACE())
				{
					System.out.println("while current.getACE() > newData.getACE()");
					current = current.getNext();
				}
				newData.setNext(current);
				newData.setPrevious(current.getPrevious());
				current.getPrevious().setNext(newData);
				current.setPrevious(newData);
			}
			
			//Once the Node with a lesser ACE value
			//than newData is found, newData is
			//inserted at between current and currents previous
			System.out.println("out of while trying to add additional item");
			if(newData.getACE() < current.getACE())
			{
				current.setNext(newData);
				newData.setPrevious(current);
				newData.setNext(null);
				end = newData;
			}
			
			/*
			if(current.getPrevious() != null)
			{
				newData.setNext(current);
				newData.setPrevious(current.getPrevious());
				current.getPrevious().setNext(newData);
				current.setPrevious(newData);
			}
			*/
			size++;
		}
		
	}//END of insert()

	@Override
	public String toString()
	{
		System.out.println("Linked List toString called");
		String allData = "";
		Node current = start;
		while (current.getNext() != end)
		{
			allData = allData + current.toString();
			current = current.getNext();
		}
		return allData;
	}
}
