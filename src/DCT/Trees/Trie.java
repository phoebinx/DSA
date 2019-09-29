package DCT.Trees;

import java.util.HashMap;

public class Trie {
	
	public class TrieNode {
		HashMap<Character, TrieNode> children;
		boolean isWordNode;
		TrieNode() {
			children = new HashMap<>();
			isWordNode = false;
		}
	}
	TrieNode root = new TrieNode();
	
	
	public static void main(String args[]) {
		
		Trie trie = new Trie();
		
		
		trie.insert("apple"); 
		//System.out.println("Contains apple "+trie.search("apple"));  
		//System.out.println("Contains app "+trie.search("app"));
		System.out.println("Contains .pple "+trie.search(".pple"));
		//System.out.println("Starts with app: "+trie.startsWith("app")); 
		//trie.insert("app");   
		//System.out.println("Contains app "+trie.search("app"));
	}
	
	public boolean startsWith(String str) {
		TrieNode temp = root;
		for (int i=0;i<str.length();i++) {
			if (temp.children.containsKey(str.charAt(i))) {
				temp = temp.children.get(str.charAt(i));
			} else {
				return false;
			}
		}
	
		return true;
	}
	
	public void insert(String str) {
		TrieNode temp = root;
		TrieNode child;
		for (int i = 0; i<str.length();i++) {
			if (temp.children.containsKey(str.charAt(i))) {
				temp = temp.children.get(str.charAt(i));
			} else {
				child = new TrieNode();
				temp.children.put(str.charAt(i), child);
				temp = child;
			}
		}
		temp.isWordNode = true;
	}
	
	
	public boolean search(String str) {
		TrieNode temp = root;
		for (int i = 0; i< str.length(); i++) {
			if (str.charAt(i)=='.' && !temp.children.isEmpty()) {
				temp = (TrieNode) temp.children.values().toArray()[0];
			} else if (temp.children.containsKey(str.charAt(i))) {
				temp = temp.children.get(str.charAt(i));
			} else {
				return false;
			}
		}
		return temp.isWordNode;
	}

}
