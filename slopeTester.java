import java.util.Scanner;

/**
 * Created by jawardell on 6/16/17.
 */
public class slopeTester {
	public static void main(String[] args) {
		System.out.print("[1] -- Terminal\n[0] -- Other\n");
		Scanner scanner = new Scanner(System.in);
		try {
			int i = scanner.nextInt();
			switch(i) {
				case 1 :
					for(int z = 1; z < 12; z++) {
						System.out.print("\n\nG = " + z);
						print(makeArray(30,z));

					}
					break;
				case 0:
					for(int z = 1; z < 12; z++) {
						System.out.print("\n\nG = " + z);
						print2(makeArray(30,z));

					}
					break;
				default:
					throw new Exception();
			}

		} catch (Exception e) {
			System.out.print("\n\n\twrong input. try again.");
		}
		//print corridors C0 to C11

	}







	public static void print(int[][] array) {
		System.out.println();
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {

				boolean needsNewLine = j == array[0].length-1;
				boolean isSentinel = array[i][j] == -1;
				boolean notZero = array[i][j] != 0;


				boolean isSafe = (((i >= 1) && (j < array[0].length-1)) && (i != array.length-1))&&(j != 0);
				boolean lowerleft = isSafe && array[i][j] == array[i + 1][j - 1];
				boolean upperright = isSafe ? array[i][j] == array[i-1][j+1] :false;
				boolean LLorUR = lowerleft || upperright;
				boolean both = lowerleft && upperright;
				boolean isQualified = LLorUR || both;
				boolean isFirstEntry = (i == array.length-1)&&(j == 0);
				boolean isCornerEntry =  (((j == array[0].length-1) &&
						(j != 0)) && (i != array.length-1)) ? (j == array[0].length-1 && notZero)
						&& array[i+1][j-1] == array[i][j] : false;
				boolean specialCase = isCornerEntry || isFirstEntry;
				boolean isDiagonal =  ((isSafe&&notZero) && (isQualified)) || (specialCase);
				boolean needsColoring =  ((!isSentinel && isSafe) && isDiagonal)||(isDiagonal && specialCase);



				if(needsColoring && needsNewLine) {
					System.out.printf("\u001b[1;31m%13d\u001b[0m\n", array[i][j]);
					continue;
				}
				if(needsColoring && !needsNewLine) {
					System.out.printf("\u001b[1;31m%13d\u001b[0m", array[i][j]);
					continue;
				}

				if(needsNewLine && isSentinel) {
					System.out.printf("\u001b[1;34m%13s\u001b[0m\n", "$$$$");
				}
				if(!needsNewLine && isSentinel) {
					System.out.printf("\u001b[1;34m%13s\u001b[0m", "$$$$");
				}


				if(needsNewLine && !isSentinel) {
					System.out.printf("%13d\n", array[i][j]);
				}
				if(!needsNewLine && !isSentinel) {
					System.out.printf("%13d", array[i][j]);
				}

			}
		}
		System.out.print("\n\n\n");
	}



	public static void print2(int[][] array){
		System.out.println();
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {

				boolean needsNewLine = j == array[0].length - 1;
				boolean isSentinel = array[i][j] == -1;
				boolean notZero = array[i][j] != 0;

				if(needsNewLine && isSentinel) {
					System.out.printf("%13s\n", "$$$$");
				}
				if(!needsNewLine && isSentinel) {
					System.out.printf("%13s", "$$$$");
				}


				if(needsNewLine && !isSentinel) {
					System.out.printf("%13d\n", array[i][j]);
				}
				if(!needsNewLine && !isSentinel) {
					System.out.printf("%13d", array[i][j]);
				}

			}
		}
		System.out.print("\n\n\n");
	}







	public static int[][] makeArray(int n, int g) {
		int[][] array = new int[g + ((n + 1) / 2)][n];
		array[array.length - 1][0] = 1;
		array[(array.length - g) - 1][0] = -1;
		int rowneg = (array.length - g) - 2;

		if (g == 1) {
			array[array.length - 1][2] = 1;
		}

		for (int col = 1; col < array[0].length; col++) {
			if (rowneg == -1) {
				break;
			}
			array[rowneg][col] = -1;
			if (col % 2 == 0) {
				rowneg -= 1;
			}
		}

		for (int col = 1; col <= array[0].length - 1; col++) {
			for (int row = array.length - 1; (array[row][col] != -1); row--) {
				boolean onecase = (g == 1) && ((row == array.length - 1) && (col == 1));
				if ((row == 0)) {
					array[row][col] = 0;
					break;
				}
				if (row == array.length - 1 && !onecase) {
					array[row][col] = array[row - 1][col - 1];
				} else if ((array[row - 1][col - 1] == -1)) {
					if (row != array.length - 1) {
						array[row][col] = array[row + 1][col - 1];
						array[row][col] = array[row + 1][col - 1];
					}

				} else {
					array[row][col] = array[row - 1][col - 1] + array[row + 1][col - 1];
				}
			}
		}
		return array;
	}
	
	
	public static int[][] makeArray(int n, int g, int a) {
		int[][] array = new int[g + ((n + 1) / 2)][n];
		array[array.length - a][0] = 1;
		array[(array.length - g) - 1][0] = -1;
		int rowneg = (array.length - g) - 2;
		for (int col = 1; col < array[0].length; col++) {
			if (rowneg == -1) {
				break;
			}
			array[rowneg][col] = -1;
			if (col % 2 == 0) {
				rowneg -= 1;
			}
		}
		for (int col = 1; col <= array[0].length - 1; col++) {
			for (int row = array.length - 1; (array[row][col] != -1); row--) {
				if ((row == 0)) {
					array[row][col] = 0;
					break;
				}
				if (row == array.length - 1) {
					array[row][col] = array[row - 1][col - 1];
				} else if (array[row - 1][col - 1] == -1) {
					array[row][col] = array[row + 1][col - 1];
				} else {
					array[row][col] = array[row - 1][col - 1] + array[row + 1][col - 1];
				}
			}
		}
		return array;
	}

	
	
	
	public static int[][] makeArray(int n, int g, int a, int m) {
		int[][] array = new int[g + ((n + 1) / 2)][n];
		array[array.length - a][0] = 1;
		array[(array.length - g) - 1][0] = -1;
		int rowneg = (array.length - g) - 2;
		for (int col = 1; col < array[0].length; col++) {
			if (rowneg == -1) {
				break;
			}
			array[rowneg][col] = -1;
			if (col % m == 0) {
				rowneg -= 1;
			}
		}
		for (int col = 1; col <= array[0].length - 1; col++) {
			for (int row = array.length - 1; (array[row][col] != -1); row--) {
				if ((row == 0)) {
					array[row][col] = 0;
					break;
				}
				if (row == array.length - 1) {
					array[row][col] = array[row - 1][col - 1];
				} else if (array[row - 1][col - 1] == -1) {
					array[row][col] = array[row + 1][col - 1];
				} else {
					array[row][col] = array[row - 1][col - 1] + array[row + 1][col - 1];
				}
			}
		}
		return array;
	}
	
	
	//test for probs with # going to new line
	//add option for output in CVS format
	//add option for rise over run slope
	//add option for 1/m slope
	//might extend to include negative numbers for reflection purposes
	//maybe
	//big: change to ask for n later, not first..
	//no "paths" can cross bound
	//i plan to make this more elegant and less scary
	//logical redunancies and bugs
}
