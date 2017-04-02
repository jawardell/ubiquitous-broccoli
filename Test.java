import java.util.*;
public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = 20, top = 1, bottom = -2;
		System.out.println("Enter top number: ");
		top = scanner.nextInt();
		System.out.println("Enter bottom number: ");
		bottom = scanner.nextInt();
		System.out.println("Enter n: ");
		n = scanner.nextInt();
		System.out.println("Multiple Check: ");
		int num = scanner.nextInt();
		int[][] array = makeArray(n, top, bottom);
		for (int row = 1; row <= n; row++) {
			for (int col = 0; col < n; col++) {
				if (col == n - 1) {
					System.out.printf("%10d\n", array[row][col]);
				} else {
					System.out.printf("%10d", array[row][col]);
				}
			}
		}
		System.out.print("\n\n\n");
		for (int row = 1; row <= n; row++) {
			for (int col = 0; col < n; col++) {
				if (col == n - 1) {
					System.out.printf("%10d\n", array[row][col]);
				} else if (array[row][col] == 0) {
					System.out.print("          ");

				} else if (array[row][col] % num == 0) {
					System.out.printf("\u001b[1;31m%10d\u001b[0m", array[row][col]);
				} else if (isPerfectS(array[row][col])) {
					System.out.printf("\u001b[1;34m%10d\u001b[0m", array[row][col]);
				} else {
					System.out.printf("%10d", array[row][col]);
				}
			}
		}

	}
	public static int[][] makeArray(int n, int topNum, int bottomNum) {
		int topRow = 0;
		int bottomRow = 0;
		int col1 = 0;
		// make new array of size [n+1][n+1]
		int[][] array = new int[n + 2][n + 3];// row padidng = 1, col padding 2
		if (n % 2 == 0) {
			topRow = (n / 2) - 1;
		}
		if (n % 2 != 0) {
			topRow = n / 2;
		}
		bottomRow = topRow + 2;
		array[topRow][0] = topNum;
		array[bottomRow][0] = bottomNum;

		// initialize top and bottom values
		for (int row = topRow; row > 0; row--) {
			array[row][col1] = topNum;
			col1 += 1;
		}

		col1 = 0;
		for (int row = bottomRow; row <= n; row++) {
			array[row][col1] = bottomNum;
			col1 += 1;
		}

		col1 = 1;
		for (int row = topRow + 1; row > 0; row--) {
			array[row][col1] = array[row - 1][col1 - 1] + array[row + 1][col1 - 1];
			col1 += 1;
		}
		col1 = 1;
		for (int row = topRow + 1; row < n; row++) {
			array[row][col1] = array[row - 1][col1 - 1] + array[row + 1][col1 - 1];
			col1 += 1;
		}
		for (int col = 1; col < n; col++) {
			for (int row = 1; row < n; row++) {
				array[row][col + 1] = array[row - 1][col] + array[row + 1][col];
			}
		}

		return array;
	}
	public static boolean isPrime(int n) {
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static boolean isPerfectS(int n) {
		int temp = n;
		int count = 1;
		while (temp > 0) {
			temp = temp - count;
			count = count + 2;
		}
		if (temp == 0) {
			return true;
		}
		return false;
	}
}