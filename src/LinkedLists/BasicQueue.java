package LinkedLists;

//front==rear, queue is empty!
//https://www.geeksforgeeks.org/queue-set-2-linked-list-implementation/


public class BasicQueue {
	Node front, rear;
	
	public BasicQueue() {
		front = rear = null;
	}
	
	static class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	void enqueue(Node newNode) {
		//increase rear (add to rear)
	}
	
	Node dequeue() {
		//increase front (remove from front)
		return null;
	}
	
	Node peek() {
		return null;
	}
	
	private void printQueue() {
		
	}
	
	public static void main(String args[]) {
		
	}
	
}
