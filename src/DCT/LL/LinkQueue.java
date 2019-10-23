package DCT.LL;

public class LinkQueue {
public class Link
{
	int data;
	Link next;
	
	Link(int data)
	{
		this.data=data;
	}
	
	void displayLink()
	{
		System.out.print(this.data+" ");
	}
}

public class LinkedList
{
Link head;

LinkedList()
{
	head = null;
}

public void displayList()
{
	Link current = head;
	System.out.println();
	while(current != null)
	{
		current.displayLink();
		current=current.next;
	}
}

public boolean isEmpty()
{
return (head==null);	
}

public void insertLast(int data)
{
	Link newLink = new Link(data);
	Link current = head;
	if(head == null)
		head = newLink;
	else
	{
	while(current.next != null)
	{
		current = current.next;
	}
	current.next = newLink;
}
	}


public int deleteFirst()
{
	Link temp = head;
	head = head.next;
	return temp.data;
}

}

private LinkedList theList;
public LinkQueue()
{
	theList = new LinkedList();
}

public boolean isEmpty()
{
	return theList.isEmpty();
}

public void insert(int data)
{
	theList.insertLast(data);
}

public int remove()
{
	return theList.deleteFirst();
}

public void displayQueue()
{
	theList.displayList();
}

public static void main(String args[])
{
	LinkQueue theQueue = new LinkQueue();
	theQueue.insert(10);
	theQueue.insert(20);
	theQueue.insert(30);
	theQueue.displayQueue();
	theQueue.remove();
	theQueue.displayQueue();
	theQueue.insert(555);
	theQueue.displayQueue();
	theQueue.remove();
	theQueue.remove();
	theQueue.displayQueue();
}
}
