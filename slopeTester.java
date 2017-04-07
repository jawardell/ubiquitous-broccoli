import java.util.*;
public class slopeTester {
	public static void main(String[] args) {
		int n = 0, g = 0, a = 0, m = 0;
		Scanner scanner = new Scanner(System.in);
		//int[][] array;
		System.out.print("0 - default corridor with custom gap");
		System.out.print("1 - corridor with custom gap & custom start position");
		System.out.print("2 - corridor with custom gap, start pos, and slope");
		System.out.print("Which would you like to do?");
		System.out.print("Enter 0, 1, or 2: ");
		int kind = Integer.parseInt(scanner.nextLine());
		switch (kind) {
			case 0 :
				System.out.print("enter n: ");
				n = Integer.parseInt(scanner.nextLine());
				System.out.print("enter gap: ");
				g = Integer.parseInt(scanner.nextLine());
				array = makeArray(n, g);
				break;
			case 1 :
				System.out.print("enter n: ");
				n = Integer.parseInt(scanner.nextLine());
				System.out.print("enter gap: ");
				g = Integer.parseInt(scanner.nextLine());
				System.out.print("enter start pos: ");
				a = Integer.parseInt(scanner.nextLine());
				array = makeArray(n, g, a);
				break;
			case 2 :
				System.out.print("enter n: ");
				n = Integer.parseInt(scanner.nextLine());
				System.out.print("enter gap: ");
				g = Integer.parseInt(scanner.nextLine());
				System.out.print("enter start pos: ");
				a = Integer.parseInt(scanner.nextLine());
				System.out.print("enter start slope: ");
				m = Integer.parseInt(scanner.nextLine());
				array = makeArray(n, g, a);
				break;

		}
		int[][] array = makeArray(n, g, a);
		for(int row = 0; row < array.length; row++) {
			for(int col = 0; col < array[0].length; col++) {
				if(col == array[0].length-1) {
					if(array[row][col] == -1) {
						System.out.printf("\u001b[1;31m%13s\u001b[0m", "#");
					} else {
						System.out.printf("%13d\n",array[row][col]);
					}
				} else {
					if(array[row][col] == -1) {
						System.out.printf("\u001b[1;31m%13s\u001b[0m", "#");
					} else {
						System.out.printf("%13d",array[row][col]);
					}
				}
			}
		}
	}
	public static int[][] makeArray(int n, int g) {
		int[][] array = new int[g + ((n+1)/2)][n];
		array[array.length-1][0] = 1;
		array[(array.length-g)-1][0] = -1;
		int rowneg = (array.length-g)-2;
		for(int col = 1; col <  array[0].length; col++) {
			if(rowneg == -1) { break; }
			array[rowneg][col] = -1;
			if(col % 2 == 0) { rowneg -= 1; }
		}
		for(int col = 1; col <= array[0].length-1; col++) {
			for(int row = array.length-1; (array[row][col] != -1); row--) {
				if((row == 0)) { array[row][col] = 0; break;}
				if(row == array.length-1) {
					array[row][col] = array[row-1][col-1];
				}
				else if(array[row-1][col-1] == -1) {
					array[row][col] = array[row+1][col-1];
				} else {
					array[row][col] = array[row-1][col-1] + array[row+1][col-1];
				}
			}
		}
		return array;
	}
	public static int[][] makeArray(int n, int g, int a) {
		int[][] array = new int[g + ((n+1)/2)][n];
		array[array.length-a][0] = 1;
		array[(array.length-g)-1][0] = -1;
		int rowneg = (array.length-g)-2;
		for(int col = 1; col < array [0].length; col++) {
			if(rowneg == -1) {break;}
			array[rowneg][col] = -1;
			if(col % 2 == 0) {rowneg -= 1;}
		}
		for(int col = 1; col <= array[0].length-1; col++) {
			for(int row = array.length-1; (array[row][col] != -1); row--) {
				if((row == 0)) { array[row][col] = 0; break;}
				if(row == array.length-1) {
					array[row][col] = array[row-1][col-1];
				}
				else if(array[row-1][col-1] == -1) {
					array[row][col] = array[row+1][col-1];
				} else {
					array[row][col] = array[row-1][col-1] + array[row+1][col-1];
				}
			}
		}
		return array;
	}
}