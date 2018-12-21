package StringsAndArrays;

/*
 komal
 i = 0 
 omal+k
 
 i = 1
 mal+o+k
 
 i = 2
 al+m+ok
 
 i = 3
 l+a+mok
 
 i=4
 lamok
 */
public class InPlaceStringReverse {
public static void main(String args[])
{
	String str = "komal";
	for(int i = 0; i<str.length()-1;i++)
	{
		str = str.substring(1,str.length()-i)+str.substring(0,1)+str.substring(str.length()-i, str.length()); 
	}
	
	System.out.println(str);
}
}
