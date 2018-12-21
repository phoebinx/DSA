package StringsAndArrays;

public class PrintNPrimeNos {
	public static void main(String args[]) {
		int n = 50;
		boolean arr[] = new boolean[n+1];
		for (int i = 0; i < n; i++)
			arr[i] = true;
			
		for (int i = 2; i*i <= n; i++) {
			//only for prime
			if (arr[i] == true) {
				//update all multiple of i
				for (int j = i*2 ; j<=n; j+=i) {
					arr[j] = false;
				}
			}
		}
		
		for (int i = 2; i<=n; i++) {
			if(arr[i] == true)
				System.out.print(i+" ");
		}
			
		}

}
