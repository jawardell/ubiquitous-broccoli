public class Main {
	public static void main(String[] args) {
		System.out.println("\n\n");
		for(int i = 0; i < 5; i++) {
			System.out.println("Diagonal " + i + "\n");
			for(int j = 0; j < 20; j++) {
				if(j == 19) {
					System.out.print("C" + j
					 + " " +  doDiagonal(i, j) + "\n\n");
				} else {
					System.out.print("C" + j
					 + " " + doDiagonal(i, j) +  "\n");
				}
			}
			System.out.println("\n\n");
		}	
	}

	public static int doDiagonal(int i, int j) {
		switch(i) {
			case 0:
			return diagonal0(j);
			case 1: 
			return diagonal1(j);
			case 2:
			return diagonal2(j);
			case 3:
			return diagonal3(j);
			case 4: 
			return diagonal4(j);
			default:
			return Integer.MIN_VALUE;
		}
	}

	public static int diagonal0(int i) {
		return 1;
	}
	public static int diagonal1(int i) {
		return (int)(2*i - 1);
	}
	public static int diagonal2(int i) {
		return (int)(2*Math.pow(i,2)+ 9*i + 3);
	}
	public static int diagonal3(int i) {
		return(int)((4/3) * Math.pow(i, 3) + 16*Math.pow(i, 2)
		+ (149/3)*i + 13);
	}
	public static int diagonal4(int i) {
		return (int)((2/3)*Math.pow(i, 4)
		 + (46/3)*Math.pow(i, 3)
		 + (707/6)*Math.pow(i, 2)
		 + (1867/6)*i + 68);
	}

}
