
public class IllegalTriangleException extends Exception
{
	public IllegalTriangleException(double line1,double line2, double line3) {
		if(line1 + line2 <= line3) 
		{
			System.out.println("new Triangle (" + line1 + "," + line2 + "," + line3+"), "
					+ "violates the rule since " + line1 + " + " + line2 + " <= " + line3);
		}
		else if(line1 + line3 <= line2) 
		{
			System.out.println("new Triangle (" + line1 + "," + line2 + "," + line3 + "), "
					+ "violates the rule since "+line1+" + "+line3+" <= "+line2);
		}
		else if(line2 + line3 <= line1) {
			System.out.println("new Triangle (" + line1 + "," + line2 + "," + line3 + "), "
					+ "violates the rule since " + line2 + " + " + line3 + " <= " + line1);
		}
	}
}
