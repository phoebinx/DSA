package LSQ;

public class RemoveCycleLL {
	public Node head;
	class Node {
		 int val;
		 Node next;
		 Node(int val) {
			 this.val=val;
			 this.next=null;
		 }
	 }
	
	
	public void detectAndRemoveCycle(Node head) {
		if (head==null || head.next==null) {
			return;
		}
		Node slow = head;
		Node fast = head;
		slow = slow.next;
		fast= fast.next.next;
		
		while(fast!=null && fast.next!=null) {
			if (slow==fast) 
				break;
			slow = slow.next;
			fast=fast.next.next;
		}
		//cycle found
		if(slow == fast) {
			slow = head;
			//find node before first node 
			while(slow.next != fast.next) {
				slow = slow.next;
				fast= fast.next;
			}
			fast.next=null;
		}
	}
	
	public void printList() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp=temp.next;
		}
	}
	
	public static void main(String args[]) {
		RemoveCycleLL list = new RemoveCycleLL();
		list.head=list.new Node(50); 
        list.head.next = list.new Node(20); 
        list.head.next.next = list.new Node(15); 
        list.head.next.next.next = list.new Node(4); 
        list.head.next.next.next.next = list.new Node(10); 
  
        // Creating a loop for testing 
        list.head.next.next.next.next.next = list.head.next.next;
        list.detectAndRemoveCycle(list.head);
        list.printList();
	}
	
}

//Floyd algo
//https://www.youtube.com/watch?v=X_kwcctaQ4M&t=2s

//To find the first node of the loop in a linked list, you do detection of loop with slow and fast
//pointer , then you put slow to head and move both fast and slow by one until they meet; they
//will meet at the beginning of loop

