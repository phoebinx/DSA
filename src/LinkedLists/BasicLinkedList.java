package LinkedLists;

public class BasicLinkedList {
	Node head;
	static String msg = "hi";
	
	static class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	private void append(Node newNode) {
		Node current = head;
		if (current != null) {
				while(current.next != null)  
					current = current.next;
				current.next = newNode;
		} else {
			head = newNode;
		}
				
	}
	
	private Node getPosition(int position) {
		/*Get an element from a particular position.
        Assume the first position is "1".
        Return "None" if position is not in the list.*/
		if (position<1) {
			return null;
		}
		Node current = head;
		while (current != null && position>1) {
			current = current.next;
			position--;
		}
		if (current != null) 
			return current;
		else
			return null;
	}
	
	private void insert(Node newNode, int position) {
		/*Insert a new node at the given position.
        Assume the first position is "1".
        Inserting at position 3 means between
        the 2nd and 3rd elements*/
		if (head == null) {
			head = newNode;
			return;
		}
		
		if (position == 1) {
			newNode.next = head;
			head = newNode;
		} else {
			position = position-1;
		}
		
		Node current = head;
		Node temp;
		while (current != null && position>1) {
			current = current.next;
			position--;
		}
		if (current != null) {
			temp = current.next;
			current.next = newNode;
			newNode.next = temp;
		}
		else {
			return;
		}
	}
	
	private void delete(int value) {
		if (head == null) {
			return;
		} else if (head.data == value) {
			head = head.next;
		}
		Node current = head;
		Node prev = head;
		while(current != null && current.data != value) {
			prev = current;
			current = current.next;
		}
		if (current != null) {
			prev.next = current.next;
		}
		return;
		
	}
	
	private void insertFirst(Node newNode) {
		if (head == null) {
			head = newNode;
			return;
		} 
		newNode.next = head;
		head = newNode;
	}
	
	private void deleteFirst() {
		if (head == null) {
			return;
		}
		head = head.next;
	}
	
	private void printList() {
		Node current = head;
		while (current!=null) {
			System.out.print(current.data+">>");
			current = current.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		BasicLinkedList l1 = new BasicLinkedList();
		l1.head = new Node(4);
		l1.append(new Node(6));
		l1.append(new Node(20));
		l1.append(new Node(1));
		l1.printList();
		l1.insert(new Node(17), 5);
		l1.printList();
		try {
			System.out.println(l1.getPosition(0).data);
		} catch(Exception e) {
			
		}
		l1.delete(4);
		l1.printList();
		l1.insertFirst(new Node(10));
		l1.printList();
		l1.deleteFirst();
		l1.printList();
	}
}
