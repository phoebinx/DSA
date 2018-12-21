package StringsAndArrays;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;



//cat and act
//hashtaBLE of size 26 reopresenting 26 characters, iterate 
//over first string and increment value for character keys 
//and then iterate over second and decerement. in the end 
//all values of hash TALBE must be 0.
//O(n)

public class checkStringPermutation {
	
	public boolean isPermutation(String str1, String str2)
	{
		if(str1.length() != str2.length())
			return false;
		Hashtable<Character, Integer> h1 = new Hashtable<>();
		for(int i = 0; i<str1.length();i++)
		{
			char c = str1.charAt(i);
			if(h1.containsKey(c))
			{
				int val = (int) h1.get(c)+1;
				h1.put(c, val);
			}
			else
				h1.put(c, 1);
		}
	
		for(int i = 0; i<str2.length(); i++)
		{
			char c = str2.charAt(i);
			if(h1.containsKey(c))
			{
				int val = (int) h1.get(c) -1;
				h1.put(c, val);
			}
			else
				return false;
		}
		
		Set<Character> keys = h1.keySet();
		for(Character k : keys )
		{
			if((int) h1.get(k) !=0)
				return false;
		}
	return true; 
	}
		
		
	

	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter string one: ");
		String str1 = scan.nextLine();
		System.out.println("Enter string two: ");
		String str2 = scan.nextLine();
		checkStringPermutation obj = new checkStringPermutation();
		if(obj.isPermutation(str1,str2))
			System.out.println("Strings "+str1+" and "+str2+" are permutation of each other");
		else
			System.out.println("Strings aren't each other's permutations");
	}
}
