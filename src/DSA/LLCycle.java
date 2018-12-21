package DSA;

import java.util.Hashtable;

public class LLCycle {
	Node head;
	static class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
			this.next=null;
		}
	}
	
	public void hashAndRemove(Node current) {
		Hashtable<Node, Integer> ht = new Hashtable<>();
		Node last = null;
		while (current != null) {
			if (ht.get(current) == null) {
				ht.put(current,1);
				last = current;
				current = current.next;
			} else {
				last.next = null;
				break;
			}
		}
	}
  
	public void printLL(Node current) {
		while(current!=null) {
			System.out.print(current.data+" ");
			current = current.next;
		}
	}
	public static void main(String args[]) {
		LLCycle ll = new LLCycle();
		ll.head = new Node(50);
		ll.head.next = new Node(20);
		ll.head.next.next = new Node(15);
		ll.head.next.next.next = new Node(4);		
		ll.head.next.next.next.next = new Node(10);
		ll.head.next.next.next.next.next = ll.head.next.next;
		ll.hashAndRemove(ll.head);
		ll.printLL(ll.head);
	}
}