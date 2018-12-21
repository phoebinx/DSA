//replace space in a string with %20. either regex or string builder.
//Using StringBuilder as it saves time coz everytime a new String or an array 
//is not created when a new element is added
package StringsAndArrays;

import java.util.Scanner;

public class Urlify {

	public String urlifyThis(String sentence)
	{
		String [] strArr = sentence.split(" ");
		StringBuilder outputSentence = new StringBuilder(strArr[0]);
		
		for(int i = 1;i<strArr.length;i++)
		{
			outputSentence.append("%20");
			outputSentence.append(strArr[i]);
		}
		return outputSentence.toString();
	}
	public static void main(String args[])
	{
		System.out.println("Enter the sentence to urlify: ");
		Scanner scan = new Scanner(System.in);
		String sentence = scan.nextLine();
		Urlify obj = new Urlify();
		if (!sentence.isEmpty())
		System.out.println("Sentece after URLification is: "+obj.urlifyThis(sentence));
		else
			System.out.println("You entered a blank string. Please Try again.");
	}
}
