package DCT.LL;
//maintain 2 pointers
//first, last
//also, Link will have previous and next

//methods
/*insertfirst, insertlast, insertafter, deletefirst, deletelast, deleteafter, displayFoward, displayBackward*/ 
public class DoublyLinkedList {
public class Link
{
	int data;
	Link next;
	Link previous;
	
	Link(int data){
		this.data = data;
	}
	
	public void displayLink()
	{
		System.out.print(this.data+" ");
	}
	
}

private Link first;
private Link last;

DoublyLinkedList()
{
	first = null;
	last = null;
}

public boolean isEmpty()
{
	return (first == null);	
}

public void insertFirst(int data)
{
	Link newLink = new Link(data);
	
	if(isEmpty())
		last = newLink;
	else
	first.previous = newLink;
	
	newLink.next = first;
	first = newLink;
}

public void insertLast(int data)
{
	Link newLink = new Link(data);
	
	if(isEmpty())
	first = newLink;
	else
		last.next = newLink;
	newLink.previous = last;
	last = newLink;
	}

public int deleteFirst()
{
	Link temp = first;
	if(first.next==null)
		last = null;
	else
	first.next.previous = null;
	first = first.next;
	return temp.data;
}

public int deleteLast()
{
	Link temp = last;
	if(last.previous ==null)
		first = null;
	else
	last.previous.next = null;
	
	last = last.previous;
	return temp.data;
}

public boolean insertAfter(int key, int data)
{
	Link newLink = new Link(data);
	Link current = first;
	while(current!=null && current.data != key)
		current = current.next;
	
	if(current == null)
		return false;
	else
	{
		if(current.next!=null)
		{
		current.next.previous = newLink;
		newLink.next = current.next;
		}
		else
			newLink.next = null;
		current.next = newLink;
		newLink.previous = current;
		return true;
	}
	}

public boolean DeleteKey(int key){
	Link current = first;
	while(current!= null && current.data !=key)
		current=current.next;
	if(current==null)
		return false;
	else
	{
		if(current.next==null)
			current.previous.next= null;
		else
		current.next.previous = current.previous;
		if(current.previous==null)
			current.next.previous = null;
		else
		current.previous.next = current.next;
		return true;
	}
	
}

public void displayForward()
{
	Link current = first;
	while(current!=null)
	{
		current.displayLink();
		current=current.next;
	}
	System.out.println("");
}

public void displayBackward()
{
	Link current = last;
	while(current!=null){
		current.displayLink();
		current=current.previous;
	}
	System.out.println("");
}

public static void main(String args[]){
	DoublyLinkedList list1 = new DoublyLinkedList();
	
	list1.insertFirst(20);
	list1.insertFirst(30);
	list1.insertFirst(40);
	
	list1.insertLast(5);
	list1.insertLast(55);
	list1.insertLast(555);
	
	list1.displayForward();
	list1.displayBackward();
	
	list1.deleteFirst();
	list1.deleteLast();
	list1.DeleteKey(20);
	
	list1.displayForward();
	
	list1.insertAfter(5, 11);
	list1.displayForward();
}
}

