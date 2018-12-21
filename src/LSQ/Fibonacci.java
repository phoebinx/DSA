package LSQ;
import java.util.Scanner;

//1 1 2 3 5 8 13
// Fn = F(n-1) + F(n-2)
//f(0)= 0, f(1) = 1

 //Using power of the matrix {{1,1},{1,0}}


public class Fibonacci {
	
	public int fib(int n)
	{
		int F[][] = {{1,1},{1,0}};
		if(n==0)
		return 0;
		
		this.power(F, n-1);
		return F[0][0];
	}
	
	public void power(int F[][], int n)
	{
		int i;
		int M[][] = {{1,1},{1,0}};
	//multiply matrix to M n-1 times
		for (i =2; i<=n; i++)
		{
			this.multiply(F, M);
		}
	}
	
	public void multiply(int F[][], int M[][])
	{
		int x = F[0][0]*M[0][0] + F[0][1]*M[1][0];
		int y = F[0][0]*M[0][1] + F[0][1]*M[1][1];
		int z = F[1][0]*M[0][0] + F[1][1]*M[1][0];
		int w = F[1][0]*M[0][1] + F[1][1]*M[1][1];
		
		F[0][0] = x;
		F[0][1] = y;
		F[1][0] = z;
		F[1][1] = w;
	}
	

	public static void main(String args[])
	{
		System.out.println("which fibonacci number you want");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Fibonacci obj = new Fibonacci();
		int fibonacci = obj.fib(n);
		System.out.println("The "+n+"th fibonacci number is "+fibonacci);
				
	}

}
