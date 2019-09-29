package StringsAndArrays;

public class oneAway {
public static void main(String args[])
{
	String str1 = "geek";
	String str2 = "geeks";
	int strlen1 = str1.length();
	int strlen2 = str2.length();
	int i =0, j=0, flag =0;
	
	while(i <strlen1 && j < strlen2)
	{
		if(str1.charAt(i)==str2.charAt(j))
		{
			i++;j++;
		}
		else if(str1.charAt(++i) == str2.charAt(j))
		{
				flag++;
				i++;
				j++;
		}
		else if(str1.charAt(i) == str2.charAt(++j))
		{
				flag++;
				i++;
				j++;
		}
		else
		{
		flag++;
		}
	}
	if(strlen1-i>1 || strlen2-j>1)
	{
		flag++;
	}
	
	if(flag>1 || (Math.abs(strlen1 - strlen2) > 1))
	{
		System.out.println("Not one away");
		}
	else
	{
		System.out.println("One away");
	}
}
}

