package DCT.Strings;

public class Armstrong {
	public static void main(String args[]) {
		int num = 1634;
		System.out.println(isArmstrong(num));
	}

	private static boolean isArmstrong(int num) {
		int sum = 0, i = 0, numdup = num;
		int order = String.valueOf(num).split("").length;
		System.out.println(order);
		while (i < order) {
			sum = (int) (sum + Math.pow(num % 10, order));
			num = num / 10;
			i++;
		}
		System.out.println(numdup+" "+sum);
		if (sum == numdup)
			return true;
		else
			return false;
	}
}
