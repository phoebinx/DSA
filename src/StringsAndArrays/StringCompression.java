package StringsAndArrays;

public class StringCompression {
public static void main(String args[])
{
	String str = "aabcccccaaa";
	StringBuilder str1 = new StringBuilder() ;
	int i = 0;
	while(i<(str.length())-1)
	{
		int j = 1;
		while(str.charAt(i)==str.charAt(++i))	
		{
			j++;
			if(i==str.length()-1)
			{
				break;
			}
		}
		str1.append(str.charAt(--i));
		str1.append(Integer.toString(j));
		i++;
	}
	System.out.println(str1);
}
}
