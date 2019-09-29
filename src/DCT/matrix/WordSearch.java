package DCT.matrix;

public class WordSearch {
	public static void main(String args[]) {
		char in[][] = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String str = "ABCB";
		System.out.println(cW(in, str));
	}

	public static boolean cW(char[][] in, String str) {
		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < in[i].length; j++) {
				if (in[i][j] == str.charAt(0) && containsWord(in, str, 1, i, j, '.')) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean containsWord(char[][] in, String str, int index, int i, int j, char last) {
		int m = in.length;
		int n = in[0].length;

		if (i > m || i < 0 || j > n || j < 0)
			return false;

		if (index == str.length())
			return true;
		
		if (i < m && i >= 0 && j < n && j >= 0) {
			if (last != 'u' && i + 1 < m && in[i + 1][j] == str.charAt(index)) {
				return containsWord(in, str, index + 1, i + 1, j, 'd');
			} else if (last != 'd' && i - 1 >= 0 && in[i - 1][j] == str.charAt(index)) {
				return containsWord(in, str, index + 1, i - 1, j, 'u');
			} else if (last != 'l' && j + 1 < n && in[i][j + 1] == str.charAt(index)) {
				return containsWord(in, str, index + 1, i, j + 1, 'r');
			} else if (last != 'r' && j - 1 >= 0 && in[i][j - 1] == str.charAt(index)) {
				return containsWord(in, str, index + 1, i, j - 1, 'l');
			} else {
				return false;
			}
		}

		return false;
	}
}
