package LinkedLists;

public class Test {
 public static void main(String args[]) {
	 BasicLinkedList l2 = new BasicLinkedList();
	 l2.head = new BasicLinkedList.Node(1);
	 System.out.println(BasicLinkedList.msg);
	 BasicLinkedList l3 = new BasicLinkedList();
	 l2.msg = "bye";
	 System.out.println(BasicLinkedList.msg);
	 System.out.println(l2.msg);
	 System.out.println(l3.msg);
	 l3.msg = "tata";
	 System.out.println(BasicLinkedList.msg);
	 System.out.println(l2.msg);
	 System.out.println(l3.msg);
 }
}
