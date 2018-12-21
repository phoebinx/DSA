package misc;

import java.util.Scanner;

public class CalcPower {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number");
		int num = scan.nextInt();
		System.out.println("Enter power");
		int pow = scan.nextInt();
		System.out.println(Integer.toString(powerOf(num, pow)));
	}

	public static int powerOf(int num, int pow) {
		// TODO Auto-generated method stub
		int res=1;
		if (pow == 0) {
			return 1;
		}
		while (pow != 0) {
			res = res * num;
			pow--;
		}
		return res;
	}

}
