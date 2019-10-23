package DCT.LL;
//case1 -> both are same (null or end -> return 0)
//case two -> not same, return 1 or -1 using conditional if
//case three -> size is different
public class CompareLinkedList {

	Link head;
	static Link a, b;

	static class Link {
		char data;
		Link next;

		Link(char data) {
			this.data = data;
		}

	}

	int compare(Link l1, Link l2) {
		if (l1 == null && l2 == null)
			return 0;

		while (l1 != null && l2 != null && l1.data == l2.data) {
			l1 = l1.next;
			l2 = l2.next;
		}

		if (l1 != null && l2 != null)
			return (l1.data > l2.data ? 1 : -1);

		if (l1 != null && l2 == null)
			return 1;

		if (l1 == null && l2 != null)
			return -1;

		return 0;
	}

	public static void main(String args[]) {
		CompareLinkedList list = new CompareLinkedList();
		list.a = new Link('h');
		list.a.next = new Link('e');
		list.a.next.next = new Link('a');

		list.b = new Link('h');
		list.b.next = new Link('e');
		list.b.next.next = new Link('e');

		int value = list.compare(a, b);
		System.out.println(value);

	}

}
