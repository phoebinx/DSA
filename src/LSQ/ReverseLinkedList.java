package LSQ;
 //change next to prev, prev to current and current to next
 //four pointers, head, current, next, previous

import java.lang.reflect.Array;
import java.util.Arrays;

/*deal with previos and then next
next = current.next
current.next = previous
previous = current
current = next*/
 
public class ReverseLinkedList {

	static class Link
	{
	int data;
	Link next;
	Link(int data)
	{
		this.data= data;
	}
	}
	
	static Link head;
	
	Link reverseList(Link link)
	{
		Link previous = null, current=link, next=null;
		while(current!=null)
		{
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		link = previous;
		return link;
		
	}
	
	void printList(Link link)
	{
		while(link!=null)
		{
			System.out.print(link.data+" ");
			link=link.next;
		}
	}
	
	public static void main(String args[])
	{
		ReverseLinkedList list = new ReverseLinkedList();
		list.head = new Link(85);
		list.head.next = new Link(15);
		list.head.next.next = new Link(4);
		list.head.next.next.next = new Link(20);
		
		System.out.println("Original list is ");
		list.printList(list.head);
		list.head = list.reverseList(list.head);
		System.out.println("Reversed Linked List is ");
		list.printList(head);
		
		
	}
}
