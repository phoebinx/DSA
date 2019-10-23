package DCT.LL;
//push->insertfirst
//pop->deletefirst
public class LinkStack {
	public static class Link
	{
		int data;
		Link next;
		
		Link(int data)
		{
			this.data = data;
		}
		
		void displayLink()
		{
			System.out.print(this.data+" ");
		}
	}
	
	class LinkedList
	{
		Link head;
		LinkedList()
		{
			head=null;
		}
		
		void displayList()
		{
			Link current = head;
			System.out.println();
			while(current!=null)
			{
				current.displayLink();
				current = current.next;
			}
		}
		
		Boolean isEmpty()
		{
			return (head==null);
		}
		
		void insertFirst(int data)
		{
			Link newLink = new Link(data);
			if(head != null)
				newLink.next = head;
			head = newLink;
		}
		
		int deleteFirst()
		{
			while(head!=null)
			{
			Link temp = head;
			head = head.next;
			return temp.data;
			}
			return -1;
		}
	
		
	}
	
	//LinkStack
	private LinkedList theList;
	
	public LinkStack()
	{
		theList = new LinkedList();
	}
	
	public void push(int data)
	{
		theList.insertFirst(data);
	}
	
	public int pop()
	{
		int data = theList.deleteFirst();
		return data;
	}
	
	public boolean isEmpty()
	{
		return theList.isEmpty();
	}
	
	public void displayStack()
	{
		theList.displayList();
	}
	
	public static void main(String args[])
	{
	LinkStack theStack = new LinkStack();
	theStack.push(10);
	theStack.push(20);
	theStack.push(30);
	
	theStack.displayStack();
	
	theStack.push(40);
	theStack.push(50);
	
	theStack.displayStack();
	
	theStack.pop();
	theStack.pop();
	
	theStack.displayStack();
	
	theStack.pop();
	theStack.pop();
	theStack.pop();
	
	theStack.displayStack();
	}
}
