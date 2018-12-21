package StringsAndArrays;

import java.util.Scanner;

public class IsStringUnique {
	public boolean checkUniqueness(String str)
	{
		String strUpper = str.toUpperCase();
		boolean chars[] = new boolean[25];
		for(int i = 0; i<strUpper.length(); i++)
		{
			if(chars[(int)strUpper.charAt(i)- 'A'])
				return false;
			else
				chars[(int)strUpper.charAt(i)-'A'] = true;
		}
		return true;
	}
public static void main(String args[])
{
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter String to test for uniqueness");
	String str = scan.nextLine();
	
	IsStringUnique obj = new IsStringUnique();
	if(obj.checkUniqueness(str))
		System.out.println("String "+str+" is unique and no characters in it repeats");
	else
		System.out.println("String "+str+" is not unique");
}
}
