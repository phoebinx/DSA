//to check is a string's permutation is a pallindrome.
//the string can have spaces too.
//hashtable and if length of string is even - all keys must
//have even number of values 
//and if length of string is odd only one key can have an odd value
//eg: tact coa = true as taco cat is pallindrome
package StringsAndArrays;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class PermutationIsPallindrome {

	public boolean checkIfPermutationPallindrome(String str)
	{
		Hashtable<Character, Integer> h1 = new Hashtable();
		for(int i = 0; i<str.length(); i++)
		{
			char c = str.charAt(i);
			if(h1.containsKey(c))
			{
			int val = (int)	h1.get(c) +1;
			h1.put(c,val);
			}
			else
				h1.put(c, 1);
			}
		
		//flag should be incremented if odd value found
		//if length is even, flag must be 0 else 1
		Set<Character> keys = h1.keySet();
		int flag =0;
		for(Character k : keys)
		{
			if(h1.get(k)%2 != 0)
				flag++;
		}
		
		if(str.length()%2==0)
			return flag==0;
		else 
			return flag==1;
	}
	public static void main(String args[])
	{
		System.out.println("Enter string to check for permutation's pallindrom: ");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String str = input.replace(" ","");//remove spaces from string
		System.out.println(str);
		PermutationIsPallindrome obj = new PermutationIsPallindrome();
		if(obj.checkIfPermutationPallindrome(str))
			System.out.println("The string "+str+"'s permutation is a pallindrome");
		else
			System.out.println("The string "+str+"'s permutation is not a pallindrome");
	}
}
