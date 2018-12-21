package DSA;
/*Write a HashTable class that stores strings
in a hash table, where keys are calculated
using the first two letters of the string.*/

public class MyHashTable {
	
	MyHashTable() {
		
	}
	
	private void store(String value) {
		
	}
	
	private int lookUp(String value) {
		return -1;
	}
	
	private int calcHashValue(String value) {
		if (!value.isEmpty()) {
			if (value.length() >= 2) {
				return ((int)value.charAt(0))*100 +
						(int)value.charAt(1);
			} else {
				return ((int)value.charAt(0))*100;
			}
		}
		return -1;
	}

	
	public static void main(String args[]) {
		MyHashTable ht = new MyHashTable();
		System.out.println(String.valueOf(ht.calcHashValue("UDACITY")));
		//System.out.println(String.valueOf(ht.lookUp("UDACITY")));
		
		//ht.store("UDACITY");
		//System.out.println(String.valueOf(ht.lookUp("UDACITY")));
	}
}
