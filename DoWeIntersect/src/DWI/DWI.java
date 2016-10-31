package DWI;
import java.util.Scanner;

public class DWI {
	
	public static void main(String[] args)
	{
		Scanner in = new  Scanner(System.in);
		System.out.println("Please input the first point (x,y) for the first line: ");
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		System.out.println("Please input the second point (x,y) for the first line: ");
		int x2 = in.nextInt();
		int y2 = in.nextInt();
		System.out.println("Please input the first point (x,y) for the second line: ");
		int x3 = in.nextInt();
		int y3 = in.nextInt();
		System.out.println("Please input the second point (x,y) for the second line: ");
		int x4 = in.nextInt();
		int y4 = in.nextInt();
		
		if (x1 == x2 && y1 == y2 || x3 == x4 && y3 == y4)
		{
			System.out.println("Intersection");
			System.exit(0);
		}		
		int ax = x2-x1;
		int ay = y2-y1;
		int bx = x3-x4;
		int by = y3-y4;
		int cx = x1-x3;
		int cy = y1-y3;

		int alphaNumerator = by*cx - bx*cy;
		int commonDenominator = ay*bx - ax*by;
		if (commonDenominator > 0){
			if (alphaNumerator < 0 || alphaNumerator > commonDenominator){
				System.out.println("No Intersection");	
				System.exit(0);
		         }
		}else if (commonDenominator < 0){
			if (alphaNumerator > 0 || alphaNumerator < commonDenominator){
				System.out.println("No Intersection");
				System.exit(0);
			}
		}
		double betaNumerator = ax*cy - ay*cx;
		if (commonDenominator > 0){
			if (betaNumerator < 0 || betaNumerator > commonDenominator){
				System.out.println("No Intersection");
				System.exit(0);
			}
		}else if (commonDenominator < 0){
			if (betaNumerator > 0 || betaNumerator < commonDenominator){
				System.out.println("No Intersection");
				System.exit(0);
			}
		}
		if (commonDenominator == 0){

			int y3LessY1 = y3-y1;
			int collinearityTestForP3 = x1*(y2-y3) + x2*(y3LessY1) + x3*(y1-y2);  			
			if (collinearityTestForP3 == 0){				
				if (x1 >= x3 && x1 <= x4 || x1 <= x3 && x1 >= x4 ||
						x2 >= x3 && x2 <= x4 || x2 <= x3 && x2 >= x4 ||
						x3 >= x1 && x3 <= x2 || x3 <= x1 && x3 >= x2){
					if (y1 >= y3 && y1 <= y4 || y1 <= y3 && y1 >= y4 ||
							y2 >= y3 && y2 <= y4 || y2 <= y3 && y2 >= y4 ||
							y3 >= y1 && y3 <= y2 || y3 <= y1 && y3 >= y2){
						System.out.println("Intersection");
						System.exit(0);
					}
				}
			}
			System.out.println("No Intersection");
			System.exit(0);
 	}
		System.out.println("Intersection");	
		in.close();		
	}
}
