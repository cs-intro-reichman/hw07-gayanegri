/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

         
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
	    //  and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		// curve(Integer.parseInt(args[0]),
			  // Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      // Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if(n == 0) {
			StdDraw.line(x1, y1, x2, y2);
			return;
		}

		double thirdX = x1 + (x2 - x1) / 3;
		double thirdY = y1 + (y2 - y1) / 3;
		double towThirdX = x1 +  2 * (x2 - x1) / 3;
		double towThirdY = y1 +  2 * (y2 - y1) / 3;
		double upX = Math.sqrt(3) / 6 * (y1 - y2) + 0.5 * (x1 + x2);
		double upY = Math.sqrt(3) / 6 * (x2 - x1) + 0.5 * (y1 + y2);


		curve(n - 1, x1, y1, thirdX, thirdY);
		curve(n - 1, thirdX, thirdY, upX, upY);
		curve(n - 1, upX, upY, towThirdX, towThirdY);
		curve(n - 1, towThirdX, towThirdY, x2, y2);
	}

	
    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		double hight = Math.sqrt(3) / 2;
		curve(n, 0, hight, 1, hight);
		curve(n, 1, hight, 0.5, 0);
		curve(n, 0.5, 0, 0, hight);
	}

}
