package StringsAndArrays;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class PrintUniquePairOfaddition {

	    // Complete the numberOfPairs function below.
	    static int numberOfPairs(int[] a, long k) {
	        Arrays.sort(a);
	        int start = 0;
	        int end = a.length - 1;
	        
	        Hashtable<Integer, Integer> ht = new Hashtable<>();
	        
	        //Set<ArrayList> uniqueSet = new Set<>();
	        
	        
	        while (start < end) {
	            if ((a[start] + a[end]) > k) {
	                end --;
	            } else if ((a[start] + a[end]) < k ) {
	                start++;
	            }
	            else {
	                ht.put(a[start],a[end]);
	                start++;
	                end--;
	            }
	        }
	        
	        Set<Integer> keys = ht.keySet();
	        for (int key : keys) {
	            System.out.println(key+">>"+ht.get(key));
	        }
	       
	   
	        return ht.size();


	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int aCount = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        int[] a = new int[aCount];

	        for (int i = 0; i < aCount; i++) {
	            int aItem = scanner.nextInt();
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	            a[i] = aItem;
	        }

	        long k = scanner.nextLong();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        int res = numberOfPairs(a, k);

	        bufferedWriter.write(String.valueOf(res));
	        bufferedWriter.newLine();

	        bufferedWriter.close();

	        scanner.close();
	    }
	}

}
