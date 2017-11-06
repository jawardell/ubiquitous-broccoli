/**
 * Created by jawardell on 7/7/17.
 */
public class Sequences {

	public static void main(String[] args) {
		try {
			int limit = Integer.MAX_VALUE;
			for(int g = 1; g <= 4; g++) {
				System.out.print("Sequences in corridor g = " + g + "\n");
				for(int d = 1; d <=4; d++) {
					for(int i = 1; i <= d; i++) {
						boolean madeit = false;
						if((d == 1) && (i == 1)) {
							limit = 2*g;
							madeit = true;
						}
						if((d == 2) && (i == 1)) {
							limit = 2*g-1;
							madeit = true;
						}
						if((d == 3) && (i == 1)) {
							limit = 2*g+1;
							madeit = true;
						}
						if((d == 4) && (i == 1)) {
							limit = 2*g+3;
							madeit = true;
						}
						if(!madeit) {
							limit= 4;
						}
						for(int x = 1; x <= limit; x++) {
							if((x == limit) && (i == d)) {
								System.out.print((int)doit(i, d, x, g) + "\n\n");
							} else if (x == limit) {
								System.out.print((int)doit(i, d, x, g) + "\t\t");
							} else {
								System.out.print(" " + (int)doit(i, d, x, g) + " ");
							}

						}
					}
				}
				System.out.println("\n");
			}

		} catch(Exception e) {
			System.out.print("\n\n\tcheck input, try again");
		}


	}

	public static double doit(int i, int d, double x, double g) throws Exception {
		switch (d) {
			case 1 :
				return seq1(x, g);
			case 2 :
				if(i == 1) {
					return seq2(x, g);
				}
				return seq3(x, g);
			case 3 :
				if(i == 1) {
					return seq4(x, g);
				} else if(i == 2) {
					return seq5(x, g);
				}
				return seq6(x, g);
			case 4 :
				if(i == 1) {
					return seq7(x, g);
				}
				return seq8(x, g);
			default :
				throw new Exception();


		}

	}

	public static double seq1(double x, double g) {
		return 1;

	}


	public static double seq2(double x, double g) {
		return x;
	}

	public static double seq3(double x, double g) {
		return 2*g - 1;
	}

	public static double seq4(double x, double g) {
		return (2*g-1)*x + (2*g-3);
	}


	public static double seq5(double x, double g) {
		return 2*Math.pow(g,2) + 5*g - 4;
	}


	public static double seq6(double x, double g) {
		return (Math.pow(x,3)+9*Math.pow(x,2) + 20*x)/6;
	}


	public static double seq7(double x, double g) {
		return (Math.pow(x,2)+3*x)/2;
	}

	public static double seq8(double x, double g) {
		return 	(((2*g-1)/2)*Math.pow(x,2))
			+ (((4*Math.pow(g,2)-4*g-1)/2)*x)
			+ ((4*Math.pow(g,3)-6*Math.pow(g,2) - 4*g)/3);
	}


}
